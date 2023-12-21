package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.AirCraftsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IAirCraftsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.data_source.HibernateSessionFactory;

public class AirCraftsDAOFactory {
    private static volatile IAirCraftsDAO instance;

    private AirCraftsDAOFactory() {
    }

    public static IAirCraftsDAO getInstance() {
        if (instance == null) {
            synchronized (AirCraftsDAOFactory.class) {
                if (instance == null) {
                    instance = new AirCraftsDAO((HibernateSessionFactory.getSessionFactory()));
                }
            }
        }
        return instance;
    }
}
