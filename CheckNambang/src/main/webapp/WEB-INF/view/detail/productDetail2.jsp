<%@page import="co.nambang.product.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#endPrice {
	padding-top: 30px;
	padding-left: 200px;
	padding-bottom: 30px;
}

#detailList tr th {
	padding-right: 40px;
}

#detailList tr, #detailList th, #detailList td {
	padding-top: 30px;
}

.quantity {
	padding-left: 120px;
}

#tabs-1, #tabs-2 {
	text-align: center;
}

#hugiList td {
	display: block;
}

#hugiList th {
	vertical-align: top;
	padding-right: 80px;
	padding-bottom: 120px;
}

#hugiList>tr>td:nth-child(2) {
	color: #bebebe;
}

#btnClass {
	text-align: center;
}

#offPriceList {
	text-decoration: line-through;
	text-decoration-thickness: 2px;
	display: inline-block;
}

#offList {
	display: inline;;
}

#priceInfo {
	text-decoration: line-through;
	text-decoration-thickness: 2px;
	font-size: 20px;
	font-weight: bold;
}

#offInfo {
	font-size: 20px;
	font-weight: bold;
}

#imgBtn {
	background-color: white;
	border: none;
	width: 16px;
	height: 16px;
	cursor: pointer;
	padding: 0px;
}

#offImg {
	width: 16px;
	height: 16px;
}

a:link {
	text-decoration: none;
}
</style>
<style>
.center {
	text-align: center;
}

.hugipaging {
	display: inline-block;
}

.hugipaging a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.hugipaging a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.hugipaging a:hover:not(.active) {
	background-color: #ddd;
}

a {
	text-decoration-line: none;
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
					<div class="product__details__price" style="margin-bottom: 0;"></div>
					<div class="product__details__price2" id="offPriceList"></div>

					<div id="offList"></div>



					<table id="detailList">

					</table>
					<div class="product__details__quantity">
						<div class="quantity">
							<div class="pro-qty">
								<input id="totalCnt" type="text" value="1">
							</div>
						</div>
					</div>
					<div id="endPrice"></div>
				</div>
				<div id="btnClass">
					<a href="javascript:void(0)" class="heart-icon" id="zzimBtn"><span
						class="icon_heart_alt" id="zzimhart"
						style="text-decoration: none; color: black;"></span></a> <a href="#"
						class="primary-btn">장바구니 추가</a>
					<div id="zzimBtnClass"></div>
					<div id="cartBtnClass"></div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							href="#tabs-1">상품설명</a></li>
						<li class="nav-item"><a class="nav-link" href="#tabs-2">상세정보</a></li>
						<li class="nav-item"><a class="nav-link" href="#tabs-3">후기
								<span></span>
						</a></li>
					</ul>
					<div class="tab-content">
						<div id="tabs-1"></div>
						<div id="tabs-2"></div>
						<div id="tabs-3">
							<h3>상품 후기</h3>
							<table id="hugiList">
							</table>
							<div class="center">
								<div class="hugipaging">
									<a href="#tabs-3">1</a> <a href="#tabs-3" class="active">2</a>
									<a href="#tabs-3">3</a> <a href="#tabs-3">4</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Button trigger modal -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModalScrollable" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalScrollableTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalScrollableTitle">가격안내</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p id="priceInfo"></p>
					<p>판매 가격입니다. 이가격은 시장 현황등에 따라 변경될 수 있습니다.</p>
					<p id="offInfo"></p>
					<p>현 시점 모든 할인이 적용된 가격입니다.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
	const login = '${sessionScope.login.userId}';
	//const zzimProCode = '${zzim}'
	//console.log(zzimProCode);
</script>
<script src="moJs/test.js"></script>