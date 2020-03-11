<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

        <div class="bd-example">
            <ul class="nav nav-pills">

                <li class="nav-item active">
                    <a class="nav-link" href="Controller?command=INDEX_PAGE"> Главная </a>
                </li>

                <c:if test="${empty userRole}">

                    <li class="nav-item active">
                        <a class="nav-link" href="Controller?command=SIGN_IN_PAGE"> Вход </a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link" href="Controller?command=REGISTRATION">Регистрация <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="Controller?command=CARS_LIST">Список автомобилей</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="Controller?command=CARS_LIST">Список автомобилей </a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="get_user_info_page">Профиль</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="get_user_info_page">Профиль</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="Controller?command=ALL_USER_LIST">Список пользователей</a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="get_orders_by_user_id">Мои заказы</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="get_orders_by_user_id">Мои заказы</a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="Controller?command=ADMIN_PAGE">Админка</a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <form class="form-inline" action="Controller" method="post">
                        <button class="btn btn-outline-danger " name="command" value="LOGOUT" type="submit">Выйти
                        </button>
                    </form>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <form class="form-inline" action="Controller" method="post">
                        <button class="btn btn-outline-danger " name="command" value="LOGOUT" type="submit">Выйти
                        </button>
                    </form>
                </c:if>


            </ul>
        </div>
    </div>
</nav>