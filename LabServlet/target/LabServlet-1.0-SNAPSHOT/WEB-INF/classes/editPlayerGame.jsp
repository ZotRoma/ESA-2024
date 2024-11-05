<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 05.11.2024
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Edit Player in Game</title>
</head>
<body>
<%@ include file="index.jsp" %>
<form action="updatePlayerGame" method="post">
 <%--
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
  <br>--%>
  <input type="hidden" id="id" name="id" value="${playerGame.getPlayerGameId()}" />
  <label for="Kills">Количество убийств:</label>
  <input type="text" id="Kills" name="Kills" value="${playerGame.getKills()}"/>
  <br>
  <label for="Deaths">Количество смертей:</label>
  <input type="text" id="Deaths" name="Deaths" value="${playerGame.getDeaths()}"/>
  <br>
  <label for="Assists">Количество помощи:</label>
  <input type="text" id="Assists" name="Assists" value="${playerGame.getAssists()}"/>
  <br>
  <label for="Deaths">Добито крипов:</label>
  <input type="text" id="LastHit" name="LastHit" value="${playerGame.getLastHit()}"/>
  <br>
  <input type="submit" value="Обновить статистику игрока в игре">
</form>
<a href="deletePlayerGame?id=${playerGame.getPlayerGameId()}">Удалить</a>
</body>
</html>
