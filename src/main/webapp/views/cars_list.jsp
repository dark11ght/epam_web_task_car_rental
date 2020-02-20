<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car_Price</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="bd-example">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link" href="index.html">Главная</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="sign_page.jsp">Вход</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="views/regpage.jsp">Регистрация</a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Выход</a>
    </li>

    </ul>
</div>

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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
