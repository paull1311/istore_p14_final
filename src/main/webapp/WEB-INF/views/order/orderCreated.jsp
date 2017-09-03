<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Заказ принят" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row align-items-center">

        <div class="col-12 mt-5">

            <h1 class="text-center">Заказ успешно сохранен</h1>

            <div class="alert alert-success mt-5">
                Менеджеры свяжуться с вами в ближайшее время.
            </div>

            <div class="text-center text-sm-left mt-5">
                <a href="<c:url value="/"/>" class="btn btn-light">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
                Вернуться на главную
                </a>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
