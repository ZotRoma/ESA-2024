<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <!-- Шаблон для корневого элемента -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Games</title>
            </head>
            <body>
                <xsl:template name="menu">
                    <div id="menu">
                        <a href="players">Players</a>
                        <a href="games">Games</a>
                        <a href="playersGames">Players in Games</a>
                    </div>
                </xsl:template>
                <h1>Games</h1>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Who Win</th>
                            <th>Kills Radiant</th>
                            <th>Kills Dire</th>
                            <th>Time</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Применяем шаблон для каждого элемента Game -->
                        <xsl:for-each select="gameList/games">
                            <tr>
                                <td><xsl:value-of select="gameId"/></td>
                                <td><xsl:value-of select="whoWin"/></td>
                                <td><xsl:value-of select="numberKillsRadiant"/></td>
                                <td><xsl:value-of select="numberKillsDire"/></td>
                                <td><xsl:value-of select="time"/></td>
                                <td>
                                    <a href="games/{gameId}/update">Update</a> |
                                    <a href="games/{gameId}/delete">Delete</a>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
                <div style="margin-top: 20px;">
                    <a href="games/add">Add game</a>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>