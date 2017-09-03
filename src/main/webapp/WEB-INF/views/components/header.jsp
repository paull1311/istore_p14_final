<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header id="header">
    <div class="container">
        <div class="row justify-content-between">

            <div class="col-2 col-sm">
                <ul class="nav d-none d-sm-flex">
                    <li class="nav-item">
                        <a href="<c:url value="/"/>" class="nav-link">
                            Главная
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value="/products"/>" class="nav-link">
                            Товары
                        </a>
                    </li>
                    <sec:authorize url="/orders">
                        <li class="nav-item">
                            <a href="<c:url value="/orders"/>" class="nav-link">
                                Предыдущие заказы
                            </a>
                        </li>
                    </sec:authorize>
                </ul>
                <div class="dropdown d-block d-sm-none">
                    <button type="button" data-toggle="dropdown" class="btn btn-link dropdown-toggle">
                        <i class="fa fa-bars" aria-hidden="true"></i>
                    </button>
                    <div class="dropdown-menu">
                        <a href="<c:url value="/"/>" class="dropdown-item">
                            Главная
                        </a>
                        <a href="<c:url value="/products"/>" class="dropdown-item">
                            Товары
                        </a>
                        <sec:authorize url="/orders">
                            <a href="<c:url value="/orders"/>" class="dropdown-item">
                                Предыдущие заказы
                            </a>
                        </sec:authorize>
                    </div>
                </div>
            </div>

            <sec:authorize access="isAuthenticated()">
                <div class="col-10 col-sm-auto">
                    <form:form servletRelativeAction="/logout">
                        <sec:authorize url="/admin/products">
                            <a href="<c:url value="/admin/products"/>" class="btn btn-link">Админпанель</a>
                        </sec:authorize>
                        <button type="submit" class="btn btn-light">Выйти</button>
                    </form:form>
                </div>
            </sec:authorize>

            <sec:authorize access="isAnonymous()">
                <div class="col-10 col-sm-auto text-right">
                    <a href="<c:url value="/register"/>" class="btn btn-link">Зарегистрироваться</a>
                    <a href="<c:url value="/login"/>" class="btn btn-light">Войти</a>
                </div>
            </sec:authorize>

        </div>
    </div>
</header>