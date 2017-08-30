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
        <link rel="stylesheet" type="text/css" href="<c:url value="/library/styles/welcomeStyle.css"/>" media="screen" />
    </head>
    <body>
        <% request.getSession().invalidate(); %>
        <div class="page">
            <h1>Приветствую, путник!</h1>

            <div class="main">
                <p>Уставший с дороги, ты прибыл в мою прекрасную библиотеку.</p>
                <p>Я рад предложить твоему вниманию собрание книг, которые я и мои предки тщательно отсеивали
                    для того, чтобы удовлетворить потребности самого взыскательного читателя.
                    Устраивайся поудобнее в читальном зале и погружайся в дивный мир литературного гения.</p>
                <p>Но для начала скажи, как тебя зовут, странник.</p>

                <form name="userName" action="<c:url value="/library/pages/main.jsp"/>" method="POST">
                    <label for="name">Имя:</label>
                    <input type="text" id="name" name="userName" value="" />
                    <p>
                        <input type="submit" value="Войти" />
                    </p>
                </form>
            </div>

            <div class="footer">
                (с) Верховный паладин Макс Кей, 2017 г.
            </div>
        </div>
    </body>
</html>