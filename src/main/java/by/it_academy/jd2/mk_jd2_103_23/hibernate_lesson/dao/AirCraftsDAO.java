package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Aircraft;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IAirCraftsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.entity.AircraftEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class AirCraftsDAO implements IAirCraftsDAO {
    private final SessionFactory sessionFactory;

    public AirCraftsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Aircraft> getAirCraftsList() {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query<AircraftEntity> query = session.createQuery("FROM AircraftEntity", AircraftEntity.class);

            List<Aircraft> aircraftList = query.getResultList().stream()
                    .map(aircraftEntity -> new Aircraft(aircraftEntity.getAirCraftCode(),
                            aircraftEntity.getModel(), aircraftEntity.getRange()))
                    .collect(Collectors.toList());

            transaction.commit();
            return aircraftList;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new IllegalStateException("Error getting aircraft information", e);
        }
    }
}
