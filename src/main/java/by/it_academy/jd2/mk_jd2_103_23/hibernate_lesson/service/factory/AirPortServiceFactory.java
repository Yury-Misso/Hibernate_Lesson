package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.factory.AirPortsDAOFactory;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.AirPortService;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IAirPortService;

public class AirPortServiceFactory {
    private static volatile IAirPortService instance;

    private AirPortServiceFactory() {
    }

    public static IAirPortService getInstance() {
        if (instance == null) {
            synchronized (AirPortServiceFactory.class) {
                if (instance == null) {
                    instance = new AirPortService(AirPortsDAOFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
