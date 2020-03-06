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

        <form class="form-signin" action="Controller" method="POST">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="login" class="sr-only">Email address</label>
            <input type="text" id="login" class="form-control" placeholder="Login" name="login">

            <label for="pass" class="sr-only">Password</label>
            <input type="password" id="pass" class="form-control mt-1" placeholder="Password" name="password">

            <button class="btn btn-lg btn-primary btn-block my-3" type="submit" value="SIGN_IN">Sign in</button>
            <p class="mt-5 mb-3 text-muted">© Pavel Shakhrai 2020</p>
        </form>
    </div>
</div>

</body>
</html>
