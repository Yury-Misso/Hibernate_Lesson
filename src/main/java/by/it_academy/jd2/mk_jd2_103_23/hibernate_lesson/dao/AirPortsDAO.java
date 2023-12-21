package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao;


import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.AirPort;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IAirPortsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.entity.AirPortEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class AirPortsDAO implements IAirPortsDAO {
    private final SessionFactory sessionFactory;

    public AirPortsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AirPort> getAirPortsList() {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<AirPortEntity> criteriaQuery = criteriaBuilder.createQuery(AirPortEntity.class);
            Root<AirPortEntity> root = criteriaQuery.from(AirPortEntity.class);
            criteriaQuery.select(root);

            List<AirPort> airPortList = session.createQuery(criteriaQuery).getResultList().stream()
                    .map(airPortEntity -> new AirPort(airPortEntity.getAirportCode(),
                            airPortEntity.getAirportName(),
                            airPortEntity.getCity(),
                            airPortEntity.getCoordinates(),
                            airPortEntity.getTimeZone()))
                    .collect(Collectors.toList());

            transaction.commit();

            return airPortList;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new IllegalStateException("Error getting AirPort information", e);
        }
    }
}
