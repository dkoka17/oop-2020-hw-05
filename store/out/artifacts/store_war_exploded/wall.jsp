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
    <title>Insert title here</title>
</head>
<body>
<h1>Cart</h1>

<form action="UpdateCart" method="POST">

    <%
        cart cur = (cart) session.getAttribute("cart");
        Vector<object> objs = cur.savedItems();
        for(object it : objs) {
            out.println("<li> <input type ='number' value='" + it.getNumb()
                    + "' name='" + it.getProd().getName()+ "'/>"
                    + it.getProd().getName() + ", " + it.getProd().getPrice() + "</li>");
        }
    %>
    Total: $<%=String.format("%.2f", cur.value())%>
    <input type="submit" value="Update Cart"/>

</form>

<a href="main.jsp">Return to catalog</a>

</body>
</html>
