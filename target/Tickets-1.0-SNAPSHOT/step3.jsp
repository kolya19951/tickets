<%--
  Created by IntelliJ IDEA.
  User: Коля
  Date: 15.09.2015
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%=request.getAttribute("departureCity")%>
<%=request.getAttribute("departureStation")%>
<%=request.getAttribute("departureDate")%>
<%=request.getAttribute("departureTime")%>
<%=request.getAttribute("arrivalCity")%>
<%=request.getAttribute("arrivalStation")%>
<%=request.getAttribute("arrivalDate")%>
<%=request.getAttribute("arrivalTime")%>
<%=request.getAttribute("price")%>
</body>
</html>
