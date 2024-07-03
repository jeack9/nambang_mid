/**
 * kdwjs/modify.js
 */

let userData;


fetch('woonControl2.do?userId='+userId)
	.then(result => result.json())
	.then(result =>{
	let uid = document.querySelector('#uid');
	uid.setAttribute('value', result[0].userId);
	
	let userName = document.querySelector('#userName');
	userName.setAttribute('value', result[0].userName);
	
	let uemail = document.querySelector('#uemail');
	uemail.setAttribute('value', result[0].email);
	
	let uphone = document.querySelector('#uphone');
	uphone.setAttribute('value', result[0].phone);

	})



let userRepw = document.querySelector('#userRepw');
let checka = document.querySelector('#checka');
let newUserPw = document.querySelector('#newUserPw');
let pwd2;

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

fetch('woonControl15.do?userId='+ userId)
	.then(result => result.json())
	.then(result =>{
		console.log(result);
		
	})






