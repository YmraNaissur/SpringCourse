<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  User: karavaev
  Date: 23.08.2017
--%>

<jsp:useBean id="books" class="library.beans.book.BookList" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <%@ include file="/WEB-INF/jspf/header.jspf" %>
            <%@ include file="/WEB-INF/jspf/left_menu.jspf" %>

            <div id="content">
                <h3>
                    <c:forEach var="book" items="${books.bookList}">
                        <p> <c:out value="${book.name}" /> </p>
                    </c:forEach>
                </h3>
            </div>

            <%@ include file="/WEB-INF/jspf/footer.jspf" %>