<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
div.order-box{
	display: flex;
}
.f-item1{
	flex-grow : 1;
}
.f-item2{
	padding-left : 10px;
	flex-grow : 5;
}
.f-item3{
	flex-grow : 3;
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
				<form method="get" action="">
					<div>
						<input type="radio" id="order">
						<label for="order"> 2024.06.26 <span style="color: #6f6f6f;">주문번호: dfdfdf</span></label>
						<span>
						<svg width="30" height="30" viewBox="0 5 30 30"
									xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink">
									<defs>
									<path id="7a02qqg3ja" d="M11 12h9v9"></path></defs>
									<g fill="none" fill-rule="evenodd">
									<path d="M0 0h30v30H0z"></path>
									<use stroke="#333" stroke-width="2" stroke-linecap="square"
										transform="rotate(135 15.5 16.5)" href="#7a02qqg3ja"></use></g></svg>
						</span>
						<div class="order-box">
							<img alt="" src="img/basic.jpg" width="50" class="f-item1">
							<p class="f-item2">브랜드]상품이름</p>
							<ul class="f-item3">
							<li>개수</li>
							<li>가격</li>
							</ul>
						</div>
					</div>
				</form>
				</div>
				<div class="modal-footer">					
					<button type="button" class="btn btn-primary">선택</button>
				</div>
			</div>
		</div>
</div> <!-- 모달창 END  -->	
<div class="col-lg-9 col-md-7">
	<form action="" method="post" enctype="multipart/form-data">
	<table class="table">
	<tbody>
	  <tr>
	  	<td class="col-md-2 align-middle">유형</td>
	  	<td class="col-md-5">
	  		<select class="search_condition w-100" onchange="selectType(event)" name="type1">
					<option>유형 선택</option>
					<option value="회원/이벤트/쿠폰">회원/이벤트/쿠폰</option>
					<option value="취소/교환/반품">취소/교환/반품</option>
					<option value="서비스/오류/기타">서비스/오류/기타</option>
			</select>
	  	</td>
	  	<td class="col-md-5 align-middle" id="test">
				<select class="w-100" id="type2" name="type2" required>
					<option value="-1">상세유형 선택</option>
				</select>
			</td>
	  </tr>
		<tr style="display: none;" id="op_pick">
			<td>상품</td>
			<td colspan="2" class="align-middl">
				<button type="button" class="btn btn-info w-100" data-bs-toggle="modal" data-bs-target="#staticBackdrop">주문상품 선택</button>
				<input type="text" name="orderNo">주문상품번호
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"><input type="text" class="w-100" placeholder="제목을 입력하세요." name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="2">
				<textarea class="form-control" rows="6"></textarea>
				<input type="file" name="img">
			</td>
		</tr>
	</tbody>
	</table>
	<div>
	<button type="submit" class="btn btn-primary">등록</button>
	<button type="button" class="btn btn-primary">취소</button>
	</div>
	</form>
		
</div> <!-- col-lg-9 col-md-7 END -->
<script>
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

	var myModalEl = document.getElementById('staticBackdrop'); 
	myModalEl.addEventListener('show.bs.modal', function (event) { // 모달창 열렸을때 호출
		
	});
</script>