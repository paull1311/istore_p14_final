<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Главная" scope="request"/>
<jsp:include page="components/head.jsp"/>
<body>
<jsp:include page="components/header.jsp"/>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-12">
            <h1 class="text-center">Добро пожаловать в My Cash</h1>
        </div>
        <div class="col-12 col-sm-8 ml-sm-auto col-md-6 ml-md-auto col-lg-6 ml-lg-auto">
            <blockquote class="blockquote text-right">
                <p class="mb-0">Бороться и искать, найти и перепрятать.</p>
                <footer class="blockquote-footer">Народная мудрость</footer>
            </blockquote>
        </div>
    </div>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
