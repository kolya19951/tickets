<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Auto-Completion using AJAX</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <link rel="stylesheet" type="text/css" href="reset.css">
  <script type="text/javascript" src="javascript.js"></script>
</head>
<body onload="init()">
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
    <div id="#triangle" class="step_one" style="background: #32CD32;">
      <center><p>1. Выбор рейса, даты</p></center>
    </div>
    <div class="step_two">
      <center><p>2. Бронирование</p></center>
    </div>
    <div class="step_three">
      <center><p>3. Покупка</p></center>
    </div>
  </div>
  <div class="frame">
    <center><%--@declare id="state_list"--%>


        <input type="text" class="input"  list="cities" placeholder="Откуда" required max="64" id="from"
               onkeyup="doCompletion(this.id);">

  <datalist id="cities">
  </datalist>
   <input type="text" class="input" placeholder="Куда" required max="64" id="to" onkeyup="doCompletion(this.id);" list="cities">

  <input type="date" class="input "id="date"><script>document.getElementById('date').valueAsDate = new Date();</script>
  <input type="submit" class="button" value="Поиск" onClick="search_trips()">
</center>
  </div>

        <table id="complete-table" />
      </td>
    </tr>
    </tbody>
  </table>

  <center>
    <div class="wrapper">
      <div class="table">
      <div class="row_info">
        <div class="col date">
          <b>Дата:</b>
        </div>

        <div class="col c">
          <b>Отправление</b>
        </div>

        <div class="col date">
          <b>Дата:</b>
        </div>

        <div class="col c">
          <b>Прибытие</b>
        </div>


        <div class="col c">
          <b>Стоимость</b>
        </div>
      </div>
      </div>
      <div class="table" id="tripsTable">
      </div>
    </div>
  </center>
</div>
<div class="footer">
  <div class="footer_text">
    <p>Сайт 2015 (С)</p>
  </div>
</div>
<form action="step2" method="get" style="display: none">
  <input type="text" value="0" id="tripId"name="id">
  <input type="submit" id="sendIdButton">
  </form>
</body>
</html>
