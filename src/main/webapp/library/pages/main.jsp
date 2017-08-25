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

        <%
            AuthorList authorList = new AuthorList();
            for (Author a: authorList.getAuthorList()) {
                %>
                    <p>Id: <%= a.getId() %>; Name: <%= a.getName() %></p>
                <%
            }
        %>

        <%
            BookList bookList = new BookList();
            for (Book b: bookList.getBookList()) {
                %>
                <p>Id: <%= b.getId() %>; Caption: <%= b.getName() %></p>
                <%
            }
        %>

        <%
            GenreList genreList = new GenreList();
            for (Genre g : genreList.getGenreList()) {
                %>
                <p>Id: <%= g.getId() %>; Genre: <%=g.getName() %></p>
                <%
            }
        %>
    </body>
</html>