<%@ page import="edu.bionic.domain.Color" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Редактирование продукта" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">
        <div class="col-12 mt-5">

            <h1 class="text-center">${isNew ? "Новый товар" : "Редактирование товара №".concat(product.id)}</h1>

            <c:if test="${updateIsSuccessful}">
                <div class="alert alert-success mt-5">Изменения сохранены</div>
            </c:if>

            <form:form modelAttribute="product">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label for="name">Наименование</label>
                    <form:input path="name" class="form-control"/>
                    <form:errors path="name" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="price">Цена</label>
                    <form:input path="price" class="form-control"/>
                    <form:errors path="price" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="color">Цвет</label>
                    <form:radiobuttons path="color" items="<%= Color.values()%>"/>
                    <form:errors path="color" class="text-danger"/>
                </div>
                <div class="row">
                    <div class="col-12 col-sm-6">
                        <div class="form-group">
                            <label for="capacity">Память, GB</label>
                            <form:input path="capacity" class="form-control"/>
                            <form:errors path="capacity" class="text-danger"/>
                        </div>
                    </div>
                    <div class="col-12 col-sm-6">
                        <div class="form-group">
                            <label for="display">Экран</label>
                            <form:input path="display" class="form-control"/>
                            <form:errors path="display" class="text-danger"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Описание</label><br>
                    <form:textarea path="description" rows="10" cols="30" class="form-control"/>
                </div>

                <div class="form-group">
                    <div class="row justify-content-between">
                        <div class="col-auto">
                            <a href="<c:url value="/admin/products"/>" class="btn btn-light">
                                <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                Вернуться
                            </a>
                        </div>
                        <div class="col-auto">

                            <button type="submit" class="btn btn-dark">Сохранить</button>
                        </div>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>

<jsp:include page="../components/footer.jsp"/>
</body>
</html>
