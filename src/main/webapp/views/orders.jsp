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
        <caption>Список заказов</caption>
        <thead class="thead-light">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Логин</th>
            <th scope="col">Марка автомобиля</th>
            <th scope="col">Модель автомобиля</th>
            <th scope="col">Количество часов</th>
            <th scope="col">Итоговая цена</th>
            <th scope="col">Подтверждение от облате</th>
            <th scope="col">Одобрение заказа администрацией</th>
            <th scope="col">дата регистрации заказа</th>
           <%-- <th scope="col">дата начала пользования автомобилем</th>
            <th scope="col">дата закрытия заказа</th>--%>
            <th scope="col">примечания</th>
            <th scope="col">татус заказа</th>
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
</div>


<footer>
    <div>
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>

