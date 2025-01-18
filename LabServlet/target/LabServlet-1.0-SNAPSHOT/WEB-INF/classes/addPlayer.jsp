<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 30.10.2024
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add Player</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<form action="addPlayer" method="post">
    <label for="name">Имя игрока:</label>
    <input type="text" id="name" name="name" required/>
    <br>
    <label for="rating">Рейтинг игрока:</label>
    <input type="text" id="rating" name="rating" required/>
    <br>
    <label for="favoriteCharacterName">Название любимого персонажа:</label>
    <input type="text" id="favoriteCharacterName" name="favoriteCharacterName"/>
    <br>
    <input type="submit" value="add">
</form>
</body>
</html>