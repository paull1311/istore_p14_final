<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Оформление заказа" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">

        <div class="col-12 text-center text-sm-left mt-5">
            <a href="<c:url value="/products"/>" class=" btn btn-light">
            <i class="fa fa-chevron-left" aria-hidden="true"></i>
            Вернться к покупкам
            </a>
        </div>

        <div class="col-12">

            <c:if test="${currentOrder.products.size() == 0}">
                <div class="alert alert-dark">
                    На данный момент товаров в корзине нет
                </div>
            </c:if>

            <c:if test="${currentOrder.products.size() > 0}">

                <div id="cart">
                    <h1 class="text-center">Товары в корзине</h1>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>№</th>
                            <th>Товар</th>
                            <th>Цена</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${currentOrder.products}" var="product" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${product.name} ${product.color} ${product.capacity} GB</td>
                                <td class="text-center">${product.price}</td>
                                <td width="5">
                                    <form:form servletRelativeAction="/orders/newOrder/removeProduct?index=${loop.index}">
                                        <button type="submit" class="btn btn-outline-danger">
                                            <i class="fa fa-times" aria-hidden="true"></i></button>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="2" class="text-right">Общая сумма:</td>
                            <td class="text-center font-weight-bold">${currentOrder.totalAmount} USD</td>
                            <td></td>
                        </tr>
                        </tfoot>
                    </table>
                </div>

                <h2>Оформление заказа: </h2>
                <div class="row  justify-content-center">
                    <div class="col-12 col-sm-10 col-md-6 col-lg-6">
                        <form:form modelAttribute="currentOrder">
                            <div class="form-group">
                                <label for="name">Имя:</label>
                                <form:input path="name" class="form-control"/>
                                <form:errors path="name" class="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <form:input path="email" class="form-control"/>
                                <form:errors path="email" class="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="phone">Телефон:</label>
                                <form:input path="phone" id="phone" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="address">Адрес доставки:</label>
                                <form:textarea path="address" rows="10" cols="30" class="form-control"/>
                                <form:errors path="address" class="text-danger"/>
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-dark">Отправить заказ</button>
                            </div>
                        </form:form>
                    </div>
                </div>

            </c:if>

        </div>

    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
