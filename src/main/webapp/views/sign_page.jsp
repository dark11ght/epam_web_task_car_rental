<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sign page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>
<div style="width: 400px" class="container mx-auto">
    <div class="container text-center my-5">
        <img src="images/sign.png" width="100">
    </div>

    <div class="container text-center my-5">

        <form class="form-signin" action="controller" method="POST">
            <h1 class="h3 mb-3 font-weight-normal">Пожалуйста выполните вход</h1>
            <label for="login">Введите логин</label>
            <input type="text" id="login" class="form-control" placeholder="Login" name="login">

            <label for="pass">Введите пароль</label>
            <input type="password" id="pass" class="form-control mt-1" placeholder="Password" name="password">

            <button class="btn btn-lg btn-primary btn-block my-3" type="submit" name="command" value="SIGN_IN">Войти</button>
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
