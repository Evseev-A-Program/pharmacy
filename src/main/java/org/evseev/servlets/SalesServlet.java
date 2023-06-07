package org.evseev.servlets;

import org.evseev.model.Sales;
import org.evseev.service.NaklTitlerService;

import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

public class SalesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object page = request.getParameter("page");
        if (page != null) {
            page = Integer.valueOf((String) page);
            request.setAttribute("page", page);
        }
        String sales = new NaklTitlerService().getAllNaklTitlers();
        request.setAttribute("sales", sales);
        request.getRequestDispatcher("/WEB-INF/views/sales.jsp").forward(request, response);
    }
}