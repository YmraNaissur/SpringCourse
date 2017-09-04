<%@ page import="library.beans.book.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  User: karavaev
  Date: 23.08.2017
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <%@ include file="/WEB-INF/jspf/header.jspf" %>
            <%@ include file="/WEB-INF/jspf/left_menu.jspf" %>

            <jsp:useBean id="books" class="library.beans.book.BookList" scope="page" />

            <%
                // Здесь будет содержаться список книг, актуальный для текущего запроса
                List<Book> currentBookList = new ArrayList<Book>();

                // Если делается запрос по автору (в меню слева)
                if (request.getParameter("author_id") != null) {
                    currentBookList = books.getBooksByAuthor(Long.valueOf(request.getParameter("author_id")));
                }

                // Если делается запрос по первой букве в названии


                // Сохраняем сформированный список в сессию
                session.setAttribute("currentBookList", currentBookList);
            %>

            <div id="content">
                <table width="100%">
                    <c:forEach var="book" items="${currentBookList}">
                        <tr>
                            <td align="center" width="200">
                                <img class="bookCover" width="140" height="200" src="<c:url value="///imageServlet?id=${book.id}"/>" />
                            </td>
                            <td>
                                <h3 class="bookHeader"> <c:out value="${book.name}" /></h3>
                                <p class="bookInfo"><b>Страниц:</b> <c:out value="${book.pageCount}" /></p>
                                <p class="bookInfo"><b>ISBN:</b> <c:out value="${book.isbn}" /></p>
                                <p class="bookInfo"><b>Жанр:</b> <c:out value="${book.genre}" /></p>
                                <p class="bookInfo"><b>Автор:</b> <c:out value="${book.author}" /></p>
                            </td>
                        </tr>
                        <tr>
                           <td align="center" colspan="2">
                               <hr>
                           </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <%@ include file="/WEB-INF/jspf/footer.jspf" %>