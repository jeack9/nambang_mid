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

#btnClass {
	padding-left: 70px;
	display: flex;
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

#zzimBtnClass {
	padding-right: 10px;
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
					<div class="product__details__price" style = "margin-bottom: 0;"></div>
					<div class="product__details__price2" style = "text-decoration:line-through; text-decoration-thickness: 2px; display:inline-block;"></div>
					
					<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModalScrollable">Launch demo modal</button>
	
					
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
								<span>(1)</span>
						</a></li>
					</ul>
					<div class="tab-content">
						<div id="tabs-1"></div>
						<div id="tabs-2"></div>
						<div id="tabs-3">

							<h3>상품 후기</h3>
							<table id="hugiList">
							</table>

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
					<h5 class="modal-title" id="exampleModalScrollableTitle">Modal
						title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"><p>asdfasdfa</p></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
	const login = '${sessionScope.login.userId}';
	const zzimProCode = '${zzim}'
	console.log("${param.product}");
	console.log("${param.proCode}" + ":procode");
</script>
<script src="moJs/test.js"></script>