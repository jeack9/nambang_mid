<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
#reviewList tr td {
	border: 1px solid;
	background-color: #ddd;
}
#reviewList a{
	color : black;
}
img{
	height: 100px;
	width: 100px;
}
</style>
<table>
	<thead id="detailList">

	</thead>
	<tbody>
		<tr>
			<td><button type="button" id="zzimBtn">찜</button>
				<button type="button" id="cartBtn">장바구니</button></td>
		</tr>
	</tbody>
</table>

<table id="reviewList">
	<tr>
		<td> <a href = "#description">상품설명</a></td>
		<td> <a href = "#information">상세정보</a></td>
		<td> <a href = "#hugi">후기</a></td>
	</tr>
</table>
<div id = "description">
</div>
<div id = "information">
</div>
<div id = "hugi">
	<table id = "hugiList">
	
	</table>
</div>

<script>
	const proCode = "${proCode}";
	const userId = "${userId}";
</script>
<script src="moJs/test.js"></script>