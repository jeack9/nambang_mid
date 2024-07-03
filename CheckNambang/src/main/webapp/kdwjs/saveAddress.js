/**
 * saveAddress.js
 */

fetch('woonControl14.do?userId='+userId)
	.then(result => result.json())
	.then(result =>{
		console.log(result);
		result.forEach(addrList =>{
			console.log(addrList);
			cloneRow(addrList);
		})		
	})



 function cloneRow(addr={}){
	console.log(addr);
	let copy = document.querySelector('tbody>tr').cloneNode(true);
	copy.querySelector('#address0>input').setAttribute('value',addr.addrNo )
	copy.querySelector('#address1>p').innerHTML = addr.addr1;
	copy.querySelector('#address2>p').innerHTML = addr.addr2;
	copy.style.display = "";
	document.querySelector('#addBody').appendChild(copy);
 }
 
 
 // input 태그에 addEvent 를 줘서 클릭이 되면 클릭된 input value 값을 db 에 전달 하여 1으로 만들고  나머지 0
 
 let addNumber = document.querySelector('#address0>input');
 
 if(addNumber.checked == true){
	
	/*update address_ck
set addr_selected = 1
where addr_no = 1*/
	
 } 