<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ogani | Template</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<style type="text/css">
.black_a {
	color: black;
}
#inputAddr {
	display: flex;
	justify-content: center;
	align-items: center;
}

#topTitle {
	display: flex;
	justify-content: center;
	align-items: center;
}

.contact__form__title {
	text-align: left;
	border-bottom: 2px solid rgb(51, 51, 51);
}

#addAddress {
	border-bottom: 2px solid rgb(51, 51, 51);
}

.contact__form__title {
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>
	<!--  시작 -->
	<div class="contact-form spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<form></form>
					<div class="contact__form__title">
						<h2>배송지 관리</h2>
						<button type="submit" class="btn btn-danger" id="basicBtn">+
							기본 배송지</button>
					</div>
				</div>
			</div>
			<div>
				<table id="addAddress">
					<thead>
            			<tr style="display :none">
           			    	<td id="address0"><input style='zoom:2.0;'  type="radio" ></td>
           					<td id="address1"><p style="font-size:20px">대구 광역시 중구 중앙대로 403</p></td>
           					<td id="address2"><p style="font-size:20px">5층</p></td>
           				</tr>
           			</thead>
					<tbody id="addBody"></tbody>
				</table>
			</div>
			<form action="woonControl12.do?userId=${sessionScope.login.userId }"
				method="post">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<input type="text" id="sample6_postcode" placeholder="우편번호">
					</div>
					<div class="col-lg-6 col-md-6">
						<input type="button" onclick="sample6_execDaumPostcode()"
							value="우편번호 찾기"><br>
					</div>
					<div class="col-lg-12 text-center">
						<input type="text" id="addr1" name="addr1" placeholder="주소"><br>
						<input type="text" id="addr2" name="addr2" placeholder="상세주소">
						<input type="text" id="sample6_extraAddress" placeholder="참고항목">
						<input type="text" id="getter" name="getter"
							placeholder="이름을 입력 해 주세요"> <input type="text"
							id="getterPhone" name="getterPhone" placeholder="전화 번호를 입력 해 주세요">
						<button type="submit" class="site-btn" name = "mode" value = "1">주소 추가</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document.getElementById("sample6_extraAddress").value = extraAddr;

							} else {
								document.getElementById("sample6_extraAddress").value = '';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample6_postcode').value = data.zonecode;
							document.getElementById("addr1").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("addr2").focus();
						}
					}).open();
		}
	</script>
	<script>
		const userId = "${login.userId}";
		console.log(userId);
	</script>
	<script src="kdwjs/saveAddress.js"></script>

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>