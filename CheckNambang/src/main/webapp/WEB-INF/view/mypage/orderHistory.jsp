<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#topTitle {
	border-bottom: 2px solid rgb(51, 51, 51);
}

#history {
	display: flex;
	flex-wrap: wrap;
	align-content: flex-end;
}

#numCss {
	text-align: left;
}
</style>
<!-- begin cart -->

<section class="shoping-cart spad">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__table">
					<div id="topTitle">
						<h3>주문 내역 상세</h3>
					</div>
					<table>
						<thead>
							<tr id="numCss">
								<th>주문 번호</th>
								<th id="num"></th>
							</tr>
							<tr>
								<th class="shoping__product">상품 이미지</th>
								<th>이름</th>
								<th>가격</th>
								<th>갯수</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="cartList">
							<tr style="display: none;">
								<td class="shoping__cart__item"><img
									src="img/cart/cart-1.jpg" alt=""></td>
								<td class="shoping__cart__item_name">
									<h5>Vegetable’s Package</h5>
								</td>
								<td class="shoping__cart__price">$55.00</td>
								<td class="shoping__cart__quantity"></td>
								<td>
									<button type="button" class="btn btn-success"
										data-toggle="modal" data-target="#hugi_form">
										후기<br>작성</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="hugi_form" tabindex="-1"
		role="dialog" aria-labelledby="hugi_title"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="hugi_title">후기 작성</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<!-- 내용 작성 1.구매 한 상품 보여 주기 2.내용 및 사진 첨부 -->
				<form action ="woonControl16.do">
					<div>
						<textarea id = "hugiContent" rows="15" cols="60" placeholder="
							상품 특성에 맞는 후기를 작성 해 주세요. 예) 레시피, 겉포장 속 실제 구성품 사진, 화장품 사용자의 피부 타입 등 	(최소 10자 이상)">
					  </textarea>
					</div>
					<div>
						<input type = "hidden" id ="productCode">
						<input type = "hidden" id ="opNo">
						<input type = "file" id = "hugi_pickture" name = "hugiImage">
					</div>
				</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">작성 취소</button>
					<button type="button" class="btn btn-primary" id = "hugiBtn">작성 완료</button>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="kdwjs/orderHistory.js"></script>