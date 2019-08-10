package com.exam.servlet;

import com.exam.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class AddPhoneServlet extends HttpServlet {
    private SessionFactory hibernateSessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brands", Arrays.asList(Phone.Brand.values()));
        req.getRequestDispatcher("/phone/addphones.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int brand = Integer.parseInt(req.getParameter("brand"));
        String description = req.getParameter("description");
        float price = 0;
        try {
            price = Float.parseFloat(req.getParameter("price"));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        Phone phone = Phone.Builder.aPhone()
                .withBrand(brand)
                .withName(name)
                .withPrice(price)
                .withDescription(description)
                .build();
        Session hibernateSession = hibernateSessionFactory.openSession();
        Transaction transaction = hibernateSession.getTransaction();
        transaction.begin();
        hibernateSession.save(phone);
        transaction.commit();
        resp.sendRedirect("/phone/list");
    }
}
