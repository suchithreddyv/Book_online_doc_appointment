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
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HELLO
 */
public class patstatusdisplay extends HttpServlet {

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
            String name=request.getParameter("patname");
       
             try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl_project","root","tiger")) {
                if(!(name.isEmpty()))
                {    
                PreparedStatement ps;
                ps = conn.prepareStatement("select name,concern,date,mobileno,Id,status from book_appointment where name=?");
                ps.setString(1,name);
                
                out.print("<html><head><style>body{background-image:url(Images/back.jpg)}\n" +
"table {\n" +
"  border-collapse: collapse;\n" +
"  width: 50%;\n" +
"}\n" +
"\n" +
"th, td {\n" +
"  text-align: center;\n" +
"  padding: 2px;\n" +
"}\n" +
"\n" +
"tr:nth-child(even){background-color: #f2f2f2}\n" +
"\n" +
"th {\n" +
"  background-color: #000000;\n" +
"  color: white;\n" +
"}\n" +
"</style></head><body><center>");
                out.print("<br><br><br><br>");
                out.print("<table border=1 width=50% height=20%>");
                out.print("<tr><th>Your-ID</th><th>Name</th><th>Your Concern</th><th>Date of Appointment</th><th>Mobile No</th><th>Status</th></tr>");
                ResultSet rs=ps.executeQuery();
               
                Statement st=conn.createStatement();
                    while(rs.next())
                    {
                        String n=rs.getString(1);
                        String prob=rs.getString(2);
                        String date=rs.getString(3);
                        Long mob=rs.getLong(4);
                        int id=rs.getInt(5);
                        String status=rs.getString("status");
                        
                        out.print("<tr><td>"+id+"</td><td>" + n + "</td><td>" + prob + "</td><td>" + date + "</td><td>"+mob+"</td><td>"+status+"</td></tr>" );   
                    }
                
                out.print("</table>");
                out.print("</center></body></html>");

                ps.close();
                conn.close();
                        
                }
                else
                {
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                     out.println("<html><head></head><body onload=\"alert('Cannot load Status')\"></body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("docappointdetails.html");
                    rd.include(request, response);
                }
                
                
            }
            }
            
                            
       
        catch(ClassNotFoundException | SQLException e)
        {
           out.println("Connection problem" + e.getMessage());
           
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
