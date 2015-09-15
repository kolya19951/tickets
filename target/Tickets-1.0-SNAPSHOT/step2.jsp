<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Entity.Seat" %>
<%@ page import="Model.Observer.SeatPlace" %>
<%--
  Created by IntelliJ IDEA.
  User: Коля
  Date: 14.09.2015
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <script type="text/javascript" src="javascript.js"></script>

    <title></title>
</head>
<body>
<div class="menu">
    <ul>
        <li><a href="Index.html">Главная</a></li>
        <li><a href="Reservations.html">Бронирование</a></li>
        <li><a href="Info.html">Информация</a></li>
        <li><a href="Contacts.html">Связь</a></li>
    </ul>
</div>
<div class="main">
    <br>

    <div id="logo">
        <center><img src="img/logo.png" width="180" height="174"></center>
    </div>
    <div class="step">
        <div class="step_one">
            <center><p>1. Выбор рейса, даты</p></center>
        </div>
        <div class="step_two" style="background: #32CD32;">
            <center><p>2. Бронирование</p></center>
        </div>
        <div class="step_three">
            <center><p>3. Покупка</p></center>
        </div>
    </div>
    <center>
        <?

    ?>
        <div class="bus">
            <table class="busTable">
                <tr>
                <%
                    Seat[][] indexableSeats = (Seat[][]) request.getAttribute("indexableSeats");
                    int maxRow = (Integer) request.getAttribute("maxRow");

                    for (int i = 0; i < maxRow; i++) {
                %>
                <tr><%
                    for (int j = 0; j < 5; j++) {
                        if (indexableSeats[j][i] != null) {
                %>
                    <td onClick="choosePlace(this.id)" id="<%=indexableSeats[j][i].getId()%>"><%=indexableSeats[j][i].getSeat_num()%>
                    </td>
                    <%
                            }
                            else %><td id="0">0</td><%;
                        }
                    %></tr>
                <%
                    }
                %>
            </table>
        </div>
    </center>

</div>
<div class="footer">
    <div class="footer_text">
        <p>Сайт 2015 (С)</p>
    </div>
</div>
</body>
<form action="step3" method="get" style="display: none">
    <input type="text" value="0" id="placeId"name="id">
    <input type="submit" id="sendIdButton">
</form>
</html>
