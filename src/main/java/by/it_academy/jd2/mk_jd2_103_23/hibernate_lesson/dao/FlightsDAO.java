package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Flight;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IFlightsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.entity.FlightEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsDAO implements IFlightsDAO {

    private final SessionFactory sessionFactory;

    public FlightsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Flight> getFlightsList() {

        Transaction transaction = null;
        List<Flight> flightList;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<FlightEntity> criteriaQuery = criteriaBuilder.createQuery(FlightEntity.class);

            Root<FlightEntity> root = criteriaQuery.from(FlightEntity.class);

            criteriaQuery.select(root);

            flightList = session.createQuery(criteriaQuery).getResultList().stream()
                    .map(flightEntity -> new Flight(flightEntity.getFlightId(),
                            flightEntity.getFlightNo(),
                            flightEntity.getScheduledDeparture(),
                            flightEntity.getScheduledArrival(),
                            flightEntity.getDepartureAirport(),
                            flightEntity.getArrivalAirport(),
                            flightEntity.getStatus(),
                            flightEntity.getAircraftCode(),
                            flightEntity.getActualDeparture(),
                            flightEntity.getActualArrival()))
                    .collect(Collectors.toList());

            transaction.commit();
            return flightList;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("!!! Error getting list flights !!! ", e);
        }
    }

    @Override
    public List<Flight> getFlightsList(PageParam pageParam, FlightFilters flightFilters) {

        Transaction transaction = null;
        List<FlightEntity> flightEntities;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<FlightEntity> criteriaQuery = criteriaBuilder.createQuery(FlightEntity.class);
            Root<FlightEntity> root = criteriaQuery.from(FlightEntity.class);

            Predicate[] predicatesArray = getPredicateArr(flightFilters, criteriaBuilder, root);

            criteriaQuery.select(root).where(criteriaBuilder.and(predicatesArray));
            Query<FlightEntity> query = session.createQuery(criteriaQuery);

            int sizePage = pageParam.getSizePage();
            int pageNo = pageParam.getPageNo();
            int offSet = (pageNo - 1) * sizePage;

            query.setFirstResult(offSet);
            query.setMaxResults(sizePage);

            flightEntities = query.getResultList();

            CriteriaBuilder criteriaBuilderLong = session.getCriteriaBuilder();
            CriteriaQuery<Long> longCriteriaQuery = criteriaBuilderLong.createQuery(Long.class);
            Root<FlightEntity> flightEntityRoot = longCriteriaQuery.from(FlightEntity.class);
            predicatesArray = getPredicateArr(flightFilters, criteriaBuilderLong, flightEntityRoot);
            CriteriaQuery<Long> where = longCriteriaQuery.select(criteriaBuilderLong.count(flightEntityRoot)).where(criteriaBuilderLong.and(predicatesArray));
            int maxItem = Math.toIntExact(session.createQuery(where).getSingleResult());
            pageParam.setMaxPage((int) Math.ceil((double) maxItem / sizePage));

            transaction.commit();

            return convertToFlightsList(flightEntities);

        } catch (Exception e) {
            if (transaction != null) {
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            throw new RuntimeException("!!! Error getting list flights !!! ", e);
        }

    }

    @Override
    public int getCount() {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

            Root<FlightEntity> root = criteriaQuery.from(FlightEntity.class);

            criteriaQuery.select(criteriaBuilder.count(root));

            Query<Long> query = session.createQuery(criteriaQuery);

            int intExact = Math.toIntExact(query.getSingleResult());

            transaction.commit();

            return intExact;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("!!! Error getting count flights !!! ", e);
        }

    }

    private Predicate[] getPredicateArr(FlightFilters flightFilters, CriteriaBuilder criteriaBuilder, Root<FlightEntity> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (flightFilters != null) {
            if (flightFilters.getFlightId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("flightId"), flightFilters.getFlightId()));
            }
            if (flightFilters.getFlightNo() != null) {
                predicates.add(criteriaBuilder.equal(root.get("flightNo"), flightFilters.getFlightNo()));
            }
            if (flightFilters.getScheduledDeparture() != null) {
                predicates.add(criteriaBuilder.equal(root.get("scheduledDeparture"), flightFilters.getScheduledDeparture()));
            }
            if (flightFilters.getScheduledArrival() != null) {
                predicates.add(criteriaBuilder.equal(root.get("scheduledArrival"), flightFilters.getScheduledArrival()));
            }
            if (flightFilters.getDepartureAirport() != null) {
                predicates.add(criteriaBuilder.equal(root.get("departureAirport"), flightFilters.getDepartureAirport()));
            }
            if (flightFilters.getArrivalAirport() != null) {
                predicates.add(criteriaBuilder.equal(root.get("arrivalAirport"), flightFilters.getArrivalAirport()));
            }
            if (flightFilters.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), flightFilters.getStatus()));
            }
            if (flightFilters.getAircraftCode() != null) {
                predicates.add(criteriaBuilder.equal(root.get("aircraftCode"), flightFilters.getAircraftCode()));
            }
            if (flightFilters.getActualDeparture() != null) {
                predicates.add(criteriaBuilder.equal(root.get("actualDeparture"), flightFilters.getActualDeparture()));
            }
            if (flightFilters.getActualArrival() != null) {
                predicates.add(criteriaBuilder.equal(root.get("actualArrival"), flightFilters.getActualArrival()));
            }
        }
        return predicates.toArray(new Predicate[0]);
    }

    private List<Flight> convertToFlightsList(List<FlightEntity> flightEntities) {
        return flightEntities.stream()
                .map(flightEntity -> new Flight(flightEntity.getFlightId(),
                        flightEntity.getFlightNo(),
                        flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledArrival(),
                        flightEntity.getDepartureAirport(),
                        flightEntity.getArrivalAirport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraftCode(),
                        flightEntity.getActualDeparture(),
                        flightEntity.getActualArrival()))
                .collect(Collectors.toList());
    }


}
