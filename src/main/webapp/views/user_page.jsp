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
        <caption>Список пользователей</caption>
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
<div>
    <tbody>
    <tr>
        <td>
            <form action="controller" method="POST">
                <button type="submit" name="command" value="USER_CHANGE_PASSWORD_PAGE" class="btn btn-outline-warning">Изменить пароль
                </button>
            </form>
        </td>

        <td>
            <form action="controller" method="POST">
                <button type="submit" name="command" value="USER_EDIT_PAGE" class="btn btn-outline-warning">Изменить данные
                </button>
            </form>
        </td>

        <td>
            <form action="controller" method="POST">
                <button type="submit" name="command" value="DELETE_PROFILE" class="btn btn-outline-danger">Удалить профиль
                </button>
            </form>
        </td>
    </tr>
    </tbody>
</div>

<footer>
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>
