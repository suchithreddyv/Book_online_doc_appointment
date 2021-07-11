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
public class doctorservlet extends HttpServlet {

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
        String name=request.getParameter("uname");
        String date=request.getParameter("dob");
        String educ=request.getParameter("edu");
        String experience=request.getParameter("exp");
        int exp;
            exp = Integer.parseInt(experience);
        String spec=request.getParameter("spec");
        String mob =request.getParameter("number");
        long mobile=Long.parseLong(mob);
        
        String hname=request.getParameter("hospname");
        String address;
            address = request.getParameter("add");
        String email=request.getParameter("mail");
        String p=request.getParameter("psw");
        
       
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl_project","root","tiger")) {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into doctorinfo(name,dob,education,exp,mobileno,clinicaladdress,email,password,specialisation,Hospitalname) values(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,name);
                ps.setString(2,date);
                ps.setString(3,educ);
                ps.setInt(4,exp);
                ps.setLong(5,mobile);
                ps.setString(6,address);
                ps.setString(7,email);
                ps.setString(8,p);
                ps.setString(9,spec);
                ps.setString(10, hname);
                
                int i=ps.executeUpdate();
                if(i>0)
                {  
                    
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                    out.println("<html><head></head><body onload=\"alert('SignUp Successfull')\"></body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
                    rd.include(request, response);
                }
                else
                {
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                     out.println("<html><head></head><body onload=\"alert('SignUp UnSuccessfull')\"></body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
                    rd.include(request, response);
                }
                
                ps.close();
                conn.close();
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
