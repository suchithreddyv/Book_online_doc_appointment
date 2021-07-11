/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HELLO
 */
public class patientloginservlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email= request.getParameter("mail");
            String pass= request.getParameter("psw");
            
             try{
               
               Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl_project","root","tiger"))
                {
                    String q="select * from patientinfo where email=? and password=?";
                   PreparedStatement ps = conn.prepareStatement(q); 
                       ps.setString(1,email);
                       ps.setString(2,pass);
                       ResultSet rs= ps.executeQuery();
                       String Em = null;
                       String p = null;
                       int count=0;
                       while(rs.next())
                       {
                           Em=rs.getString(3);
                           p=rs.getString(5);
                           count++;
                       }
                       if(count>0)
                       {
                       if(Em.equals(email)&&p.equals(pass))
                       {
                           response.setContentType("text/html");
                            PrintWriter pw=response.getWriter();
                            pw.println("<script type=\"text/javascript\">");
                            pw.println("alert('Login SuccessFull ');");
                            pw.println("</script>");
                            RequestDispatcher rd=request.getRequestDispatcher("patientafterlogin.html");
                            rd.include(request, response);
                       }
                       ps.close();
                      conn.close();
                       }
                       else
                       {
                           response.setContentType("text/html");
                            PrintWriter pw=response.getWriter();
                            pw.println("<script type=\"text/javascript\">");
                            pw.println("alert('Invalid Email or Password');");
                            pw.println("</script>");
                            RequestDispatcher rd=request.getRequestDispatcher("patientlogin.html");
                            rd.include(request, response);
                       }
                    
                }
            }
            
                            
       
        catch(ClassNotFoundException | SQLException e)
        {
           out.println("Connection problem "+e.getMessage());
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
