<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Регистрация" scope="request"/>
<jsp:include page="components/head.jsp"/>
<body>
<jsp:include page="components/header.jsp"/>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-12">
            <h1 class="text-center">Регистрация нового пользователя</h1>
            <div class="row justify-content-center">
                <div class="col-12 col-sm-10 col-md-6 col-lg-6">
                    <form:form modelAttribute="newUser">
                        <div class="form-group">
                            <label>Email</label>
                            <form:input path="email" class="form-control"/>
                            <form:errors path="email" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Пароль</label>
                            <form:input path="password" class="form-control"/>
                            <form:errors path="password" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <strong>Информация о себе:</strong>
                        </div>
                        <div class="form-group">
                            <label>Имя</label>
                            <form:input path="name" class="form-control"/>
                            <form:errors path="name" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <div class="row justify-content-between">
                                <div class="col-auto">
                                    <a href="<с:url value="/"/>" class="btn btn-light">
                                        <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                        На главную
                                    </a>
                                </div>
                                <div class="col-auto">
                                    <button type="submit" class="btn btn-dark">Зарегистрироваться</button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="components/footer.jsp"/>
</body>
</html>
