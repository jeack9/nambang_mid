<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
.gradient-custom {
/* fallback for old browsers */
background: #f093fb;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to bottom right, rgb(81 237 123), rgb(255 255 255));
}

.card-registration .select-input.form-control[readonly]:not([disabled]) {
font-size: 1rem;
line-height: 2.15;
padding-left: .75em;
padding-right: .75em;
}
.card-registration .select-arrow {
top: 13px;
}
</style>
<section class="gradient-custom">
	<div class="container py-5 h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-12 col-lg-9 col-xl-7">
				<div class="card shadow-2-strong card-registration"
					style="border-radius: 15px;">
					<div class="card-body p-4 p-md-5">
						<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
						<form action="joinMember.do" method="get" name="joinfrm" onsubmit="return valid()">
							<div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="text" id="userId" name="userId" required="required"
											class="form-control form-control-lg" /> <label
											class="form-label" for="userId">아이디</label>
									</div>
								</div>
								<div class="col-md-3 mb-2">

									<div data-mdb-input-init class="form-outline">
										<input data-mdb-ripple-init class="btn btn-primary btn-lg" id="checkedIdBtn"
											type="button" value="중복확인" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="password" id="userPw" name="userPw" required="required"
											class="form-control form-control-lg" /> <label
											class="form-label" for="userPw">비밀번호</label>
									</div>
								</div>
							</div>
							<!-- <div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="text" id="userPwCheck"
											class="form-control form-control-lg" /> <label
											class="form-label" for="userPwCheck">비밀번호확인</label>
									</div>
								</div>
							</div> -->
							<div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="text" id="userName" name="userName" required="required"
											class="form-control form-control-lg" /> <label
											class="form-label" for="userName">이름</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="email" id="email" name="email" required="required"
											placeholder="qwe123@gmail.com"
											class="form-control form-control-lg" /> <label
											class="form-label" for="email">이메일</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-4 d-flex align-items-center">
									<div data-mdb-input-init class="form-outline">
										<input type="tel" id="phone" name="phone" maxlength="11"
										placeholder="-없이 입력하세요." required
											class="form-control form-control-lg" /> <label
											class="form-label" for="phone">휴대폰</label>
									</div>	
								</div>
								<div class="col-md-6 mb-4">

									<h6 class="mb-2 pb-1">성별</h6>

									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="gender" id="femaleGender" value="2"
											checked /> <label class="form-check-label"
											for="femaleGender">여자</label>
									</div>

									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="gender" id="maleGender" value="1" />
										<label class="form-check-label" for="maleGender">남자</label>
									</div>

									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" checked
											name="gender" id="otherGender" value="0" />
										<label class="form-check-label" for="otherGender">없음</label>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-4 pb-2">

									<div data-mdb-input-init class="form-outline">
										<input type="text" id="addr1" name="addr1" 
											placeholder="판교역로 166" required
											class="form-control form-control-lg" /> <label
											class="form-label" for="addr1">주소</label>
									</div>

								</div>
								<div class="col-md-6 mb-4 pb-2">

									<div data-mdb-input-init class="form-outline">
										<input type="text" id="addr2" name="addr2" 
											placeholder="304동 105호" required
											class="form-control form-control-lg" /> <label
											class="form-label" for="addr2">상세 주소</label>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="date" id="birth" name="birth" value="2005-01-01"
											class="form-control form-control-lg" /> <label
											class="form-label" for="birth">생년월일</label>
									</div>
								</div>
							</div>

							<div class="mt-4 pt-2">
								<input data-mdb-ripple-init class="btn btn-primary btn-lg"
									type="submit" value="가입" />
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
	// 회원가입 form 유효성 검사 후 제출이벤트 발생
	let dbChecked = false;
	function valid(){
		if(!dbChecked) alert("아이디중복을 확인해주세요.");
		return dbChecked;
	}

	document.querySelector("#userId").addEventListener("keydown", () => dbChecked = false)

	// 아이디 중복체크 버튼 이벤트연결
	document.querySelector("#checkedIdBtn").addEventListener("click", checkedId);
	// 유효성 검사 부족한점 
	// - 비밀번호공백, 자리수, 문자조합 등등
	// - 아이디 공백입력, 문자조합
	function checkedId(){ // 아이디 중복체크 클릭이벤트
		let id = document.querySelector("#userId").value;
		if(!id){ // 아이디 비입력시 
			alert("아이디를 입력하세요");
			return;
		}
		let url = `checkIdAjax.do?userId=\${id}`;
		checkedIdAjax(url);
	}
	async function checkedIdAjax(url) { // 아이디 중복체크 ajax호출
		const response = await fetch(url);
		const jsonData = await response.json();
		if(jsonData.retCode == "OK"){
			alert("사용 가능한 아이디입니다.");
			dbChecked = true;
		}
		else{
			alert("중복된 아이디가 있습니다.")
			dbChecked = false;
		}
	}
</script>