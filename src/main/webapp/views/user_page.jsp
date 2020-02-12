<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>user_page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<%--
<div class="bd-example">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link" href="index.html">Главная</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="UserHomeServlet">Личный кабинет</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="GetAllCarsServlet">Прайс</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="LogoutServlet">Выход</a>
        </li>
    </ul>
</div>
--%>


<div>
    <table class="table">
        <caption>Список пользователей</caption>
        <thead class="thead-light">
        <tr>
            <th scope="col">Hello, ${user.login}</th>
        </tr>
        </thead>
        <tbody>

       <%-- <tr>

            <td>
                <form action="GetOrdersByUserIdServlet" method="get">
                    <button type="submit" name="id" value="${User.id}" class="btn btn-outline-warning">My orders
                    </button>
                </form>
            </td>


            <td>
                <form action="UserInfoServlet" method="get">
                    <button type="submit" name="login" value="${User.login}" class="btn btn-outline-info">INFO</button>
                </form>
            </td>
            <td>
                <form action="UserEditPageServlet" method="get">
                    <button type="submit" name="login" value="${User.login}" class="btn btn-outline-warning">EDIT</button>
                </form>
            </td>

            <td>
                <form action="DeleteUserByStatusServlet" method="get">
                    <button type="submit" name="id" value="${User.id}" class="btn btn-outline-danger">Delete profile
                    </button>
                </form>
            </td>


        </tr>--%>

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

