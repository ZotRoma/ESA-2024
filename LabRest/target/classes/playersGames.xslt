<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Шаблон для корневого элемента -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Players</title>
            </head>
            <body>
                <!-- Меню -->
                <div id="menu">
                    <a href="players">Players</a>
                    <a href="games">Games</a>
                    <a href="playersGames">Players in Games</a>
                </div>

                <h1>Players</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Game Id</th>
                            <th>Player Id</th>
                            <th>Hero Name</th>
                            <th>Kills</th>
                            <th>Deaths</th>
                            <th>Assists</th>
                            <th>LastHit</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Применяем шаблон для каждого элемента Player -->
                        <xsl:for-each select="playerGameStatisticList/playerGameStatisticList">
                            <tr>
                                <td><xsl:value-of select="playerGameId"/></td>
                                <td><xsl:value-of select="game/gameId"/></td>
                                <td><xsl:value-of select="player/playerId"/></td>
                                <td><xsl:value-of select="heroName"/></td>
                                <td><xsl:value-of select="kills"/></td>
                                <td><xsl:value-of select="deaths"/></td>
                                <td><xsl:value-of select="assists"/></td>
                                <td><xsl:value-of select="lastHit"/></td>
                                <td>
                                    <a href="playersGames/{playerGameId}/update">Update</a> |
                                    <a href="playersGames/{playerGameId}/delete">Delete</a>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
                <div style="margin-top: 20px;">
                    <a href="playersGames/add">Add Player</a>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>