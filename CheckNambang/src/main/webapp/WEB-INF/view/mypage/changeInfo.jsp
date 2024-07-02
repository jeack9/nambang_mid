<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
									<input id = "uid" readonly/>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <label>현재 비밀번호</label>
							<input placeholder="비밀번호를 입력해 주세요" type = "password" name = "userPw1"></input>
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
							<input placeholder="이름을 입력해 주세요" name = "userName" id="userName"></input>
                        </div>
                        <div class="checkout__input">
                            <label>이메일</label>
							<input placeholder="이메일을 입력해 주세요" name = "email" id="uemail"></input>
                        </div>
                        <div class="checkout__input">
                        	<label>휴대폰</label>
							<input name = "phone" id="uphone"></input>
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
	console.log(userId);
</script>
<script src ="kdwjs/modify.js"></script>
