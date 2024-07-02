/**
 * saveAddress.js
 */

fetch('woonControl14.do?userId='+userId)
	.then(result => result.json())
	.then(result =>{
		
		
		console.log(result);
		result.forEach(addrList =>{
			cloneRow(addrList);
		})		
	})


 
 function cloneRow(addr={}){
	console.log(addr);
	let copy = document.querySelector('tbody>tr').cloneNode(true);
	copy.querySelector('#address1>p').innerHTML = addr.addr1;
	copy.querySelector('#address2>p').innerHTML = addr.addr2;
	copy.style.display = "";
	document.querySelector('#addBody').appendChild(copy);
 }
 