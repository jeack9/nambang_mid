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
						<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Login</h3>
						<form action="loginMember.do" method="post" name="loginfrm">
							<div class="row">
								<div class="col-md-9 mb-2">
									<div data-mdb-input-init class="form-outline">
										<input type="text" id="userId" name="userId" required="required"
											class="form-control form-control-lg" /> <label
											class="form-label" for="userId">아이디</label>
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
							<div class="mt-4 pt-2">
								<input data-mdb-ripple-init class="btn btn-primary btn-lg" id="loginBtn"
									type="button" value="로그인" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
let msg = '${requestScope.msg}'; // 비로그인 고객센터 클릭시 넘어오는 메시지
if(msg){
	alert(msg);
}

document.querySelector("#loginBtn").addEventListener("click", login);
function login(){
	let id = document.querySelector("#userId").value;
	let pw = document.querySelector("#userPw").value;
	fetch(`loginMember.do?userId=\${id}&userPw=\${pw}`)
	  .then(result => result.json())
	  .then(result => {
		if(result.retCode == "OK") location.href = "main.do";
		else alert("아이디와 비밀번호를 확인해주세요.");
	  })
	  .catch(err => console.log(err));
}
</script>