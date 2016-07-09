/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import osa.ora.bd.impl.LoginBD;
import osa.ora.beans.Login;
import osa.ora.log.Logger;

/**
 *
 * @author keyur
 */
@WebServlet(name = "StudentLoginServlet", urlPatterns = {"/StudentLoginServlet"})
public class StudentLoginServlet extends HttpServlet {
 private static Logger logger = Logger.getLogger("StudentLoginServlet");
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("enter....");
        logger.debug("enter....");
        Login login = new Login();
        login.setUserName(request.getParameter("txtUserName"));
        login.setPassword(request.getParameter("txtPass"));
        HttpSession session=request.getSession();
        session.setAttribute("voucher", login.getUserName());
        LoginBD loginBD = LoginBD.getExamBDInstance();
        if (loginBD.loginProcess(login)) {
            out.print("if.......");
            logger.debug("If.....");
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("OnlineExaminationSystem/Exam.jsp"); 
////        request.setAttribute("servlet", "example"); 
//        dispatcher.forward(request, response);
        
        response.sendRedirect("/OnlineExaminationSystem/Exam.jsp");
//            response.sendRedirect("../Exam.jsp");
        } else {
            out.print("else....");
            logger.debug("else.....");
            response.sendRedirect("/OnlineExaminationSystem/Exam.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
