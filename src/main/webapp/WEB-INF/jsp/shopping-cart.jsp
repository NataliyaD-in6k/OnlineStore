<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body class="container">
    <div class="col-xs-offset-3 col-xs-6">
        <table class="table stripped-table">
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th style="width: 80px;">Count</th>
                <th></th>
            </tr>
            <c:forEach items="${productsInCart.keySet()}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td class="form-group"><input type="number" class="form-control" style="width:60px;" value="${productsInCart.get(product)}"></td>
                <td><a href="/shopping-cart/delete/${product.id}" class="glyphicon glyphicon-remove" style="color: red;margin-top: 8px;"></a><i ></i></td>
            </tr>
            </c:forEach>
        </table>
        <div class="text-right">
            <button class="btn btn-primary btn-md">Save</button>
            <button class="btn btn-success btn-md">Order</button>
        </div>
    </div>
</body>
</html>
