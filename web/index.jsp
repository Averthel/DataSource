<%--
  Created by IntelliJ IDEA.
  User: Ave
  Date: 26.02.2019
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Dodaj komentarz</h1>
  <form action="ControllerServlet" method="post">
    <input type="text" placeholder="Uzytkownik" name="username">
    <br>
    <textarea rows="5" cols="33" placeholder="Komentarz" name="comment"> </textarea>
    <br>
    Dodaj<input type="radio" name="option" value="add"> Usuń <input type="radio" name="option" value="delete">
    <br>
    <input type="submit" value="Wyślij">
  </form>
  </body>
</html>
