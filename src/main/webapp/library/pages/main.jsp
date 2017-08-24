<%@ page import="testjdbc.TestConnection" %><%--
  User: karavaev
  Date: 23.08.2017
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Library</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% request.setCharacterEncoding("UTF-8"); %>
        <%= "Hello, " %>
        <h3>
            ${param["userName"]}
        </h3>
        <h3>
            ${param["password"]}
        </h3>

        <!-- Скриптлет чисто для теста соединения с БД, потом удалить -->
        <%
            TestConnection tc = new TestConnection();
            tc.check();
        %>
    </body>
</html>