<%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 03.11.2024
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<%@ include file="menu.jsp" %>
<head>
  <title>${contextTitle}</title>
</head>
<body>

<h2>${contextH2}</h2>
<p> ${contextParagraph}</p>
<a href="${returnLink}">${contextLink}</a>
</body>
</html>
