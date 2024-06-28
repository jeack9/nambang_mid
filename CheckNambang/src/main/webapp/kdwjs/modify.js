/**
 * modify.js
 */

let userData;

 function modifymypageInfo(){
	fetch('woonControl.do')
		.then(result => result.json())
		.then(result =>{
			userData = result.data;
			
		})
 }
 