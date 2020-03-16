<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration page</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/nav_bar.jsp" %>


<form class="needs-validation" action="controller" novalidate method="POST">
    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="login">Логин</label>
            <input type="text" class="form-control" name="login" id="login" placeholder="Логин" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="password">Пароль</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Пароль" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="rpassword">Повторить пароль</label>
            <input type="password" class="form-control" name="rpassword" id="rpassword" placeholder="Пароль" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="firstName">Логин</label>
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Имя" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="lastName">Логин</label>
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Фамилия" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="email">Email</label>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                </div>
                <input type="text" class="form-control" name="email" id="email" placeholder="example@mail.com."
                       aria-describedby="inputGroupPrepend" required>
                <div class="invalid-feedback">
                    Пожалуйста заполните это поле.
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="passportSerialNumber">Номер пасспорта</label>
            <input type="text" class="form-control" name="passportSerialNumber" id="passportSerialNumber"
                   placeholder="Номер пасспорта" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="phoneNumber">Номер телефона</label>
            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="+375291234567"
                   required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <label for="driverLicenceNumber">Номер водительсного удостоверения</label>
            <input type="text" class="form-control" name="driverLicenceNumber" id="driverLicenceNumber"
                   placeholder="Номер водительсного удостоверения" required>
            <div class="invalid-feedback">
                Пожалуйста заполните это поле.
            </div>
        </div>

        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                <label class="form-check-label" for="invalidCheck">
                    Agree to terms and conditions
                </label>
                <div class="invalid-feedback">
                    Пожалуйста подтвердите.
                </div>
            </div>
        </div>
        <button class="btn btn-primary" type="submit" name="command" value="USER_REGISTRATION">Registration</button>
    </div>
</form>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>

</body>
</html>
