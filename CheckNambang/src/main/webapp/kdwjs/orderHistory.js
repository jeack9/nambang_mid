/**
 * orderHistory.js
 */


let param = new URLSearchParams(window.location.search);
let orderNo = param.get('orderNo');
 fetch('woonControl10.do?orderNo='+ orderNo)
 	.then(result => result.json())
 	.then(result =>{

		let orderNo = document.querySelector('#num');
		orderNo.innerHTML = result[0].orderNo;
		let productCode = document.querySelector('#productCode');
		let opNo = document.querySelector('#opNo');
		result.forEach(center =>{
			console.log(result);			
			cloneRow(center);	
			productCode.setAttribute('value', center.productCode);					
			opNo.setAttribute('value', center.opNo);
		})
	})
	
	
	
function cloneRow(cart ={}){
	console.log(cart);
	
	let historyclone = document.querySelector('tbody>tr:nth-of-type(1)').cloneNode(true);
	historyclone.querySelector('.shoping__cart__item>img').setAttribute('src', `img/${cart.productImage}`)
	historyclone.querySelector('.shoping__cart__item_name>h5').innerHTML = cart.productName;
	historyclone.querySelector('.shoping__cart__price').innerHTML = cart.opPrice + "원";
	historyclone.querySelector('.shoping__cart__quantity').innerHTML = cart.opVolume;
	historyclone.style.display = "";
	document.querySelector('#cartList').appendChild(historyclone);
}










