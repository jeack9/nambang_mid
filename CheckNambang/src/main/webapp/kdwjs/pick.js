/**
 * kdwjs/pick.js
 */

let salePrice = document.querySelector('#salePrice');
let regularPrice = document.querySelector('#regularPrice');
let itemImage = document.querySelector('#itemImage');
let itemName = document.querySelector('#itemName');
let pickitems = document.querySelector('#items'); 	


 fetch('woonControl7.do?userId=happy')
 	.then(result => result.json())
 	.then(result => {
		console.log(result);
		result.forEach(center =>{
			cloneRow(center);
		})
	})
	
function cloneRow(pickItem = {}){
	console.log(pickItem);
	let clone = document.querySelector('tbody>tr:nth-of-type(1)').cloneNode(true);
	clone.querySelector('.shoping__cart__item>img').setAttribute('src', `img/${pickItem.productImage}`);
	clone.querySelector('.shoping__cart__item>h5').innerHTML = pickItem.productName;
	clone.querySelector('.shoping__cart__price').innerHTML = pickItem.price + "원";
	//clone.querySelector('.pro-qty>input').setAttribute('value', '')
	clone.querySelector('.shoping__cart__offprice').innerHTML = pickItem.offPrice + "원";
	clone.querySelector('#deleteBtn').setAttribute('name', 'zzimNo');
	clone.querySelector('#deleteBtn').setAttribute('value', pickItem.zzimNo);	
	clone.style.display = "";
	document.querySelector("#itemsList").appendChild(clone);
	
}	


	
let btn = document.querySelector('#containBtn');
btn.addEventListener('click', function(e){
		document.forms.removeForm.action = "woonControl.do"; //일단 장바구니 table 모르기에 
		document.forms.removeForm.submit();
})	


