package com.exam.servlet;

import com.exam.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListPhoneServlet extends HttpServlet {
    private SessionFactory hibernateSessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibernateSession = hibernateSessionFactory.openSession();
        List<Phone> phones = hibernateSession.createCriteria(Phone.class).list();
        req.setAttribute("phones", phones);
        req.getRequestDispatcher("/phone/listphone.jsp").forward(req, resp);
    }
}
