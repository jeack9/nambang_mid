<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#mypage_container{
		display: flex;
	}
	#mypage_container div{
		flex : 0 1 60%;
	}
	#orderlists{

	}
</style>
<div id="mypage_container">
	<div>
		
	</div>
	<div id = "orderlists">
		<table class = "table">
			<thead>
				<tr>
					<td id ="paymentTime">결제 시간</td>
					<td><a href="woonControl9.do">주문 상세</a></td>
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

<script src="kdwjs/orderList.js"></script>