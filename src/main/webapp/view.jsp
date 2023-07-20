 <%@page import="java.sql.ResultSet"%>
<%@page import="dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View ALL Contacts</title>
  <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"
    />
    <!-- MDB -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
      rel="stylesheet"
    />
    <style type="text/css">
      a:hover {
	 color:  rgb(222, 224, 141);
}
    </style>
</head>
<body>
  
     <% 
        String email = (String) session.getAttribute("email"); 
        if(email != null){
        	ResultSet rs = ContactDao.getAllContacts(email);
     %>
     <%@ include file="search.jsp" %>
       <div class="container">
       
       <h2 align="center">Contact List</h2> <hr>
 
  <table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">NAME</th>
      <th scope="col">PHONE</th>
      <th scope="col">EDIT</th>
      <th scope="col">DELETE</th>
    </tr>
  </thead>
  <tbody>
    <% while(rs.next()){ %>
           <tr>
           <td> <%= rs.getString(2) %> </td>
           <td> <%= rs.getLong(3) %>   </td>
           <td> <a href="edit?id=<%= rs.getInt(1) %>">edit</a></td>
           <td> <a href="delete?id=<%= rs.getInt(1) %>">delete</a></td>
           </tr>
    <% } %>
  </tbody>
</table>
     
     <%
        }else{
        	response.sendRedirect("login.jsp");
        }
        
      %>
     <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
    ></script> 
      
</body>
</html>