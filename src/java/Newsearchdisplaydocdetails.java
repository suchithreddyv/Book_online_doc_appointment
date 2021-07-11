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
import javax.servlet.http.HttpSession;

/**
 *
 * @author HELLO
 */
public class Newsearchdisplaydocdetails extends HttpServlet {

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
             String spec =request.getParameter("spec");
           String add =request.getParameter("add");
       
             try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl_project","root","tiger")) {
                if(!(spec.isEmpty()|| add.isEmpty()))
                {    
                PreparedStatement ps;
                ps = conn.prepareStatement("select name,education,exp,mobileno,clinicaladdress,email,specialisation,Hospitalname from doctorinfo where specialisation=? AND clinicaladdress=?");
                ps.setString(1,spec);
                ps.setString(2, add);
                out.print("<html><head><style>body{background-image:url(Images/back.jpg)}\n" +
"table {\n" +
"  border-collapse: collapse;\n" +
"  width: 100%;\n" +
"}\n" +
"\n" +
"th, td {\n" +
"  text-align: left;\n" +
"  padding: 8px;\n" +
"}\n" +
"\n" +
"tr:nth-child(even){background-color: #f2f2f2}\n" +
"\n" +
"th {\n" +
"  background-color: #000000;\n" +
"  color: white;\n" +
"}\n" +
".button {\n" +
"  display: inline-block;\n" +
"  border-radius: 4px;\n" +
"  background-color: #000000;\n" +
"  border: none;\n" +
"  color: #FFFFFF;\n" +
"  text-align: center;\n" +
"  font-size: 20px;\n" +
"  padding: 20px;\n" +
"  width: 150px;\n" +
"  transition: all 0.5s;\n" +
"  cursor: pointer;\n" +
"  margin: 5px;\n" +
"}\n" +
"\n" +
".button span {\n" +
"  cursor: pointer;\n" +
"  display: inline-block;\n" +
"  position: relative;\n" +
"  transition: 0.5s;\n" +
"}\n" +
"\n" +
".button span:after {\n" +
"  content: '\\00bb';\n" +
"  position: absolute;\n" +
"  opacity: 0;\n" +
"  top: 0;\n" +
"  right: -20px;\n" +
"  transition: 0.5s;\n" +
"}\n" +
"\n" +
".button:hover span {\n" +
"  padding-right: 25px;\n" +
"}\n" +
"\n" +
".button:hover span:after {\n" +
"  opacity: 1;\n" +
"  right: 0;\n" +
"}</style></head><body><center>");
                out.print("<div>");
                out.print("<br><br><br>");
                out.print("<table border=1 width=50% height=50%>");
                out.print("<tr><th>Doctor Name</th><th>Education</th><th>Experience</th><th>Mobile No</th><th>Clinic Address</th><th>E-mail</th><th>Specialisation</th><th>Hospital Name</th></tr>");
                ResultSet rs=ps.executeQuery();
                    
                    while(rs.next())
                    {
                        String n=rs.getString(1);
                        String ed=rs.getString(2);
                        String exp=rs.getString(3);
                        Long mob=rs.getLong(4);
                        String loc=rs.getString(5);
                        String em =rs.getString(6);
                        String sp=rs.getString(7);
                        String hname=rs.getString(8);
                        
                        out.print("<tr><td>" + n + "</td><td>" + ed + "</td><td>" + exp + "</td><td>" + mob + "</td><td>" + loc + "</td><td>" + em + "</td><td>" + sp + "</td><td>" + hname + "</td></tr>");   
                        
                    }
                
                out.print("</table>");
                out.print("</div>");
                out.print("<div>");
                out.print("<br><br><br><br><br>");
                out.print("<a href=\"bookappoint.jsp\"><button class=button  ><span>Proceed</span></button></a>");
                out.print("</div>");
               
                out.print("</center></body></html>");
              
                ps.close();
                conn.close();
                }
                else
                {
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                     out.println("<html><head></head><body onload=\"alert('Empty Fields not allowed..Try Again')\"></body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("search.html");
                    rd.include(request, response);
                }
                
                
            }
                HttpSession session = request.getSession();
               session.setAttribute("specialisation",spec);
                session.setAttribute("address",add);
                
                
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
