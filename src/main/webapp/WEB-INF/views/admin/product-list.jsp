<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Админка - Список товаров" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">
        <div class="col-12 mt-5">

            <h1 class="text-center">Таблица товаров магазина</h1>

            <div class="mt-3 text-center text-sm-right">
                <a href="<c:url value="/admin/products/new"/>" class="btn btn-dark">
                    Добавить товар
                    <i class="fa fa-plus" aria-hidden="true"></i>
                </a>
            </div>

            <div id="admin-list" class="mt-3">
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <%--<th>Фото</th>--%>
                        <th>Имя</th>
                        <th>Цена</th>
                        <th>Цвет</th>
                        <th>Память</th>
                        <th>Экран</th>
                        <th>Описание</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <%--<td width="50"><img src="/resources/img/product-placeholder.jpg" class="img-thumbnail"></td>--%>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.color}</td>
                            <td>${product.capacity} GB</td>
                            <td>${product.display}</td>
                            <td>${product.description}</td>
                            <td>
                                <div class="form-group">
                                    <a href="<c:url value="/admin/products/${product.id}"/>" class="btn btn-outline-dark btn-block">
                                        Редактировать
                                    </a>
                                </div>
                                <form method="post" action="<c:url value="/admin/products/${product.id}/delete"/>">
                                    <button type="submit" class="btn btn-danger btn-block">Удалить</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
