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
            <th scope="col">ORDERS</th>
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
                    <form action="controller" method="POST">
                        <input type="hidden" id="OrderUserID" name="userID" value="${user.id}">
                        <button type="submit" name="command" value="ORDERS_BY_USER_ID"
                                class="btn btn-outline-info">ORDERS
                        </button>
                    </form>
                <td>

                    <c:if test="${user.activeStatus.equals(true)}">
                <td>
                    <form action="controller" method="POST">
                        <input type="hidden" id="BlockUserID" name="userID" value="${user.id}">
                        <button type="submit" name="command" value="BLOCK_USER_BY_ADMIN" class="btn btn-outline-danger">
                            BLOCK USER
                        </button>
                    </form>
                </td>
                </c:if>

                <c:if test="${!user.activeStatus.equals(true)}">
                    <td>
                        <form action="controller" method="POST">
                            <input type="hidden" id="UnblockUserID" name="userID" value="${user.id}">
                            <button type="submit" name="command" value="UNBLOCK_USER" class="btn btn-outline-success">
                                UNBLOCK USER
                            </button>
                        </form>
                    </td>
                </c:if>

                <td>
                    <form action="controller" method="POST">
                        <input type="hidden" id="InfoUserID" name="userID" value="${user.id}">
                        <button type="submit" name="command" value="USER_INFO_PAGE_BY_ADMIN"
                                class="btn btn-outline-info">INFO
                        </button>
                    </form>

                <td>
                    <form action="controller" method="POST">
                        <input type="hidden" id="DeleteUserID" name="userID" value="${user.id}">
                        <button type="submit" name="command" value="DELETE_USER_FROM_DB" class="btn btn-outline-danger">
                            DELETE FROM DB
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
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>