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
                            <th>Name</th>
                            <th>Rating</th>
                            <th>Favorite Character</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Применяем шаблон для каждого элемента Player -->
                        <xsl:for-each select="playerList/players">
                            <tr>
                                <td><xsl:value-of select="playerId"/></td>
                                <td><xsl:value-of select="name"/></td>
                                <td><xsl:value-of select="rating"/></td>
                                <td><xsl:value-of select="favoriteCharacterName"/></td>
                                <td>
                                    <a href="players/{playerId}/update">Update</a> |
                                    <a href="players/{playerId}/delete">Delete</a>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
                <div style="margin-top: 20px;">
                    <a href="players/add">Add Player</a>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>