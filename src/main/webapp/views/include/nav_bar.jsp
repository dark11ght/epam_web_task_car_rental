<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

        <div class="bd-example">
            <ul class="nav nav-pills">

                <li class="nav-item active">
                    <a class="nav-link" href="INDEX"> Главная </a>
                </li>

                <c:if test="${empty userRole}">
                    <li class="nav-item">
                        <c:if test="${empty param.error}">
                            <p class="text-danger">Вы не вошли в приложение, выполните</p>
                        </c:if>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="SignServlet" > Вход </a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="views/reg_page">Регистрация <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>


                    <c:if test="${userRole.equals('user')}">
                        <li class="nav-item">
                            <a class="nav-link" href="GetAllCarsServlet">Список автомобилей</a>
                        </li>
                    </c:if>

                    <c:if test="${userRole.equals('admin')}">
                        <li class="nav-item">
                            <a class="nav-link" href="GetAllCarsServlet">Список автомобилей </a>
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
                            <a class="nav-link" href="get_all_users">Список пользователей</a>
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
                            <a class="nav-link" href="get_admin_page">Админка</a>
                        </li>
                    </c:if>


                    <%-- <c:if test="${isUSer}">
                         <li class="nav-item">
                             <p class="text-info">Ваш логин <sec:authentication property="principal.username"/> с ролью:</p>
                             <p class="text-danger"><b><sec:authentication property="principal.authorities"/></b></p>

                         </li>
                     </c:if>--%>

                    <c:if test="${userRole.equals('user')}">
                        <form class="form-inline" action="LOGOUT" method="post">
                            <button class="btn btn-outline-danger " type="submit">Выйти</button>
                        </form>
                    </c:if>

                    <c:if test="${userRole.equals('admin')}">
                        <form class="form-inline" action="LOGOUT" method="post">
                            <button class="btn btn-outline-danger " type="submit">Выйти</button>
                        </form>
                    </c:if>


            </ul>
        </div>
    </div>
</nav>