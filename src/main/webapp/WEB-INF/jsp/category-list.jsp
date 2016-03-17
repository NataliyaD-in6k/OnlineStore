<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/style.css" type="text/css">
</head>
<body>
<div class="container">
    <h1 class="text-primary">Welcome to Store!</h1>
    <p>Choose category:</p>
    <ul class="category-list list-group col-sm-3">
        <c:forEach items="${categories}" var="object">
            <a href="${pageContext.request.contextPath}/categories/${object.id}">
                <li class="list-group-item">${object.name}</li>
            </a>
        </c:forEach>
    </ul>
    <c:forEach items="${categories}" var="object">
        <a href="${pageContext.request.contextPath}/categories/${object.id}">
            <div class="category col-sm-3 well text-center">${object.name}</div>
        </a>
    </c:forEach>
</div>
</body>
</html>
