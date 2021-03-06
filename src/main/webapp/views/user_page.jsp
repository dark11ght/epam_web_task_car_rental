<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User info page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>
<div>
    <fmt:bundle basename="pagecontent" prefix="user_page.">
        <table class="table">
            <caption><fmt:message key="headText"/></caption>
            <thead class="thead-light">
            <tr>
                <th scope="col"><fmt:message key="tableUserLogin"/></th>
                <th scope="col"><fmt:message key="tableUserRole"/></th>
                <th scope="col"><fmt:message key="tableUserEmail"/></th>
                <th scope="col"><fmt:message key="tableUserStatus"/></th>
                <th scope="col"><fmt:message key="tableUserFirstName"/></th>
                <th scope="col"><fmt:message key="tableUserLastName"/></th>
                <th scope="col"><fmt:message key="tableUserPhoneNumber"/></th>
                <th scope="col"><fmt:message key="tableUserPassport"/></th>
                <th scope="col"><fmt:message key="tableUserDriverLicenceNumber"/></th>
                <th scope="col"><fmt:message key="tableUserDateOfReg"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${user.login}</td>
                <td>${user.role.role}</td>
                <td>${user.email}</td>
                <c:if test="${user.activeStatus.equals(true)}">
                    <td>
                        <fmt:message key="tableTextActive"/>
                    </td>
                </c:if>

                <c:if test="${!user.activeStatus.equals(true)}">
                    <td>
                        <fmt:message key="tableTextBlock"/>
                    </td>
                </c:if>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.passportSerialNumber}</td>
                <td>${user.driverLicenceNumber}</td>
                <td>${user.dateOfRegistration}</td>
            </tr>
            </tbody>
        </table>
    </fmt:bundle>
</div>
<div>
    <fmt:bundle basename="pagecontent" prefix="user_page.">
        <tbody>
        <tr>
            <td>
                <form action="controller" method="POST">
                    <button type="submit" name="command" value="USER_CHANGE_PASSWORD_PAGE"
                            class="btn btn-outline-warning"><fmt:message key="buttonChangePassword"/>
                    </button>
                </form>
            </td>

           <%-- <td>
                <form action="controller" method="POST">
                    <button type="submit" name="command" value="USER_EDIT_PAGE" class="btn btn-outline-warning">
                        <fmt:message key="buttonChangeProfile"/>
                    </button>
                </form>
            </td>--%>

            <td>
                <form action="controller" method="POST">
                    <button type="submit" name="command" value="BLOCK_USER" class="btn btn-outline-danger"><fmt:message
                            key="buttonDeleteProfile"/>
                    </button>
                </form>
            </td>
        </tr>
        </tbody>
    </fmt:bundle>
</div>

<footer>
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>
