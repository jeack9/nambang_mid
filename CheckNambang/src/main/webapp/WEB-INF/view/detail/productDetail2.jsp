<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#endPrice {
	padding-top: 30px;
	padding-left:200px;
	padding-bottom: 30px;
}

#detailList tr th{
	padding-right: 40px;
}
#detailList tr, #detailList th, #detailList td{
	padding-top: 30px;
}
#btnClass{
	padding-left:100px;
	
}
.quantity{
	padding-left:120px;
}
#tabs-1, #tabs-2, #tabs-3{
	text-align: center;
}
</style>
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">
						<img class="product__details__pic__item--large" alt="">
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3 id="titleList"></h3>
					<div class="product__details__rating">
						<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star-half-o"></i> <span>(18 reviews)</span>
					</div>
					<div class="product__details__price"></div>
					<table id="detailList">

					</table>
					<div class="product__details__quantity">
						<div class="quantity">
							<div class="pro-qty">
								<input id = "totalCnt" type="text" value="1">
							</div>
						</div>
					</div>
					<div id="endPrice"></div>
				</div>
				<div id = "btnClass">
					<a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
					<a href="#" class="primary-btn">장바구니 추가</a>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							href="#tabs-1">상품설명</a></li>
						<li class="nav-item"><a class="nav-link" 
							href="#tabs-2">상세정보</a></li>
						<li class="nav-item"><a class="nav-link" 
							href="#tabs-3">후기 <span>(1)</span></a></li>
					</ul>
					<div class="tab-content">
						<div id="tabs-1">

						</div>
						<div id="tabs-2">

						</div>
						<div id="tabs-3">

							<h6>여기는 후기</h6>
							<table id = "hugiList">
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
	const proCode = "${proCode}";
	const userId = '${login.userId}';

</script>
<script src="moJs/test.js"></script>