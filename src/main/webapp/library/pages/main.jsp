<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  User: karavaev
  Date: 23.08.2017
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <%@ include file="/WEB-INF/jspf/header.jspf" %>
            <%@ include file="/WEB-INF/jspf/left_menu.jspf" %>

            <jsp:useBean id="books" class="library.beans.book.BookList" scope="page" />

            <div id="content">
                <table width="100%">
                    <c:forEach var="book" items="${books.getBooksByAuthor(param.author_id)}">
                        <tr>
                            <td align="center" width="200">
                                <img class="bookCover" width="140" height="200" src="<c:url value="///imageServlet?id=${book.id}"/>" />
                            </td>
                            <td>
                                <h3 class="bookHeader"> <c:out value="${book.name}" /> </h3>
                                <p class="bookInfo"><b>Страниц:</b> <c:out value="${book.pageCount}" /> </p>
                                <p class="bookInfo"><b>ISBN:</b> <c:out value="${book.isbn}" /> </p>
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