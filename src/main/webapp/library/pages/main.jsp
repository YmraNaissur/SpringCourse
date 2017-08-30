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
                <table border="1" width="100%">
                    <c:forEach var="book" items="${books.getBooksByAuthor(param.author_id)}">
                        <tr>
                            <td>
                                <h3> <c:out value="${book.name}" /> </h3>
                                <p> Страниц: <c:out value="${book.pageCount}" /> </p>
                                <p> ISBN: <c:out value="${book.isbn}" /> </p>
                                <img width="140" height="200" src="<c:url value="//imageServlet?id=${book.id}"/>" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <%@ include file="/WEB-INF/jspf/footer.jspf" %>