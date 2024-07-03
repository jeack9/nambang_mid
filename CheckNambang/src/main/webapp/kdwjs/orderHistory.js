/**
 * orderHistory.js
 */


 fetch('woonControl10.do?orderNo=1')
 	.then(result => result.json())
 	.then(result =>{
		console.log(result);
		let orderNo = document.querySelector('#num');
		orderNo.innerHTML = result[0].orderNo;
		let productCode = document.querySelector('#productCode');
		let opNo = document.querySelector('#opNo');
		result.forEach(center =>{
			console.log(result);			
			cloneRow(center);	
			productCode.setAttribute('id', center.productCode);					
			opNo.setAttribute('id', center.opNo);
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



document.querySelector('#hugiBtn').addEventListener('click', function(){
	let productCode = document.querySelector('#productCode').value;
	let opNo = document.querySelector('#opNo').value;
	let hugiContent = document.querySelector('#hugiContent').value;
	
	let url ='woonControl16.do?hugiContent='+hugiContent+'&userId='+userId+'&productCode='+productCode+'&opNo='+opNo;
	fetch(url)
	.then(result => result.json())
	.then(result =>{
		console.log(result);
	}) 
})







