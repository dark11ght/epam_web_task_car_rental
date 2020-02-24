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

</body>
</html>

