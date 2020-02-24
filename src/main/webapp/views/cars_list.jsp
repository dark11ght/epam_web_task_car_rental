<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car_Price</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Pricing</h1>
    <p class="lead">Все наши автомоболи.</p>
</div>


<div class="container text-center my-5 px-5">
    <div class="row">
        <c:forEach items="${cars}" var="car">
            <div class="col-mb-3" >
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">${car.mark.mark}</h4>
                    </div>
                    <div class="card-body">

                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Марка - ${car.mark.mark}</li>
                            <li>Модель - ${car.model.modelName}</li>
                            <li>Пробег - ${car.millage}км</li>
                            <li>Цена - ${car.price}</li>
                            <li>Статус - ${car.carStatus.carStatus}</li>
                        </ul>
                        <c:if test="${car.carStatus.carStatus.equals('free')}">
                        <form action="PreCreateOrderServlet" method="get">
                        <button type="submit" name="car_id" value="${car.id}" class="btn btn-lg btn-block btn-outline-primary">Заказать</button>
                        </form>
                        </c:if>
                        <c:if test="${!car.carStatus.carStatus.equals('free')}">
                            <form action="PreCreateOrderServlet" method="get">
                                <button type="submit" class="btn btn-lg btn-block btn-outline-secondary" disabled>Заказать</button>
                            </form>
                        </c:if>
                        <form action="GetCarByIdServlet" method="get">
                            <button type="submit" name="car_id" value="${car.id}" class="btn btn-lg btn-block btn-outline-primary">Просмотр</button>
                        </form>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

</div>

</body>
</html>
