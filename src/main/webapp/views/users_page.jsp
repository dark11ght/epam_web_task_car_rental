<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>users_page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>

<div>
    <table class="table">
        <caption>Список пользователей</caption>
        <thead class="thead-light">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Имя</th>
            <th scope="col">Роль</th>
            <th scope="col">Статус</th>
            <th scope="col">EDIT</th>
            <th scope="col">BLOCK USER</th>
            <th scope="col">INFO</th>
            <th scope="col">DELETE</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.role.role}</td>
                <c:if test="${user.activeStatus.equals(true)}">
                    <td>
                        active
                    </td>
                </c:if>

                <c:if test="${!user.activeStatus.equals(true)}">
                    <td>
                        blocked
                    </td>
                </c:if>
                <td>
                    <form action="UserEditPageServlet" method="get">
                        <button type="submit" name="login" value="${user.login}" class="btn btn-outline-warning">EDIT
                        </button>
                    </form>
                </td>


                <c:if test="${user.activeStatus.equals(true)}">
                    <td>
                        <form action="BLOCK_USER" method="get">
                            <button type="submit" name="id" value="${user.id}" class="btn btn-outline-danger">DELETE
                            </button>
                        </form>
                    </td>
                </c:if>

                <c:if test="${!user.activeStatus.equals(true)}">
                    <td>
                        <form action="UNBLOCK_USER" method="get">
                            <button type="submit" name="id" value="${user.id}" class="btn btn-outline-success">RETURN
                                USER
                            </button>
                        </form>
                    </td>
                </c:if>

                <td>
                    <form action="UserInfoServlet" method="get">
                        <button type="submit" name="login" value="${user.login}" class="btn btn-outline-info">INFO
                        </button>
                    </form>

                <td>
                    <form action="/DeleteUserServlet" method="get">
                        <button type="submit" name="id" value="${user.id}" class="btn btn-outline-danger">del from DB
                        </button>
                    </form>
                </td>

                </td>
            </tr>
        </c:forEach>
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