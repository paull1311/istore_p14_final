<%@ page import="edu.bionic.dto.ProductSort" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Каталог товаров" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">
        <div class="col-12 mt-5">
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
            <h1 class="text-center">Каталог товаров iShop</h1>
            <div class="row mt-1">
                <div class="col-12 col-sm-3 col-md-4 col-lg-4">
                    <form>
                        <div class="form-group">
                            <label for="name">Название товара</label>
                            <input type="text" id="name" name="name" value="${param.name}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Цена:</label>
                            <div class="row">
                                <div class="col-12 col-sm-2">
                                    <label for="min" class="text-left text-sm-right">от</label>
                                </div>
                                <div class="col-12 col-sm-4">
                                    <input type="text" id="min" name="min" value="${param.min}" class="form-control"/>
                                </div>
                                <div class="col-12 col-sm-2">
                                    <label for="max" class="text-left text-sm-right">до</label>
                                </div>
                                <div class="col-12 col-sm-4">
                                    <input type="text" id="max" name="max" value="${param.max}" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sort">Сортировка</label>
                            <select id="sort" name="sort" class="form-control">
                                <option value="<%= ProductSort.NAME_ASC.name() %>"
                                        <%= ProductSort.NAME_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                                    алфавиту А-Я
                                </option>
                                <option value="<%= ProductSort.NAME_DESC.name() %>"
                                        <%= ProductSort.NAME_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                                    алфавиту Я-А
                                </option>
                                <option value="<%= ProductSort.PRICE_ASC.name() %>"
                                        <%= ProductSort.PRICE_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>От
                                    дешевых к дорогим
                                </option>
                                <option value="<%= ProductSort.PRICE_DESC.name() %>"
                                        <%= ProductSort.PRICE_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>От
                                    дорогих к дешевым
                                </option>
                            </select>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-light">Поиск</button>
                        </div>
                    </form>
                </div>
                <div class="col-12 col-sm-9 col-md-8 col-lg-8">

                    <div id="catalog" class="row">
                        <c:forEach items="${products}" var="product">
                            <jsp:useBean id="product" type="edu.bionic.domain.Product"/>
                            <%--<li><c:out value="${product.printInfo()}"/></li>--%>
                            <div class="col-xs-6 col-sm-4">
                                <a href="<c:url value="products/${product.id}"/>" class="product">
                                    <img src="/resources/img/product-placeholder.jpg" class="img-thumbnail">
                                    <span class="info">${product.printInfo()}</span>
                                </a>
                            </div>
                        </c:forEach>
                    </div>

                    <%-- Paginator --%>
                    <nav>
                        <c:set var="page" value="${param.page != null ? param.page : 1}"/>
                        <c:set var="query" value="${pageContext.request.queryString != null ? pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
                        <ul class="pagination">
                            <c:forEach begin="1" end="${productCount % pageSize == 0 ? productCount / pageSize : productCount / pageSize + 1 }" varStatus="loop">
                                <c:choose>
                                    <c:when test="${page == loop.index}">
                                        <li class="page-item active">
                                            <span class="page-link">${loop.index}</span>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a href="<c:url value="products?${query}&page=${loop.index}"/>" class="page-link">
                                                    ${loop.index}
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </nav>

                    <div class="text-center text-sm-left">
                        <a href="<c:url value="/"/> class=" btn btn-light">
                        <i class="fa fa-chevron-left" aria-hidden="true"></i>
                        На главную
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
