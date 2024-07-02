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
</style>
<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-5">
				<div class="sidebar">
					<div class="sidebar__item">
						<h4>Department</h4>
						<ul>
							<li><a href="#">채소</a></li>
							<li><a href="#">과일·견과·쌀</a></li>
							<li><a href="#">수산·해산·건어물</a></li>
							<li><a href="#">정육·가공육·계란</a></li>
							<li><a href="#">국·반찬·메인요리</a></li>
							<li><a href="#">Butter &amp; Eggs</a></li>
							<li><a href="#">Fastfood</a></li>
							<li><a href="#">Fresh Onion</a></li>
							<li><a href="#">Papayaya &amp; Crisps</a></li>
							<li><a href="#">Oatmeal</a></li>
						</ul>
					</div>
					<div class="sidebar__item">
						<h4>Price</h4>
						<div class="price-range-wrap">
							<div
								class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
								data-min="10" data-max="540">
								<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"
									style="left: 0%;"></span> <span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"
									style="left: 100%;"></span>
								<div class="ui-slider-range ui-corner-all ui-widget-header"
									style="left: 0%; width: 100%;"></div>
							</div>
							<div class="range-slider">
								<div class="price-input">
									<input type="text" id="minamount"> <input type="text"
										id="maxamount">
								</div>
							</div>
						</div>
					</div>
					<div class="sidebar__item sidebar__item__color--option">
						<h4>Colors</h4>
						<div class="sidebar__item__color sidebar__item__color--white">
							<label for="white"> White <input type="radio" id="white">
							</label>
						</div>
						<div class="sidebar__item__color sidebar__item__color--gray">
							<label for="gray"> Gray <input type="radio" id="gray">
							</label>
						</div>
						<div class="sidebar__item__color sidebar__item__color--red">
							<label for="red"> Red <input type="radio" id="red">
							</label>
						</div>
						<div class="sidebar__item__color sidebar__item__color--black">
							<label for="black"> Black <input type="radio" id="black">
							</label>
						</div>
						<div class="sidebar__item__color sidebar__item__color--blue">
							<label for="blue"> Blue <input type="radio" id="blue">
							</label>
						</div>
						<div class="sidebar__item__color sidebar__item__color--green">
							<label for="green"> Green <input type="radio" id="green">
							</label>
						</div>
					</div>
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
			<div class="col-lg-9 col-md-7">
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

				<div class="row" id="product_list">
					<div class="col-lg-4 col-md-6 col-sm-6" style="display: none;">
						<div class="product__item">
							<div class="product__item__pic set-bg product_img"
								data-setbg="img/product/product-1.jpg"
								style="background-image: url(&quot;img/product/product-1.jpg&quot;);">
							</div>
							<!-- 모달창버튼 -->
							<button type="button" class="btn-open-modal">⛟ 장바구니 담기</button>
							<div class="product__item__text product_text">
								<h5>Crab Pool Security</h5>
								<h4>$30.00</h4>
								<h6>gugiCnt</h6>
							</div>
						</div>
					</div>

					<!-- <div class="product__pagination">
					<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#"><i
						class="fa fa-long-arrow-right"></i></a>
				</div> -->
				</div>
			</div>
		</div>
		<!--  모달창(내용) -->

		<div class="modal">
			<div class="modal_body">
				<h2>모달창 제목</h2>
				<p>모달창 내용</p>
			</div>
		</div>
</section>
<script>
	const proCode = "${proCode}";
	const userId = "${userId}";
</script>
<script src="product-js/product.js"></script>