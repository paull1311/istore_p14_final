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
            <h1 class="text-center">Добро пожаловать в мазазин iShop</h1>
        </div>
        <div class="col-12 col-sm-8 ml-sm-auto col-md-6 ml-md-auto col-lg-6 ml-lg-auto">
            <blockquote class="blockquote text-right">
                <p class="mb-0">Создавать продукт, опираясь на фокус-группы, по-настоящему трудно. Чаще всего люди не понимают, что им на самом деле нужно, пока сам им этого не покажешь.</p>
                <footer class="blockquote-footer">Стив Джобс</footer>
            </blockquote>
        </div>
    </div>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
