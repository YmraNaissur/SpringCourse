<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: naissur
  Date: 23.08.2017
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Library</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form accept-charset="UTF-8" name="userName" action="<c:url value="/library/pages/main.jsp"/>" method="GET">
            <label for="name">Введите имя:</label>
            <input type="text" id="name" name="userName" value="" /><br />
            <label for="password">Введите пароль:</label>
            <input type="password" id="password" name="password" value="" /><br />
            <input type="submit" value="Войти" />
        </form>
    </body>
</html>