<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit password </title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>
<div style="width: 400px" class="container mx-auto">

    <div class="container text-center my-5">

        <form class="form-signin" action="controller" method="POST">
            <h1 class="h3 mb-3 font-weight-normal">Изменение пароля</h1>

            <label for="oldPass">Введите старый пароль</label>
            <input type="password" id="oldPass" class="form-control mt-1" placeholder="Старый пароль" name="oldPassword">

            <label for="newPass">Введите новый пароль</label>
            <input type="password" id="newPass" class="form-control mt-1" placeholder="Новый пароль" name="newPassword">

            <label for="rPassword">Повторите пароль</label>
            <input type="password" id="rPassword" class="form-control mt-1" placeholder="Повторите пароль" name="rPassword">

            <button class="btn btn-lg btn-primary btn-block my-3" type="submit" name="command" value="USER_CHANGE_PASSWORD">Изменить пароль</button>
        </form>
    </div>
</div>
<footer>
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>
