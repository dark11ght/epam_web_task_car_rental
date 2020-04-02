<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User info page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>
<div>
    <table class="table">
        <caption>Информация пользователя</caption>
        <thead class="thead-light">
        <tr>
            <%--<th scope="col">id</th>--%>
            <th scope="col">Логин</th>
            <th scope="col">Роль</th>
            <th scope="col">Email</th>
            <th scope="col">Статус</th>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Номер пасспорта</th>
            <th scope="col">Водительское удостоверение</th>
            <th scope="col">Дата регистрации</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.login}</td>
            <td>${user.role.role}</td>
            <td>${user.email}</td>
            <c:if test="${user.activeStatus.equals(true)}">
                <td>
                    active
                </td>
            </c:if>

            <c:if test="${!user.activeStatus.equals(true)}">
                <td>
                    blocked
                </td>
            </c:if>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.passportSerialNumber}</td>
            <td>${user.driverLicenceNumber}</td>
            <td>${user.dateOfRegistration}</td>
        </tr>
        </tbody>
    </table>
</div>

<footer>
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>
