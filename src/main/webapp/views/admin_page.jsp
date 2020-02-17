<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>admin_page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<div class="bd-example">
    <ul class="nav nav-pills">

        <li class="nav-item">
            <a class="nav-link" href="regpage.jsp">Регистрация</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="GetAllCarsServlet">Прайс</a>
        <li class="nav-item">
            <a class="nav-link" href="UserHomeServlet">Личный кабинет</a>
        </li>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="LogoutServlet">Выход</a>
        </li>
        <!--<li class="nav-item">
            <a class="nav-link"  href="<%=request.getContextPath()%>/GetAllUserServlet">Список юзеров</a>
        </li>-->

    </ul>
</div>

<div>
    <h2>
        Hello, ${user.login}
    </h2>
</div>


<%--<div class="container text-center my-5">

    <form class="form-signin" action="GetAllUserServlet">
        <button class="btn btn-lg btn-primary btn-block my-3" type="submit">User List</button>
    </form>
</div>--%>


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
