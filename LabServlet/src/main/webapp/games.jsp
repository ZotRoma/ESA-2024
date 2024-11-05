<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Игры</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>Список игр</h1>
<table border="1">
    <tr>
        <th>ID игры</th>
        <th>Убийства света</th>
        <th>Убийства тьмы</th>
        <th>Кто победил</th>
        <th>Время игры</th>
        <th>Открыть профиль</th>
    </tr>
    <c:forEach var="game" items="${gameList}">
        <tr>
            <td>${game.getGameId()}</td>
            <td>${game.getNumberKillsRadiant()}</td>
            <td>${game.getNumberKillsDire()}</td>
            <td>${game.getWhoWin()}</td>
            <td>${game.getTime()}</td>
            <td><a href="editGame?id=${game.getGameId()}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addGame">Добавить новую игру</a>
</body>
</html>
