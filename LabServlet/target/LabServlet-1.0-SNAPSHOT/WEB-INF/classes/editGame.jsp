<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 04.11.2024
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Game</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<form action="updateGame" method="post">
    <label for="WhoWin">Кто победил:</label>
    <select id="WhoWin" name="WhoWin">
        <c:forEach var="option" items="${optionsList}">
            <option value="${option}">${option}</option>
        </c:forEach>
    </select>
    <input type="hidden" name="id" value="${game.getGameId()}" />
    <br>
    <label for="NumberKillsRadiant">Количество убийств света:</label>
    <input type="text" id="NumberKillsRadiant" name="NumberKillsRadiant" value="${game.getNumberKillsRadiant()}" required/>
    <br>
    <label for="NumberKillsDire">Количество убийств тьмы:</label>
    <input type="text" id="NumberKillsDire" name="NumberKillsDire" value="${game.getNumberKillsDire()}"/>
    <br>
    <label for="Time">Продолжительность игры (в секундах):</label>
    <input type="text" id="Time" name="Time" value="${game.getTime()}"/>
    <br>
    <input type="submit" value="Обновить игру">
</form>
<a href="deleteGame?id=${game.getGameId()}">Удалить</a>
</body>
</html>
