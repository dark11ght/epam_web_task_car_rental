<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="bd-example">
            <ul class="nav nav-pills">

                <li class="nav-item active">
                    <a class="nav-link" href="controller?command=INDEX_PAGE"> Главная </a>
                </li>

                <c:if test="${empty userRole}">

                    <li class="nav-item active">
                        <a class="nav-link" href="controller?command=SIGN_IN_PAGE"> Вход </a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link" href="controller?command=USER_REGISTRATION_PAGE"
                           methods="POST">Регистрация </a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=CARS_LIST">Список автомобилей</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=CARS_LIST">Список автомобилей </a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=USER_INFO_PAGE">Профиль</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=USER_INFO_PAGE">Профиль</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=ALL_USER_LIST">Список
                            пользователей</a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=ORDERS_BY_USER_ID&userID=${user.id}">Мои заказы</a>
                    </li>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=ORDERS_BY_USER_ID&userID=${ActiveUserId}">Мои заказы</a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=ADMIN_PAGE">Админка</a>
                    </li>
                </c:if>


                <c:if test="${userRole.equals('user')}">
                    <form class="form-inline" action="controller" method="POST">
                        <button class="btn btn-outline-danger " name="command" value="LOGOUT" type="submit">Выйти
                        </button>
                    </form>
                </c:if>

                <c:if test="${userRole.equals('admin')}">
                    <form class="form-inline" action="controller" method="POST">
                        <button class="btn btn-outline-danger " name="command" value="LOGOUT" type="submit">Выйти
                        </button>
                    </form>
                </c:if>


                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="true"
                       aria-expanded="false">Язык</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">RU</a>
                        <a class="dropdown-item" href="#">EN</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>