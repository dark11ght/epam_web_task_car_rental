<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration page</title>
    <%@include file="include/header.jsp" %>
    <script src="js/registration_page.js" type="text/javascript"></script>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>


<div class="container">
    <form class="form-horizontal" role="form" method="POST" action="controller">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Заказ авто ${sessionScope.orderCarMark}, ${sessionScope.orderCarModel} </h2>
                <hr>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="rent_days">Количество часов аренды</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="rent_days" class="form-control" id="rent_days" placeholder=1..." required="" autofocus="">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <label for="notes">Notes</label>
            <textarea class="form-control" name="notes" id="notes" rows="3"></textarea>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" name="command" value="CREATE_ORDER" class="btn btn-success"><i class="fa fa-user-plus"></i> Apply</button>
            </div>
        </div>
    </form>
</div>
<footer>
    <div id="footer">
        <%@include file="include/footer.jsp" %>
    </div>
</footer>
</body>
</html>
