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
        Hello, ${user.login}
    </h2>
</div>


<%--<div class="container text-center my-5">

    <form class="form-signin" action="GetAllCarsServlet">
        <button class="btn btn-lg btn-primary btn-block my-3" type="submit">User List</button>
    </form>
</div>--%>

</body>
</html>
