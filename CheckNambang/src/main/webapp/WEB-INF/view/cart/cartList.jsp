<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Shoping Cart Section Begin -->
<style>
.shoping__cart__total li{
	list-style : none;
}
.shoping__cart__total li:nth-of-type(2){
	color: rgb(181, 181, 181);
    text-decoration: line-through;
}
</style>
<section class="shoping-cart spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__table">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox"></th>
								<th class="shoping__product">상품</th>
								<th>수량</th>
								<th>가격</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td><img src="img/냉동.jpg" width="50"></td>
							<td colspan="4"><h4 style="text-align: left">냉동</h4></td>
							</tr>
							<c:forEach var="cart" items="${cartList}"> <!-- List<map>  -->
							<tr id="C${cart.get('CART_NO') }">
								<td><input type="checkbox"></td>
								<td class="shoping__cart__item"><img
									src="img/${cart.get('PRODUCT_IMAGE') }" alt="" width="100">
									<h5>${cart.get('COMPANY') }${cart.get('PRODUCT_NAME') }</h5></td>
								<td class="shoping__cart__quantity">
									<div class="quantity">
										<div class="pro-qty" data-no="${cart.get('CART_NO') }">
											<input type="text" value="${cart.get('CART_VOLUME') }">
										</div>
									</div>
								</td>
								<td class="shoping__cart__total">
								<ul>
								<c:choose>
								  <c:when test="${!empty cart.get('OFF_PRICE') }">
								  <li id="off${cart.get('CART_NO')}">${cart.get('CART_VOLUME') * cart.get('OFF_PRICE')}</li>
								  <li id="cost${cart.get('CART_NO')}">${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
								  </c:when>
								  <c:otherwise>
								  <li>${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
								  <li></li>
								  </c:otherwise>
								</c:choose>
								</ul>
								</td>
								<td class="shoping__cart__item__close"><span class="icon_close"></span></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div> <!-- 카트상품 END -->
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__btns">
					<a href="#" class="primary-btn cart-btn">CONTINUE SHOPPING</a> <a
						href="#" class="primary-btn cart-btn cart-btn-right"><span
						class="icon_loading"></span> Upadate Cart</a>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="shoping__continue">
					<div class="shoping__discount">
						<h5>Discount Codes</h5>
						<form action="#">
							<input type="text" placeholder="Enter your coupon code">
							<button type="submit" class="site-btn">APPLY COUPON</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="shoping__checkout">
					<h5>Cart Total</h5>
					<ul>
						<li>Subtotal <span>$454.98</span></li>
						<li>Total <span>$454.98</span></li>
					</ul>
					<a href="#" class="primary-btn">PROCEED TO CHECKOUT</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Shoping Cart Section End -->
<script src="js/volume.js" defer></script>