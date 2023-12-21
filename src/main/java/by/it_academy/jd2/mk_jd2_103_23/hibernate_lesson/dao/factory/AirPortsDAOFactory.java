package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.AirPortsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IAirPortsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.data_source.HibernateSessionFactory;

public class AirPortsDAOFactory {
    private static volatile IAirPortsDAO instance;

    private AirPortsDAOFactory() {
    }

    public static IAirPortsDAO getInstance() {
        if (instance == null) {
            synchronized (AirPortsDAOFactory.class) {
                if (instance == null) {
                    instance = new AirPortsDAO((HibernateSessionFactory.getSessionFactory()));
                }
            }
        }
        return instance;
    }
}
