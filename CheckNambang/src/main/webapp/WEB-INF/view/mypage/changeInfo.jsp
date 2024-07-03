<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
	#mypage_change{
		width: 500px;
		margin:0 auto;
	}
 	#uRepw{
	width: 250px;
	}
	#nUserPw{
	width: 250px;
	}
	#radioBox{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
	}
	

</style>
<!-- 새로 적용 -->

	<form action="woonControl3.do" method="get">
	  <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Department</h4>
                            <ul>
                                <li><a href="#">Fresh Meat</a></li>
                                <li><a href="#">Vegetables</a></li>
                                <li><a href="#">Fruit & Nut Gifts</a></li>
                                <li><a href="#">Fresh Berries</a></li>
                                <li><a href="#">Ocean Foods</a></li>
                                <li><a href="#">Butter & Eggs</a></li>
                                <li><a href="#">Fastfood</a></li>
                                <li><a href="#">Fresh Onion</a></li>
                                <li><a href="#">Papayaya & Crisps</a></li>
                                <li><a href="#">Oatmeal</a></li>
                            </ul>
                        </div>
                        <div class="sidebar__item">
                            <h4>Popular Size</h4>
                            <div class="sidebar__item__size">
                                <label for="large">
                                    Large
                                    <input type="radio" id="large">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="medium">
                                    Medium
                                    <input type="radio" id="medium">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="small">
                                    Small
                                    <input type="radio" id="small">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="tiny">
                                    Tiny
                                    <input type="radio" id="tiny">
                                </label>
                            </div>
                        </div>
                        <div class="sidebar__item">
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="col-lg-8 col-md-6">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <label>아이디</label>
									<input id = "uid" value="${login.userId }" readonly/>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <label>현재 비밀번호</label>
							<input placeholder="비밀번호를 입력해 주세요" type = "password" name = "userPw1" id = "userPw1"></input>
							<span id = "userPw1span"></span>
                        </div>
                        <div class="checkout__input">
                            <label>새 비밀번호</label>
							<input placeholder="새 비밀번호를 입력해 주세요" type = "password" name = "userPw" id = "userPw"></input>
                        </div>
                        <div class="checkout__input">
                            <label>새 비밀번호 확인</label>
							<input placeholder="새 비밀번호를 다시 입력해 주세요" type = "password" name = "newUserPw" id = "newUserPw"></input>
							<p id = "checka"></p>
                        </div>
                        <div class="checkout__input">
                            <label>이름</label>
							<input placeholder="이름을 입력해 주세요" name = "userName" id="userName" value = "${login.userName }"></input>
                        </div>
                        <div class="checkout__input">
                            <label>이메일</label>
							<input placeholder="이메일을 입력해 주세요" name = "email" id="uemail" value = "${login.email }"></input>
                        </div>
                        <div class="checkout__input">
                        	<label>휴대폰</label>
							<input placeholder="숫자만 입력 해 주세요" name = "phone" id="uphone" value = "${login.phone }"></input>
                        </div>
                       	<div class="checkout__input">
                            <label>성별</label>
                         </div>
                         <div id = "radioBox">
							<input type="radio" name ="gender" value = "0" id = "male"><span>남자</span>
							<input type="radio" name ="gender" value = "1" id = "female"><span>여자</span>
							<input type="radio" name ="gender" value = "2" checked id = "none"><span>선택안함</span>
                         </div>
                        <div class="checkout__input">
							
						</div>
                        <div class="checkout__input">
                            <label>생년월일</label>
							<input placeholder="YYYYMMDD" name = "birthYear" type = "text" >
                        </div>
                        <div>
							<button type ="submit" id = "changeBtn" class ="btn btn-danger"><span>정보수정</span></button>
						</div>
                    </div>
               </div>     
            </div>
        </div>
    </section>
</form>
    
    
    
<script>
	const userId = "${login.userId}";
	const login = {
			userId : '${login.userId}',
			userPw: '${login.userPw}',
			userName: '${login.userName}',
			phone: '${login.phone}',
			gender: ${login.gender},
			birth: <fmt:formatDate value="${login.birth}" pattern="yyyy-MM-dd"/>,
		    email: '${login.email}',
			point: ${login.point}
	};
	console.log(login);

newUserPw.addEventListener('keyup', (event) =>{	
		let userPw = document.querySelector('#userPw').value;	// 
		pwd2 = event.currentTarget.value;
		//let checka = document.createElement('p');
		if(userPw != pwd2){
			checka.style.color = 'red';
			checka.innerHTML = "비밀 번호가 일치 하지 않습니다"
		}else if(userPw == pwd2){
			checka.innerHTML = " ";
		}
	})


function checkPw() {
	
userPw1.addEventListener('keyup', (event) =>{
	let userPw1span = document.querySelector('#userPw1span');	
	console.log(login.userPw)	;
	if(login.userPw != userPw1.value)	{
		userPw1span.style.color = 'red';
		userPw1span.innerHTML = "현재 비밀번호를 확인 해 주세요"
		if(userPw1.value.length <= 0) {
			userPw1span.innerHTML = ""
		}
	}else if (login.userPw == userPw1.value){
		userPw1span.innerHTML = "";
		console.log(userPw1span.value);
		}
	})	
}	
checkPw()

</script>
<!-- <script src ="kdwjs/modify.js"></script>  아작스 처리-->