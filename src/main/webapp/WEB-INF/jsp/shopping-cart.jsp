<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<%@ include file="header.jsp" %>
<body class="container">
<form action="/shopping-cart/change-amount" method="post">
    <div class="col-xs-offset-3 col-xs-6">
        <table class="table stripped-table">
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th style="width: 80px;">Count</th>
                <th>Cost</th>
                <th>Remove</th>
            </tr>
            <c:forEach items="${productsInCart.keySet()}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td class="form-group">
                        <input type="number" class="form-control" style="width:60px;"
                               value="${productsInCart.get(product)}" name="count">
                        <input type="hidden" value="${product.id}" name="id">
                    </td>
                    <td>
                            <%--<c:set var="cost" scope="session" value="${productsInCart.get(product)*product.price}"/>--%>
                            ${productsInCart.get(product)*product.price}
                    </td>
                    <td>
                        <a href="/shopping-cart/delete/${product.id}" class="glyphicon glyphicon-remove"
                           style="color: red;margin-top: 8px;"></a>
                    </td>
                </tr>

            </c:forEach>
            <tr>
                <td colspan="3">Total cost</td>
                <td>${cost}</td>

            </tr>
        </table>
        <div class="text-right">
            <input type="submit" class="btn btn-primary btn-md" value="Save">
            <button class="btn btn-success btn-md">Order</button>
        </div>
    </div>
    <a href="/" class="well" style="display: inline-block">
        <i class="glyphicon glyphicon-chevron-left"></i><span>All products</span>
    </a>
</form>
</body>
</html>
