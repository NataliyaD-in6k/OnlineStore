<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/style.css" type="text/css">
</head>
<body>
<br class="container">
    <h1 class="text-primary">Welcome to Store!</h1>
    <c:forEach items="${customers}" var="customer">
           ${customer.firstName}</br>
        <c:forEach items="${customer.products.keySet()}" var="product">
            ${product.name} - ${product.price}</br>
        </c:forEach>
    </c:forEach>
</div>
</body>
</html>
