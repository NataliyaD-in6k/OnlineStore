<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Catalogue</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h1 class="text-primary">Welcome to catalogue</h1>
    <div class="product-list row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-3 text-center">
                <div class="product well">
                    <div class="lead">
                            ${product.name}
                    </div>
                    <hr>
                    <span>Price:$ ${product.price}</span>
                    <form method="post" action="/shopping-cart/change-amount" style="display: inline-block" class="text-right">
                    <%--<form method="post" action="/shopping-cart" style="display: inline-block" class="text-right">--%>
                        <input type="hidden" name="id" value="${product.id}">
                        <%--<input type="hidden" name="count" value="1" >--%>
                        <button class="btn btn-default glyphicon glyphicon-shopping-cart" type="submit"></button>
                        <input type="number" name="count" value="1" style="width:60px;"/>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
    <a href="/" class="well" style="display: inline-block">
        <i class="glyphicon glyphicon-chevron-left"></i><span>All categories</span>
    </a>
</div>
</body>
</html>
