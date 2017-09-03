<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="${product.name}" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">

        <div class="col-12 text-center text-sm-left mt-5">
            <a href="<c:url value="/products"/>" class=" btn btn-light">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
                Вернуться
            </a>
        </div>

        <div class="col-12 mt-3">

            <c:if test="${currentOrder.products.size() > 0}">
                <div class="alert alert-dark">
                    <div class="row">
                        <div class="col-12 col-sm-7 col-md-8">
                            <div>Количество товаров в корзине: <strong>${currentOrder.products.size()}</strong></div>
                            <div>Общая сумма <strong>${currentOrder.totalAmount}</strong></div>
                        </div>
                        <div class="col-12 col-sm-5 col-md-4 text-center text-sm-right">
                            <a href="<c:url value="/orders/newOrder"/>" class="btn btn-outline-dark">
                                Перейти к оформлению заказа
                                <i class="fa fa-chevron-right" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </c:if>

            <div id="product" class="row">
                <div class="col-12 col-sm-4">
                    <img src="/resources/img/product-placeholder.jpg" class="img-thumbnail">
                </div>
                <div class="col-12 col-sm-8">
                    <h1 class="text-center text-sm-left">${product.name}</h1>
                    <div class="price text-center text-sm-right">Цена:
                        <span class="text-danger">${product.price} USD</span></div>
                    <table class="table">
                        <thead class="thead-default">
                        <tr>
                            <th colspan="2">Характеристики:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Цвет:</th>
                            <td>${product.color}</td>
                        </tr>
                        <tr>
                            <th scope="row">Экран:</th>
                            <td>${product.display}</td>
                        </tr>
                        <tr>
                            <th scope="row">Память:</th>
                            <td>${product.capacity} GB</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="mt-3 text-center text-sm-right">
                        <form:form method="post" servletRelativeAction="/products/${product.id}/addToBasket">
                            <button type="submit" class="btn btn-dark">Добавить в корзину</button>
                        </form:form>
                    </div>
                </div>
            </div>

            <div class="row mt-5">
                <div class="col-12">
                    <h4>Отзывы:</h4>
                    <c:forEach items="${comments}" var="comment">
                        <div class="comment">
                            <div class="date">${comment.dateTime.format(dateTimeFormatter)}</div>
                            <div class="head">
                                <strong>${comment.author}</strong> <u>Оценка: ${comment.rating}</u>
                            </div>
                            <div class="body">
                                    ${comment.text}
                            </div>
                        </div>
                    </c:forEach>
                    <h4>Оставить свой отзыв</h4>
                    <form:form modelAttribute="newComment" method="post" servletRelativeAction="/comments/">
                        <div class="form-group">
                            <label for="name">Имя:</label>
                            <form:input type="text" id="name" path="author" class="form-control"/>
                            <form:errors path="author" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label for="comment">Комментарий:</label>
                            <form:textarea id="comment" path="text" rows="10" cols="30" class="form-control"/>
                            <form:errors path="text" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Выставить оценку:</label>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="radio1">1
                                    <form:radiobutton id="radio1" path="rating" value="1"/>
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="radio2">2
                                    <form:radiobutton id="radio2" path="rating" value="2"/>
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="radio3">3
                                    <form:radiobutton id="radio3" path="rating" value="3"/>
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="radio4">4
                                    <form:radiobutton id="radio4" path="rating" value="4"/>
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="radio5">5
                                    <form:radiobutton id="radio5" path="rating" value="5" checked="checked"/>
                                </label>
                            </div>
                        </div>
                        <form:hidden path="product.id" value="${product.id}"/>
                        <div class="form-group text-center text-sm-right">
                            <button type="submit" class="btn btn-dark">Отправить</button>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
