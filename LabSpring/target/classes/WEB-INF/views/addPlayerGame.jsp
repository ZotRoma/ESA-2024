<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 04.11.2024
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
  <head>
    <title>Добавить статистику игрока в игре</title>
  </head>
  <body>
  <form action="addPlayerGame" method="post">
    <label for="Game">Id игры:</label>
    <select id="Game" name="Game">
      <c:forEach var="game" items="${games}">
        <option value="${game.getGameId()}">${game.getGameId()}</option>
      </c:forEach>
    </select>
    <br>
    <label for="Player">Id игрока:</label>
    <select id="Player" name="Player">
      <c:forEach var="player" items="${players}">
        <option value="${player.getPlayerId()}">${player.getPlayerId()}</option>
      </c:forEach>
    </select>
    <br>
    <label for="HeroName">Герой:</label>
    <input type="text" id="HeroName" name="HeroName" required/>
    <br>
    <label for="Kills">Количество убийств:</label>
    <input type="text" id="Kills" name="Kills"/>
    <br>
    <label for="Deaths">Количество смертей:</label>
    <input type="text" id="Deaths" name="Deaths"/>
    <br>
    <label for="Assists">Количество помощи:</label>
    <input type="text" id="Assists" name="Assists"/>
    <br>
    <label for="LastHit">Добито крипов:</label>
    <input type="text" id="LastHit" name="LastHit"/>
    <br>
    <input type="submit" value="Добавить статистику игрока в игре">
  </form>
  </body>
</html>
