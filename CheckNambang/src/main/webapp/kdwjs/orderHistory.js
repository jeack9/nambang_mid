/**
 * orderHistory.js
 */

 fetch('woonControl10.do?orderNo=1')
 	.then(result => result.json())
 	.then(result =>{
		console.log(result);
		let orderNo = document.querySelector('#num');
		orderNo.innerHTML = result[0].orderNo;
		
		result.forEach(center =>{
			cloneRow(center);						
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