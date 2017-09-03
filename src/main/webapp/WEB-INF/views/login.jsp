<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Вход" scope="request"/>
<jsp:include page="components/head.jsp"/>
<body>
<jsp:include page="components/header.jsp"/>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-12">
            <h1 class="text-center">Вход</h1>
            <div class="row justify-content-center">
                <div class="col-12 col-sm-10 col-md-6 col-lg-6">
                    <c:if test="${param.error != null}">
                        <div class="form-group">
                            <div class="text-danger">Неправильное имя или пароль</div>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="form-group">
                            <div class="text-success">Вы успешно вышли</div>
                        </div>
                    </c:if>
                    <form:form>
                        <div class="form-group">
                            <label for="username">Email</label>
                            <input id="username" name="username" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Пароль</label>
                            <input type="password" id="password" name="password" class="form-control"/>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-dark">Войти</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="components/footer.jsp"/>
</body>
</html>
