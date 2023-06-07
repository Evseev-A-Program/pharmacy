package org.evseev.servlets;

import org.evseev.service.NaklDataRService;
import org.evseev.service.NaklTitlerService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ChequeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("NaklTitlerId"));
        String contents = new NaklDataRService().getNaklDataRAllById(id);
        request.setAttribute("contents", contents);
        request.setAttribute("chequeId", id);
        request.getRequestDispatcher("/WEB-INF/views/cheque.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
