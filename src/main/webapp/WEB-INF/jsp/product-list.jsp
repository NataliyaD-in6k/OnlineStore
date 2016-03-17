<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Catalogue</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-primary">Welcome to catalogue</h1>
    <c:forEach items="${products}" var="product">
        <div class="col-sm-3 well">
            <div class="text-center">
                    ${product.name}
            </div>
            <hr>
            <span class="text-center">Price: ${product.price} $</span>
            <i class="fa fa-shopping-cart fa-lg"></i>
        </div>
    </c:forEach>
</div>
</body>
</html>
