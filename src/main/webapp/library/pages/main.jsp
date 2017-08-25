<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="library.beans.author.AuthorList" %>
<%@ page import="library.beans.author.Author" %>
<%@ page import="library.beans.book.BookList" %>
<%@ page import="library.beans.book.Book" %>
<%@ page import="library.beans.Genre.GenreList" %>
<%@ page import="library.beans.Genre.Genre" %>
<%--
  User: karavaev
  Date: 23.08.2017
--%>

<jsp:useBean id="authors" class="library.beans.author.AuthorList" />
<jsp:useBean id="books" class="library.beans.book.BookList" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Главная страница</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/library/styles/mainStyle.css"/>" media="screen" />
    </head>
    <body>
        <% request.setCharacterEncoding("UTF-8"); %>

        <div id="container">
            <div id="header">
                <h1>Библиотека древних мудрецов</h1>
            </div>

            <div id="search">
                <form action="#">
                    <input type="text" name="searchRequest" title="request"/>
                    <select name="searchType" title="field">
                        <option>Автор</option>
                        <option>Книга</option>
                    </select>
                    <input type="submit" value="Найти" />
                </form>
            </div>

            <div id="menu">
                <h3>
                    <c:forEach var="author" items="${authors.authorList}">
                        <p> <c:out value="${author.name}" /> </p>
                    </c:forEach>
                </h3>
            </div>

            <div id="content">
                <h3>
                    <c:forEach var="book" items="${books.bookList}">
                        <p> <c:out value="${book.name}" /> </p>
                    </c:forEach>
                </h3>
            </div>

            <div id="clear">
                <!-- пусто -->
            </div>

            <div id="footer">
                <h2>(с) Верховный паладин Макс Кей, 2017 г.</h2>
            </div>
        </div>
    </body>
</html>