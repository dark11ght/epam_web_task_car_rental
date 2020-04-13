<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>user_page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>
<div>
<fmt:bundle basename="pagecontent" prefix="orders_page.">
    <table class="table">
        <caption><fmt:message key="headText"/></caption>
        <thead class="thead-light">
        <tr>
            <th scope="col"><fmt:message key="tableTextID"/></th>
            <th scope="col"><fmt:message key="tableUserLogin"/></th>
            <th scope="col"><fmt:message key="tableTextMark"/></th>
            <th scope="col"><fmt:message key="tableTextModel"/></th>
            <th scope="col"><fmt:message key="tableTextTime"/></th>
            <th scope="col"><fmt:message key="tableTotalPrice"/></th>
            <th scope="col"><fmt:message key="tablePaymentStatus"/></th>
            <th scope="col"><fmt:message key="tableConfirmByAdminStatus"/></th>
            <th scope="col"><fmt:message key="tableDateOfRegOrder"/></th>
            <th scope="col"><fmt:message key="tableOrderStatus"/></th>
           <%-- <th scope="col">дата начала пользования автомобилем</th>
            <th scope="col">дата закрытия заказа</th>--%>
            <th scope="col"><fmt:message key="tableNotes"/></th>
        </tr>
        </thead>


        <tbody>

        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.user.login}</td>
                <td>${order.car.mark.mark}</td>
                <td>${order.car.model.modelName}</td>
                <td>${order.rentHours}</td>
                <td>${order.totalPrice}</td>
                <td>${order.paymentStatus}</td>
                <td>${order.confirmByAdminStatus}</td>
                <td>${order.dateOfRegOrder}</td>
                <td>${order.orderStatus}</td>
                <td>${order.notes}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</fmt:bundle>
</div>


<footer>
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>

