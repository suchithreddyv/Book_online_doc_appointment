<%-- 
    Document   : newbookappoint
    Created on : Sep 5, 2020, 1:40:40 PM
    Author     : HELLO
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Book Appointment</title>
</head>

<body align="center">
<div id="id03" class="modal" align="center">
  <div class="bg-img">
  
  <form action="patientappointmentservlet" method="post" class="modal-acc" ">
      <h1>Book an Appointment</h1><br>
     <div class="container">
      (Please Enter the name of doctor with whom you want to book appointment from details in previous table)<br><br>  
      <label><b>Doctor Name</b></label><br>
     <!-- <input type="text" name="docname" pattern="^[a-zA-Z\s\.]+$" title="Must not contain Numericals and special Characters except . "required><br><br>
      -->
      <select id="docname" name="docname" style="width: 20%; padding: 5px 5px; margin: 4px 0; text-align: left; border: 1px solid #ccc;">
    
          <%
              String spec = (String) session.getAttribute("specialisation");
              String add = (String) session.getAttribute("address");
              
               try{
               
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl_project","root","tiger");
                
                    String q="select name from doctorinfo where specialisation=? AND clinicaladdress=?";
                   PreparedStatement ps = conn.prepareStatement(q); 
                       ps.setString(1,spec);
                       ps.setString(2,add);
                       ResultSet rs= ps.executeQuery();
                       while(rs.next())
                       {
                           %> 
                           <option value="<%=rs.getString("name")%>" ><%=rs.getString("name")%></option>
                           <%
                       }

            }

        catch(ClassNotFoundException | SQLException e)
        {
           out.println("Connection problem "+e.getMessage());
        }

              %>
  </select><br><br>
      <label><b>Patient Name</b></label><br>
      <input type="text" name="patname" pattern="^[a-zA-Z\s\.]+$" title="Must not contain Numericals and special Characters except . " required><br><br>
	
      <label><b>Major concerns for the consultation</b></label><br>
       <input type="text" name="prob" required><br><br>
		<label><b>Select the date of appointment</b></label><br>
                <input type="date" name="appointdate" id="mydate" onclick="getCurrentDate()"  required ><br><br>
	  
	  
	  <label><b>Mobile Number</b></label><br>
      <input type="text" name="number" pattern="[7-9]{1}[0-9]{9}"  
       title="Phone number with 7-9 and remaing 9 digit with 0-9" required><br><br>
      
		
      <button type="submit">Done</button><br>
      <input type="checkbox" checked name="remember"> <b>Important Notice:</b> Please reach the hospital 5 minutes prior to the time of appointment
      </label><br>
      <a href="search.html"><button  type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn" >Cancel</button></a>
      
	</div>
  </form> 
  </div>  
</div>
    
<script type="text/javascript">
// Get the modal
var modal = document.getElementById('id01');
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
};

 function getCurrentDate() { 
        let dateObj = new Date(); 
        let month = String(dateObj.getMonth() + 1).padStart(2, '0'); 
        let day = String(dateObj.getDate()).padStart(2, '0'); 
        let year = dateObj.getFullYear(); 
        let output = year + '-' + month + '-' + day; 
          
        document.getElementById("mydate").min=output;
       /* var val=document.getElementById("mydate").value;
        if(val<= output)
        {
            alert("Enter appropriate date");
        }*/
    }
</script>
    
</body></html>
