/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author HELLO
 */
public class forgotpasswordservlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String email =request.getParameter("email");
           String newpassword =request.getParameter("newpass");
           String conpassword =request.getParameter("connewpass");
            
             try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl_project","root","tiger")) {
                if(newpassword.equals(conpassword))
                {    
                PreparedStatement ps;
                ps = conn.prepareStatement("update doctorinfo set password=? where email=?");
                ps.setString(2,email);
                ps.setString(1,newpassword);
                
                int i=ps.executeUpdate();
                if(i>0)
                {  
                    
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                    out.println("<html><head></head><body onload=\"alert('Password Successfully changed')\"></body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("doctorlogin.html");
                    rd.include(request, response);
                }
                ps.close();
                conn.close();
                }
                else
                {
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                     out.println("<html><head></head><body onload=\"alert('Password Change Failed..Try Again')\"></body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("forgotpswd.html");
                    rd.include(request, response);
                }
                
                
            }
            }
            
                            
       
        catch(ClassNotFoundException | SQLException e)
        {
           out.println("Connection problem");
        }
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
