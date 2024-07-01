/**
 * kdwjs/modify.js
 */

let userData;


fetch('woonControl2.do?userId='+userId)
	.then(result => result.json())
	.then(result =>{
	console.log(result[0].userId);
	let uid = document.querySelector('#uid');
	uid.setAttribute('value', result[0].userId);
	
	let uname = document.querySelector('#uname');
	uname.setAttribute('value', result[0].userName);
	
	let uemail = document.querySelector('#uemail');
	uemail.setAttribute('value', result[0].email);
	
	let uphone = document.querySelector('#uphone');
	uphone.setAttribute('value', result[0].phone);

	})


let userPw = document.querySelector('#userPw');
let userRepw = document.querySelector('#userRepw');

function pwComp(){
	if(userPw.value != userRepw.value){
		alert('동일한 비밀번호를 입력해 주세요');
	}
}




