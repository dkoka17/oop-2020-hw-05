<%--
  Created by IntelliJ IDEA.
  User: datok
  Date: 7/4/2020
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>
<%@ page import="shop.product" %>
<%@ page import="shop.sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Store</title>
</head>
<body>
<h1>Student Store</h1>
Items available: <br><br>
<ul>
    <%
        Vector<product> products= sql.getProducts();
        for(product cur : products) {
    %>
    <li><a href="product.jsp?id=<%= cur.getProdId() %>">
        <%= cur.getName() %></a></li>
    <%
        }

    %>
</ul>
</body>
</html>