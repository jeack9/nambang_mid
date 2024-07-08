<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.modal {
	position: absolute;
	display: none;
	justify-content: center;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.4);
}

.cart_btn {
	margin-top: 7px;
	width: 262.48px;
}

.modal_body {
	position: absolute;
	top: 50%;
	width: 400px;
	height: 600px;
	padding: 40px;
	text-align: center;
	background-color: rgb(255, 255, 255);
	border-radius: 10px;
	box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
	transform: translateY(-50%);
}

#modal_img {
	width: 100px; /* 원하는 너비로 설정 */
	height: 100px; /* 원하는 높이로 설정 */
	background-size: cover; /* 이미지가 요소의 크기에 맞게 조정되도록 설정 */
	background-position: center; /* 이미지가 중앙에 오도록 설정 */
}

table {
	border-collapse: collapse
}

table tr, table td {
	border-bottom: 0.01px dotted black;
	text-align: center;
}

/* 이미지 확대 효과를 적용할 요소 선택 */
.product_img {
	transition: transform 0.3s ease; /* 변환 애니메이션 적용 */
}

/* 마우스 오버 시 확대 효과 적용 */
.product_img:hover {
	transform: scale(1.1); /* 이미지 1.1배 확대 */
}

#dePrice {
	text-decoration: line-through;
	text-decoration-thickness: 1px;
	margin: 0;
}

#product_price {
	color: red;
}

a.active {
	background: #7fad39;
	color: #ffffff;
}

.sidebar__item ul li a:hover {
	color: red;
}
</style>

<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-5">
				<div class="sidebar">
					<div class="sidebar__item">
						<h4>카테고리</h4>
						<ul>
							<c:forEach var="vo" items="${category }">
								<li><a href="#">${vo.category }</a></li>
							</c:forEach>
						</ul>
					</div>

					<div class="sidebar__item sidebar__item__color--option">
						<h4>브랜드 초성</h4>
						<div class="sidebar__item__color sidebar__item__color--white sidebar_chosung">
								<c:forEach var="cho" items="${chosung }">
									<li><a href="#">${cho.brandChosung }</a></li>
								</c:forEach>
						</div>
					</div>

					<!-- 임시로 데이터 확인 -->
					<c:forEach var="cho" items="${choSung}">
						<p>${cho.chosung}</p>
					</c:forEach>

					<div class="sidebar__item">
						<h4>Popular Size</h4>
						<div class="sidebar__item__size">
							<label for="large"> Large <input type="radio" id="large">
							</label>
						</div>
						<div class="sidebar__item__size">
							<label for="medium"> Medium <input type="radio"
								id="medium">
							</label>
						</div>
						<div class="sidebar__item__size">
							<label for="small"> Small <input type="radio" id="small">
							</label>
						</div>
						<div class="sidebar__item__size">
							<label for="tiny"> Tiny <input type="radio" id="tiny">
							</label>
						</div>
					</div>
					<div class="sidebar__item">
						<div class="latest-product__text">
							<h4>Latest Products</h4>
							<div
								class="latest-product__slider owl-carousel owl-loaded owl-drag">


								<div class="owl-stage-outer">
									<div class="owl-stage"
										style="transform: translate3d(-787px, 0px, 0px); transition: all 1.2s ease 0s; width: 1575px;">
										<div class="owl-item cloned" style="width: 262.5px;">
											<div class="latest-prdouct__slider__item">
												<a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-1.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-2.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-3.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a>
											</div>
										</div>
										<div class="owl-item cloned" style="width: 262.5px;">
											<div class="latest-prdouct__slider__item">
												<a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-1.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-2.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-3.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a>
											</div>
										</div>
										<div class="owl-item" style="width: 262.5px;">
											<div class="latest-prdouct__slider__item">
												<a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-1.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-2.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-3.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a>
											</div>
										</div>
										<div class="owl-item active" style="width: 262.5px;">
											<div class="latest-prdouct__slider__item">
												<a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-1.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-2.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-3.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a>
											</div>
										</div>
										<div class="owl-item cloned" style="width: 262.5px;">
											<div class="latest-prdouct__slider__item">
												<a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-1.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-2.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-3.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a>
											</div>
										</div>
										<div class="owl-item cloned" style="width: 262.5px;">
											<div class="latest-prdouct__slider__item">
												<a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-1.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-2.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a> <a href="#" class="latest-product__item">
													<div class="latest-product__item__pic">
														<img src="img/latest-product/lp-3.jpg" alt="">
													</div>
													<div class="latest-product__item__text">
														<h6>Crab Pool Security</h6>
														<span>$30.00</span>
													</div>
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="owl-nav">
									<button type="button" role="presentation" class="owl-prev">
										<span class="fa fa-angle-left"><span></span></span>
									</button>
									<button type="button" role="presentation" class="owl-next">
										<span class="fa fa-angle-right"><span></span></span>
									</button>
								</div>
								<div class="owl-dots disabled"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9 col-md-7 tbody">
				<div class="filter__item">
					<div class="row">
						<div class="col-lg-4 col-md-5">
							<div class="filter__sort">
								<span>Sort By</span> <select style="display: none;">
									<option value="0">Default</option>
									<option value="0">Default</option>
								</select>
								<div class="nice-select" tabindex="0">
									<span class="current">Default</span>
									<ul class="list">
										<li data-value="0" class="option selected">Default</li>
										<li data-value="0" class="option">Default</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4">
							<div class="filter__found">
								<h6>
									<span>16</span> Products found
								</h6>
							</div>
						</div>
						<div class="col-lg-4 col-md-3">
							<div class="filter__option">
								<span class="icon_grid-2x2"></span> <span class="icon_ul"></span>
							</div>
						</div>
					</div>
				</div>

				<!--  상품리스트 -->
				<div class="col-lg-4 col-md-6 col-sm-6" id="product_id"
					style="display: none;">
					<div class="product__item product_list">
						<div class="product__item__pic set-bg product_img"
							data-setbg="img/product/product-1.jpg"
							style="background-image: url(&quot;img/product/product-1.jpg&quot;);">
							<a href="hyunControl4.do?proCode="></a>
						</div>

						<!-- 모달창버튼 -->
						<button type="button" class="btn btn-outline-success cart_btn"
							style="width: 262.48px;" data-toggle="modal"
							data-target="#exampleModalScrollable">⛟ 장바구니 담기</button>
						<div class="product__item__text product_text">
							<h5 id="product_title" style="font-weight: 1000;">Crab Pool
								Security</h5>
							<p style="front-size: 5px;" id="dePrice">할인전가격</p>
							<h5 id="product_price" style="font-weight: 700;">$30.00</h5>
							<h6>hugiCnt</h6>
						</div>
					</div>
				</div>
				<div class="row" id="product_list"></div>
				<!--  페이지 -->
				<div class="product__pagination">
					<a href="#" style="display: none"><i
						class="fa fa-long-arrow-left"></i></a> <a href="#"
						style="display: none">1</a> <a href="#" style="display: none"><i
						class="fa fa-long-arrow-right"></i></a>
					<div></div>
				</div>
			</div>
			<!--  end of tbody -->
			<!-- Modal -->
			<div class="modal fade" id="exampleModalScrollable" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalScrollableTitle"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-scrollable" role="document"
					style="">
					<div class="modal-content">
						<div class="modal-header">
							⛟ 장바구니 담기
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<!-- 모달 내용 -->
						<table>

							<thead>
								<tr>
									<td id="modal_code" style="display: none"></td>
									<td id="modal_img"></td>
									<td id="modal_company" style="width: 300px;">회사이름</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td></td>
									<td id="modal_price">가격</td>
									<td class="quantity">
										<div class="pro-qty">
											<input id="totalCnt" type="text" value="1">
										</div>
									</td>
								</tr>
							</tbody>
							<tr>
								<td></td>
								<td id="priceSum">
								<td>
							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-primary putCart">장바구니담기</button>
						</div>
					</div>
				</div>
			</div>
</section>
<script>
	const proCode = "${proCode}";
	const userId = "${login.userId}";
	console.log(userId);
</script>
<script src="product-js/product.js"></script>