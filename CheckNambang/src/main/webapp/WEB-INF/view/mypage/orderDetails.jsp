<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
							<thead style="display: none;">
								<tr>
									<td id="paymentTime">결제 시간 >  2024년 07월 08일</td>
									<td ><a href="woonControl9.do?orderNo=" class="detaileView">주문 상세</a></td>
								</tr>
								<tr>
									<td id = "orderNo">주문 번호>  1</td>
								</tr>
								<tr>
									<td  id = "orderPrice">결제 금액>  7800원</td>
								</tr>
								<tr>
									<td id = "orderStatus">주문 상태>  주문 완료</td>
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
<script>
	const userId = "${login.userId}";
</script>
<script src="kdwjs/orderList.js"></script>