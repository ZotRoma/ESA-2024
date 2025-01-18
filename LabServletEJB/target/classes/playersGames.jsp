<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 04.11.2024
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="menu.jsp" %>

<h1>Список игроков</h1>
<table border="1">
    <tr>
        <th>ID игры</th>
        <th>ID игрока</th>
        <th>Имя героя</th>
        <th>Убийства</th>
        <th>Смерти</th>
        <th>Помощь</th>
        <th>Добитых крипов</th>
    </tr>
    <c:forEach var="playerGame" items="${playersGamesList}">
        <tr>
            <td>${playerGame.getGame().getGameId()}</td>
            <td>${playerGame.getPlayer().getPlayerId()}</td>
            <td>${playerGame.getHeroName()}</td>
            <td>${playerGame.getKills()}</td>
            <td>${playerGame.getDeaths()}</td>
            <td>${playerGame.getAssists()}</td>
            <td>${playerGame.getLastHit()}</td>
            <td><a href="editPlayerGame?id=${playerGame.getPlayerGameId()}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addPlayerGame">Добавить новую статистику в игре</a>
</body>
</html>
