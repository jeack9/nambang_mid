<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.shoping__cart__total li{
	list-style : none;
}
.shoping__cart__total li:nth-of-type(2){
	color: rgb(181, 181, 181);
    text-decoration: line-through;
}
</style>
<section class="checkout spad">
	<div class="container">
		<div class="checkout__form">
			<h4 class="d-flex justify-content-center">주문서</h4>
			<form action="payOrder.do" method="get" name="paymentfrm" onsubmit="return ckPay()">
				<div class="row">
					<div class="col-lg-8 col-md-6">
						<div class="shoping__cart__table">
							<h4 class="d-flex justify-content-between">
								<span>주문상품</span>
								<svg width="30" height="30" viewBox="0 0 30 30"
									xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink">
									<defs>
									<path id="7a02qqg3ja" d="M11 12h9v9"></path></defs>
									<g fill="none" fill-rule="evenodd">
									<path d="M0 0h30v30H0z"></path>
									<use stroke="#333" stroke-width="2" stroke-linecap="square"
										transform="rotate(135 15.5 16.5)" href="#7a02qqg3ja"></use></g></svg>
							</h4>
							<table>
								<tbody>
									<c:forEach var="cart" items="${list}">
										<!-- List<map>  -->
										<tr>
											<td class="shoping__cart__item">
												<input type="text" value="${cart.get('CART_NO') }" name="cartNo" hidden="hidden">
												<input type="text" value="${cart.get('PRODUCT_CODE') }" name="code" hidden="hidden">
												<img src="image/${cart.get('PRODUCT_IMAGE') }" alt="" width="100">
												<h5>[${cart.get('COMPANY') }] ${cart.get('PRODUCT_NAME') }</h5>
											</td>
											<td class="shoping__cart__quantity">
												<input type="text" value="${cart.get('CART_VOLUME') }" name="volume" hidden="hidden">
												${cart.get('CART_VOLUME') }
											</td>
											<td class="shoping__cart__total">
												<ul>
													<c:choose>
														<c:when test="${cart.get('OFF_PRICE') ne 0 }">
															<li>${cart.get('CART_VOLUME') * cart.get('OFF_PRICE')}</li>
															<li>${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
															<input type="text" value="${cart.get('CART_VOLUME') * cart.get('OFF_PRICE')}" name="proPrice" hidden="hidden">
														</c:when>
														<c:otherwise>
															<li>${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
															<li style="display: none;">${cart.get('CART_VOLUME') * cart.get('PRICE')}</li>
															<input type="text" value="${cart.get('CART_VOLUME') * cart.get('PRICE')}" name="proPrice" hidden="hidden">
														</c:otherwise>
													</c:choose>
												</ul>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div> <!-- div.shoping__cart__table END-->
						<div id="orderInfo">
							<h4>주문자 정보</h4>
							<p>보내는분: ${login.userName }</p>
							<p>휴대폰: ${login.phone}</p>
							<p>이메일: ${login.email}</p>
						</div>
						<div id="deliverInfo">
							<input type="text" value="${avo.addrNo }" name="addrNo" hidden="hidden">
							<h4>배송 정보</h4>
							<p>배송지: ${avo.addr1} / ${avo.addr2 }</p>
							<p>휴대폰: ${login.phone}</p>
							<p><label for="yocheong">요청사항: </label><input class="form-control" type="text" id="yocheong" name="yocheong"></p>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="checkout__order" style="position: sticky; top: 0;">
							<h4>결제 금액</h4>
							<div class="checkout__order__products">상품<span>주문금액</span>
							</div>
							<ul>
							<c:forEach var="cart" items="${list}">
								<c:choose>
									<c:when test="${cart.get('OFF_PRICE') ne 0 }">
									<li>${cart.get('PRODUCT_NAME')}<span class="price">${cart.get('CART_VOLUME') * cart.get('OFF_PRICE')}</span></li>
									</c:when>
									<c:otherwise>
									<li>${cart.get('PRODUCT_NAME')}<span class="price">${cart.get('CART_VOLUME') * cart.get('PRICE')}</span></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</ul>
							<!-- <div class="checkout__order__subtotal">
								Subtotal <span>$750.99</span>
							</div> -->
							<div class="checkout__order__total">
							최종결제금액
							<span id="order_price">22</span>
							<input type="text" name="orderPrice" value="" hidden="hidden">
							</div>
							<div class="checkout__input__checkbox">
								<label for="isPayment"> 결제 확인 <input type="checkbox" id="isPayment" checked> <span class="checkmark"></span>
								</label>
							</div>
							<c:if test="${!empty login }">
							<button type="submit" class="site-btn">결제하기</button>
							</c:if>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script>
//최종 결제금액 view 업데이트
let orderPrice = 0;
document.querySelectorAll(".price").forEach(price => {
	orderPrice += parseInt(price.innerText);
});
document.querySelector("#order_price").innerText = orderPrice;
document.querySelector("#order_price+input").value = orderPrice;

// 결제동의 체크
function ckPay() {
	let isPayment = document.querySelector("input#isPayment").checked;
	if(!isPayment) alert("결제 확인을 동의해주세요.");
	return isPayment;
}
</script>