<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>

    <meta charset="UTF-8">
    <title>index</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>

<div class="container-fluid">
    <h1>Аренда автомобиля</h1>
    <div class="text-center">
        <img src="images/rentimage.jpg" class="rounded" width="800">
    </div>
    <p>
        Аренда автомобиля предполагает оказание услуг по пассажирским перевозкам. Машина передается во "временное
        владение" клиенту.
        Аренда автомобиля всегда предполагает наличие у клиента наличие действующего водительского удостоверения
        соответствующей категории.
        Отличие аренлы автомобоиля от такси в том, что в такси вы платите за километраж, а в случае с арендой вы берете
        машину на конкретное время -
        несколько часов, и оплачиваете именно это время. Договор заключается между компанией и физическим или
        юридическим
        (другая компания, организация) лицом. Обычно клиенты обращаются за услугой аренды автомобиля в Rentcar.my в тех
        случаях, когда им нужно:
        встретить гостей в аэропорту или на вокзале организовать транспортное сопровождение какого-либо мероприятия,
        развезти гостей и т.п.
        организовать свадебный кортеж реализовать собственную экскурсионную программу по Беларуси и даже за рубеж.
        К преимуществам услуги аренды можно отнести ее удобство, а также, клиенту не нужно беспокоиться о обслуживании
        машины.
        Разумеется, все сопутствующие расходы (топливо, стоянки) транспортная компания берет на себя.
    </p>


<%--<div class="container text-center my-5">
    <form class="form-signin" action="get_all_users">
        <button class="btn btn-lg btn-primary btn-block my-3" type="submit">User List</button>
    </form>
</div>
<div class="container text-center my-5">
    <form class="form-signin" action="ger_all_car_from_DB">
        <button class="btn btn-lg btn-primary btn-block my-3" type="submit">Car List</button>
    </form>
</div>
<div class="container text-center my-5">
    <form class="form-signin" action="get_user_by_id">
        <button name="id" value="25" class="btn btn-lg btn-primary btn-block my-3" type="submit">User</button>
    </form>
</div>--%>

</body>
</html>