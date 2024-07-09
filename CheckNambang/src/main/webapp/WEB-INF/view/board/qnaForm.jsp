<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
div.order-box{
	display: flex;
}
.f-item1{
	flex-basis : 20%;
}
.f-item2{
	padding-left : 10px;
	flex-basis : 50%;
}
.f-item3{
	flex-basis : 30%;
	list-style : none;
}

</style>
 <!-- 주문상품 선택 모달창 -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">주문상품 선택</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
				<c:forEach var="item" items="${map }">
				<div>
					<input type="radio" id="order${item.key }" value="${item.key }" name="orderNo">
					<span style="color: #6f6f6f;">주문번호:${item.key }</span>
					<label for="order${item.key }">주문일자: <fmt:formatDate value="${item.value[0].orderDate }" pattern="yyyy.MM.dd"/>
					</label>
					<button type="button" onclick="view(event)" class="btn btn-info" data-key="view${item.key }">자세히보기</button>
				</div>
				<c:forEach var="list" items="${item.value }">
				<div style="display:none;" class="view${item.key }">
					<div class="order-box">
						<c:if test="${!empty list.productImage}">
						<img alt="" src="img/${list.productImage}" width="50" class="f-item1">
						</c:if>
						<p class="f-item2">${list.productName}</p>
						<ul class="f-item3">
						<li>${list.opVolume1} 개</li>
						<li><fmt:formatNumber value="${list.opPrice1}" pattern="#,###" /> 원</li>
						</ul>
					</div>
				</div> <!-- 주문히스토리 영역 -->
				</c:forEach>
				</c:forEach>
				</div>
				<div class="modal-footer">					
					<button type="button" class="btn btn-primary" onclick="pickOrder()">선택</button>
				</div>
			</div>
		</div>
</div> <!-- 모달창 END  -->
<div class="col-lg-9 col-md-7">
	<form action="registerQna.do" method="post" enctype="multipart/form-data" onsubmit="return valid()">
	<table class="table">
	<tbody>
	  <tr>
	  	<td class="col-md-2 align-middle">유형</td>
	  	<td class="col-md-5">
	  		<select class="type w-100" onchange="selectType(event)" name="type1">
					<option value="-1">유형 선택</option>
					<option value="회원/이벤트/쿠폰">회원/이벤트/쿠폰</option>
					<option value="취소/교환/반품">취소/교환/반품</option>
					<option value="서비스/오류/기타">서비스/오류/기타</option>
			</select>
	  	</td>
	  	<td class="col-md-5 align-middle">
				<select class="type w-100" id="type2" name="type2" required>
					<option value="-1">상세유형 선택</option>
				</select>
			</td>
	  </tr>
		<tr style="display: none;" id="op_pick">
			<td>상품</td>
			<td colspan="2" class="align-middl">
				<button type="button" class="btn btn-info w-100" data-bs-toggle="modal" data-bs-target="#staticBackdrop">주문상품 선택</button>
				<input type="text" name="orderNo" id="pick_order" hidden>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"><input type="text" class="w-100" placeholder="제목을 입력하세요." name="title" required></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="2">
				<textarea class="form-control" rows="6" name="content" required></textarea>
				<input type="file" name="image">
			</td>
		</tr>
	</tbody>
	</table>
	<div>
	<button type="submit" class="btn btn-primary">등록</button>
	<button type="reset" class="btn btn-primary">취소</button>
	</div>
	</form>
		
</div> <!-- col-lg-9 col-md-7 END -->
<script>
function view(e){ // 주문 상품선택 자세히보기 버튼
	let details = document.querySelectorAll(`div.\${e.target.dataset.key}`);
	details.forEach(div =>{
		if(div.style.display == "none") div.style.display = "";
		else div.style.display = "none";
	});
}
function pickOrder(){ // 주문상품 선택 클릭이벤트
	let checkOrder = document.querySelector("div.modal-body input[type=radio]:checked");
	document.querySelector('#pick_order').value = checkOrder.value;
	$('#staticBackdrop').modal("hide");
}

function selectType(e){ // 유형 선택 -> 상세유형 목록 띄우기
	let url = "type2Ajax.do?type1=" + e.target.value;
	fetch(url) // 상세유형 데이터 가져오기
	.then(result => result.json())
	.then(result =>{
			// 기본 유형 '취소교환반품' 선택시 주문 상품 선택창
			(e.target.value == "취소/교환/반품") ? $("#op_pick").css("display", "") : $("#op_pick").css("display", "none");
			// 상세유형 option 생성후 추가
			document.querySelector("#type2").innerHTML = "";
			let option = document.createElement("option");
			option.value = "-1";
			option.innerText = "상세유형 선택";
			document.querySelector("#type2").appendChild(option);
			result.forEach(type2 => {
				let option = document.createElement("option");
				document.querySelector("#type2").appendChild(option);
				option.innerText = type2;
				option.value = type2;
			});
			$("select").niceSelect("update"); // bootstrap
		});
}
function valid(){
	let isValid = false;
	document.querySelectorAll("select.type").forEach(type =>{
		isValid = type.value != "-1" ? true : false;
	});
	if(!isValid) alert("유형을 선택해주세요.");
	return isValid;
}

</script>