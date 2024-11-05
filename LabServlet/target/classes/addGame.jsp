<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 04.11.2024
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add Game</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<form action="addGame" method="post">
    <label for="WhoWin">Кто победил:</label>
    <select id="WhoWin" name="WhoWin">
        <c:forEach var="option" items="${optionsList}">
            <option value="${option}">${option}</option>
        </c:forEach>
    </select>

    <br>
    <label for="NumberKillsRadiant">Количество убийств света:</label>
    <input type="text" id="NumberKillsRadiant" name="NumberKillsRadiant" required/>
    <br>
    <label for="NumberKillsDire">Количество убийств тьмы:</label>
    <input type="text" id="NumberKillsDire" name="NumberKillsDire"/>
    <br>
    <label for="Time">Продолжительность игры (в секундах):</label>
    <input type="text" id="Time" name="Time"/>
    <br>
    <input type="submit" value="Добавить игру">
</form>
</body>
</html>
