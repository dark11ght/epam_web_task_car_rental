<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User info page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>
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
        <td>${user.role.role}</td>
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

</body>
</html>
