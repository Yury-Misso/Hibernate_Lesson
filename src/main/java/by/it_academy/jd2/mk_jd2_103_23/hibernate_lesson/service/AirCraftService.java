package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Aircraft;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IAirCraftsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IAirCraftService;

import java.util.List;

public class AirCraftService implements IAirCraftService {
    private final IAirCraftsDAO dao;

    public AirCraftService(IAirCraftsDAO dao) {
        this.dao = dao;
    }


    @Override
    public List<Aircraft> getAll() {
        return this.dao.getAirCraftsList();
    }
}
