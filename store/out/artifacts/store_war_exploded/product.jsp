<%--
  Created by IntelliJ IDEA.
  User: datok
  Date: 7/4/2020
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="shop.*" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%
        String id = request.getParameter("id");
        product cur = sql.get(id);
    %>
</head>
<body>
<h1><%= cur.getName() %></h1>
<img src="store-images/<%= cur.getFile() %>"><br>
<form action="cart" method="POST">
    <input type="hidden" name="name" value="<%= cur.getName() %>">
    <input type="hidden" name="id" value="<%= cur.getProdId() %>">
    <input type="hidden" name="file" value="<%= cur.getFile() %>">
    <input type="hidden" name="price" value="<%= cur.getPrice() %>">
    $<%= String.format("%.2f", cur.getPrice()) %>
    <input type="submit" value="Add to Cart">
</form><br>
</body>
</html>
