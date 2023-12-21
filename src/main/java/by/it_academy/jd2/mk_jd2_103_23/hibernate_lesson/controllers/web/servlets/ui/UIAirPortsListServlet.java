package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.controllers.web.servlets.ui;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.AirPort;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IAirPortService;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.factory.AirPortServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirPortsListServlet", urlPatterns = "/airportslist")
public class UIAirPortsListServlet extends HttpServlet {

    private final IAirPortService service;

    public UIAirPortsListServlet() {
        this.service = AirPortServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AirPort> airPortsList = this.service.getAll();
        req.setAttribute("airPorts", airPortsList);
        req.getRequestDispatcher("/view/airportslist.jsp").forward(req, resp);
    }
}
