package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.FlightsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IFlightsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.data_source.HibernateSessionFactory;

public class FlightsDAOFactory {
    private static volatile IFlightsDAO instance;

    private FlightsDAOFactory() {
    }

    public static IFlightsDAO getInstance() {
        if (instance == null) {
            synchronized (FlightsDAOFactory.class) {
                if (instance == null) {
                    instance = new FlightsDAO(HibernateSessionFactory.getSessionFactory());
                }
            }
        }
        return instance;
    }
}
