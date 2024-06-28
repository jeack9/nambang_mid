<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인 정보 수정</h2>
	<div>
		<form action="woonControl2.do" method="get">
			<div>
				<div>
					<label>아이디</label>
				</div>
				<div>
					<input readonly/>
				</div>
			</div>

			<div>
				<div>
					<label>현재 비밀번호</label>
				</div>
				<div>
					<input placeholder="비밀번호를 입력해 주세요"></input>
				</div>
			</div>

			<div>
				<div>
					<label>새 비밀번호</label>
				</div>
				<div>
					<input placeholder="새 비밀번호를 입력해 주세요"></input>
				</div>
			</div>

			<div>
				<div>
					<label>새 비밀번호 확인</label>
				</div>
				<div>
					<input placeholder="새 비밀번호를 다시 입력해 주세요"></input>
				</div>
			</div>

			<div>
				<div>
					<label>이름</label>
				</div>
				<div>
					<input placeholder="이름을 입력해 주세요"></input>
				</div>
			</div>

			<div>
				<div>
					<label>이메일</label>
				</div>
				<div>
					<input placeholder="이메일을 입력해 주세요"></input>
				</div>
			</div>

			<div>
				<div>
					<label>휴대폰</label>
				</div>
				<div>
					<input></input>
				</div>
			</div>

			<div>
				<div>
					<label>성별</label>
				</div>
				<div>
					<input type="radio" value = "MALE"><span>남자</span>
					<input type="radio" value = "FEMALE"><span>여자</span>
					<input type="radio" value = "NONE"><span>선택안함</span>
				</div>
			</div>

			<div>
				<div>
					<label>생년월일</label>
				</div>
				<div>
					<input placeholder="YYYY" type = "text" value></input>
				</div>
				<div>
					<input placeholder="MM" type = "text" value></input>
				</div>
				<div>
					<input placeholder="DD" type = "text" value></input>
				</div>
			</div>
			<div>
				<button type ="submit"><span>정보수정</span></button>
			</div>
		</form>
	</div>
</body>
</html>