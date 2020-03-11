<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>admin_page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>

<%@include file="include/nav_bar.jsp" %>

<div>
    <h2>
        Hello, ADMIN ${user.login}
    </h2>
</div>
<div class="container">
    <ul class="list-unstyled">
        <li><p class="text-danger">Заказы, ожидающите рассомотрения <strong>${countOrders}</strong></p></li>
        <li><a class="nav-link" href="">Список заказов</a><br></li>
        <li><a class="nav-link" href="Controller?command=ALL_USER_LIST">Список пользователей</a><br></li>
    </ul>

</div>

</body>
</html>
