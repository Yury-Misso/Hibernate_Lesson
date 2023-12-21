package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.controllers.web.servlets.ui;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Aircraft;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IAirCraftService;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.factory.AirCraftServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirPlaneListServlet", urlPatterns = "/airplanelist")
public class UIAirPlanesListServlet extends HttpServlet {

    private final IAirCraftService service;

    public UIAirPlanesListServlet() {
        this.service = AirCraftServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aircraft> airCraftsList = this.service.getAll();
        req.setAttribute("airCrafts", airCraftsList);
        req.getRequestDispatcher("/view/airplaneslist.jsp").forward(req, resp);
    }
}
