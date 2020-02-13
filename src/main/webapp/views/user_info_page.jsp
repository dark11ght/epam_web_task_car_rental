<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User info page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%--<div class="bd-example">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link" href="index.html">Главная</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="price.html">прайс</a>
        </li>
    </ul>
</div>
<div>--%>
    <table class="table">
        <caption>Список пользователей</caption>
        <thead class="thead-light">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Имя</th>
            <th scope="col">Пароль</th>
            <%--<th scope="col">Email</th>--%>
            <th scope="col">Роль</th>
            <th scope="col">Статус</th>
           <%-- <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Дата регистрации</th>
            <th scope="col">День рождения</th>
            <th scope="col">Email</th>
            <th scope="col">Водительское удостоверение</th>--%>


        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
           <%-- <td>${user.email}</td>--%>
            <td>${user.role}</td>
            <td>${user.activeStatus}</td>
           <%-- <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.regDate}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.email}</td>
            <td>${user.driverLicence}</td>--%>
        </tr>

       <%-- <td>
            <form action="/UserEditPageServlet" method="get">
                <button type="submit" name="login" value="${user.login}" class="btn btn-outline-warning">EDIT</button>
            </form>
        </td>--%>

        </tbody>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>
