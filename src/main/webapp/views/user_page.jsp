<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>user_page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>


<div>
    <table class="table">
        <caption>Список пользователей</caption>
        <thead class="thead-light">
        <tr>
            <th scope="col">Hello, ${user.login}</th>
        </tr>
        </thead>
        <tbody>

        <tr>

            <td>
                <form action="controller" method="POST">
                    <button type="submit" name="command" value="ORDERS_BY_USER_ID" class="btn btn-outline-info">My orders
                    </button>
                </form>
            </td>


            <td>
                <form action="controller" method="POST">

                    <button type="submit" name="command" value="USER_INFO_PAGE" class="btn btn-outline-info">Profile
                        info
                    </button>
                </form>
            </td>
            <td>
                <form action="controller" method="POST">
                    <button type="submit" name="command" value="USER_EDIT_PAGE" class="btn btn-outline-warning">EDIT
                    </button>
                </form>
            </td>

            <td>
                <form action="controller" method="POST">
                    <button type="submit" name="command" value="DELETE_PROFILE" class="btn btn-outline-danger">Delete
                        profile
                    </button>
                </form>
            </td>


        </tr>

        </tbody>
    </table>
</div>
<footer>
    <div>
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>

