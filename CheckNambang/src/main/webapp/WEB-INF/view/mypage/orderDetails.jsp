<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#mypage_container {
	/* display: flex;
	justify-content: flex-end;
	align-items: center;
	flex-wrap: wrap; */
	
}

#mypage_container div {
	flex: 0 1 60%;
}
</style>
<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-5">
				<div class="sidebar">
					<div class="sidebar__item">
						<h4>마이페이지</h4>
						<ul>
							<li><a href="myPageForm.do">회원정보변경</a></li>
							<li><a href="myOrderList.do">주문내역</a></li>
							<li><a href="myAddress.do">배송지 관리</a></li>
							<li><a href="myZzim.do">나의 찜</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-9 col-md-7">
				<div id="mypage_container">
					<div></div>
					<div id="orderlists">
						<table class="table">
							<thead>
								<tr>
									<td id="paymentTime">결제 시간</td>
									<td><a
										href="http://localhost/CheckNambang/woonControl9.do">주문 상세</a></td>
								</tr>
								<tr>
									<td>상품명</td>
									<td>주문 번호</td>
									<td>결제 금액</td>
									<td>주문 상태</td>
								</tr>
							</thead>
							<tbody id="target">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<script src="kdwjs/orderList.js"></script>