<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#mypage_change{
		width: 500px;
		margin:0 auto;
	}
	#changeBtn{
	background-color: rgb(95, 0, 128);
	color: white;
	}
 	#uRepw{
	width: 250px;
	}
	#nUserPw{
	width: 250px;
	}
</style>
<div id = "mypage_change">
	<p>개인 정보 수정</p>
	<div id = "changeInfo">
		<form action="woonControl3.do" method="get">
			<div>
				<div>
					<label>아이디</label>
					<input id = "uid" readonly/>
				</div>
			</div>
			<div>
				<div>
					<label>현재 비밀번호</label>
					<input placeholder="비밀번호를 입력해 주세요" type = "password" name = "userPw1" id = "uPw"></input>
				</div>
			</div>
			<div>
				<div>
					<label>새 비밀번호</label>
					<input placeholder="새 비밀번호를 입력해 주세요" type = "password" name = "userPw" id = "uRepw"></input>
				</div>
			</div>
			<div>
				<div>
					<label>새 비밀번호 확인</label>
					<input placeholder="새 비밀번호를 다시 입력해 주세요" type = "password" name = "newUserPw" id = "nUserPw"></input>
				</div>
			</div>
			<div>
				<div>
					<label>이름</label>
					<input placeholder="이름을 입력해 주세요" name = "userName" id="uname"></input>
				</div>
			</div>
			<div>
				<div>
					<label>이메일</label>
					<input placeholder="이메일을 입력해 주세요" name = "email" id="uemail"></input>
				</div>
			</div>
			<div>
				<div>
					<label>휴대폰</label>
					<input name = "phone" id="uphone"></input>
				</div>
			</div>
			<div>
				<div>
					<label>성별</label>
					<input type="radio" name ="gender" value = "0" id = "male"><span>남자</span>
					<input type="radio" name ="gender" value = "1" id = "female"><span>여자</span>
					<input type="radio" name ="gender" value = "2" checked id = "none"><span>선택안함</span>
				</div>
			</div>
			<div>
				<div>
					<label>생년월일</label>
					<input placeholder="YYYY" name = "birthYear" type = "text" >
					<input placeholder="MM" name = "birthMonth" type = "text" >
					<input placeholder="DD" name = "birthDay" type = "text" >
				</div>
			</div>
			<div>
				<button type ="submit" id = "changeBtn"><span>정보수정</span></button>
			</div>
		</form>
	</div>
</div>
<script src ="kdwjs/modify.js"></script>
