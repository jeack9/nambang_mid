<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__table">
				<form>
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
								<td><input type="checkbox"></td>
								<td class="shoping__cart__item"><img
									src="img/cart/cart-1.jpg" alt="">
									<h5>Vegetable’s Package</h5></td>
								<td class="shoping__cart__quantity">
									<div class="quantity">
										<div class="pro-qty">
											<input type="text" value="1">
										</div>
									</div>
								</td>
								<td class="shoping__cart__total">$110.00</td>
								<td class="shoping__cart__item__close"><span
									class="icon_close"></span></td>
							</tr>
						</tbody>
					</table>
				</form>
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