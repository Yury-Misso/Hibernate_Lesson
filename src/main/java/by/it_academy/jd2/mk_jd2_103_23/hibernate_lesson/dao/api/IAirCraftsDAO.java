package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Aircraft;

import java.util.List;

public interface IAirCraftsDAO {
    List<Aircraft> getAirCraftsList();
}
