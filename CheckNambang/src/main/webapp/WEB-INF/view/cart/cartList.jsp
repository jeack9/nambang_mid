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
.shoping__checkout p {
	font-weight : bold;
	word-break: break-word;
}
</style>
<section class="shoping-cart spad">
	<form action="" name="orderfrm" method="get">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__table">
				<h2 class="d-flex justify-content-center">장바구니</h2>
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" onclick="checkAll(this)" class="ckAll" checked></th>
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
								<td><input type="checkbox" id="cart${cart.get('CART_NO') }" name="cartNo" value="${cart.get('CART_NO') }" onclick="check(this)" checked></td>
								<td class="shoping__cart__item"><img
									src="img/${cart.get('PRODUCT_IMAGE') }" alt="" width="100">
									<h5>${cart.get('COMPANY') }${cart.get('PRODUCT_NAME') }</h5></td>
								<td class="shoping__cart__quantity">
									<div class="quantity">
										<div class="pro-qty" data-no="${cart.get('CART_NO') }" data-pcode="${cart.get('PRODUCT_CODE') }">
											<input type="text" value="${cart.get('CART_VOLUME') }">
										</div>
									</div>
								</td>
								<td class="shoping__cart__total">
								<ul>
								<c:choose>
								  <c:when test="${!empty cart.get('OFF_PRICE') }">
								  <li class="off" id="off${cart.get('CART_NO')}" data-no="${cart.get('CART_NO')}">${cart.get('CART_VOLUME') * cart.get('OFF_PRICE')}</li>
								  <li class="cost" id="cost${cart.get('CART_NO')}" data-no="${cart.get('CART_NO')}">${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
								  </c:when>
								  <c:otherwise>
								  <li class="cost" id="cost${cart.get('CART_NO')}" data-no="${cart.get('CART_NO')}">${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
								  <li class="off" id="off${cart.get('CART_NO')}" data-no="${cart.get('CART_NO')}" style="display: none;">${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
								  </c:otherwise>
								</c:choose>
								</ul>
								</td>
								<td class="shoping__cart__item__close"><span class="icon_close" data-no="${cart.get('CART_NO')}"></span></td>
							</tr>
							</c:forEach>
						</tbody>
						<!-- <thead>
							<tr>
								<th><input type="checkbox"></th>
								<th class="shoping__product">상품</th>
								<th>수량</th>
								<th>가격</th>
								<th></th>
							</tr>
						</thead> -->
					</table>
				</div>
			</div> <!-- 카트상품 END -->
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__btns">
					<a href="" class="primary-btn cart-btn">선택 삭제</a> 
					<a href="cartList.do" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span> 장바구니 업데이트</a>
					<a href="productList.do" class="primary-btn cart-btn cart-btn-right">쇼핑 계속하기</a> 
				</div>
			</div>
			<div class="col-lg-6">
				<div class="shoping__continue">
					<div class="shoping__checkout">
						<h5>배송지 정보</h5>
						<p>${addr.addr1} ${addr.addr2}</p>
						<p>수취인 : ${addr.getter }</p>
						<p>연락처 : ${addr.getterPhone }</p>
						<button type="button" onclick="modiAddr(event)" class="primary-btn">배송지 변경</button>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="shoping__checkout">
					<h5>총 금액</h5>
					<ul>
						<li>상품금액 <span id="subtotal" style="color:#000;">$</span></li>
						<li>결제 예정 금액 <span id="total">$</span></li>
					</ul>
					<c:if test="${!empty login }">
					<a href="#" id="orderBtn" class="primary-btn" onclick="orderFnc(event)">주문하기</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	</form>
</section>
<!-- Shoping Cart Section End -->
<script src="js/volume.js" defer></script>