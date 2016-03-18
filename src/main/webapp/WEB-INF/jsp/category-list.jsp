<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <p class="lead">Choose category:</p>
    <ul class="category-list list-group col-sm-3">
        <c:forEach items="${categories}" var="category">
            <a href="/categories/${category.id}">
                <li class="list-group-item">${category.name}</li>
            </a>
        </c:forEach>
    </ul>
    <c:forEach items="${categories}" var="category">
        <a href="${pageContext.request.contextPath}/categories/${category.id}">
            <div class="category col-sm-3 well text-center">
                <div class="lead">${category.name}</div>
                <hr>
                <span>show products</span>
            </div>
        </a>
    </c:forEach>
</div>
</body>
</html>
