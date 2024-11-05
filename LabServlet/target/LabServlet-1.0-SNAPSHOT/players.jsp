<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Список игроков</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>Список игроков</h1>
<table border="1">
  <tr>
    <th>ID игрока</th>
    <th>Имя</th>
    <th>Рейтинг</th>
    <th>Имя любимого персонажа</th>
    <th>Открыть профиль</th>
  </tr>
  <c:forEach var="player" items="${playersList}">
    <tr>
      <td>${player.getPlayerId()}</td>
      <td>${player.getName()}</td>
      <td>${player.getRating()}</td>
      <td>${player.getFavoriteCharacterName()}</td>
      <td><a href="editPlayer?id=${player.getPlayerId()}">Edit</a></td>
    </tr>
  </c:forEach>
</table>
<br/>
<a href="addPlayer">Добавить нового игрока</a>
</body>
</html>