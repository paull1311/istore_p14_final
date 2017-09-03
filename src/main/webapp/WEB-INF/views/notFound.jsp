<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Несуществующая страница" scope="request"/>
<jsp:include page="components/head.jsp"/>
<body>
<jsp:include page="components/header.jsp"/>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-12 text-center">
            <h1 class="display-1">404 - Страница отсутствует</h1>
            <h3 class="display-4">${errorMessage}</h3>
        </div>
    </div>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
