<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/style.css" type="text/css">
</head>
<body>
<div class="container">
    <h1 class="text-primary">Welcome to Store!</h1>
    <p>Choose category:</p>
    <ul class="category-list list-group col-sm-3">
        <c:forEach items="${categories}" var="category">
            <a href="${pageContext.request.contextPath}/categories/${category.id}">
                <li class="list-group-item">${category.name}</li>
            </a>
        </c:forEach>
    </ul>
    <c:forEach items="${categories}" var="category">
        <a href="${pageContext.request.contextPath}/categories/${category.id}">
            <div class="category col-sm-3 well">
            <div class="text-center">${category.name}</div>
                <hr>
                <span>show products</span>
            </div>

        </a>
    </c:forEach>
</div>
</body>
</html>
