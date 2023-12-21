package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.factory.FlightsDAOFactory;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.FlightsService;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IFlightsService;

public class FlightsServiceFactory {

    private static volatile IFlightsService instance;

    private FlightsServiceFactory() {
    }

    public static IFlightsService getInstance() {
        if (instance == null) {
            synchronized (FlightsServiceFactory.class) {
                if (instance == null) {
                    instance = new FlightsService(FlightsDAOFactory.getInstance());
                }
            }
        }
        return instance;
    }

}
