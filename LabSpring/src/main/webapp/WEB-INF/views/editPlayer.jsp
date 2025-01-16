<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 03.11.2024
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Player</title>
</head>
<body>
<%@ include file="index.jsp" %>
<form action="updatePlayer" method="post">
  <input type="hidden" name="id" value="${player.getPlayerId()}" />

  <label for="name">Имя игрока:</label>
  <input type="text" id="name" name="name" value="${player.getName()}" required/>
  <br>
  <label for="rating">Рейтинг игрока:</label>
  <input type="text" id="rating" name="rating" value="${player.getRating()}" required/>
  <br>
  <label for="favoriteCharacterName">Название любимого персонажа:</label>
  <input type="text" id="favoriteCharacterName"  name="favoriteCharacterName" value="${player.getFavoriteCharacterName()}"/>
  <br>
  <input type="submit" value="Update">
</form>
<a href="deletePlayer?id=${player.getPlayerId()}">Удалить</a>
</body>
</html>
