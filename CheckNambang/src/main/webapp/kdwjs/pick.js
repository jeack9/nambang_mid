/**
 * kdwjs/pick.js
 */

let salePrice = document.querySelector('#salePrice');
let regularPrice = document.querySelector('#regularPrice');
let itemImage = document.querySelector('#itemImage');
let itemName = document.querySelector('#itemName');
let pickitems = document.querySelector('#items');

fetch('woonControl7.do?userId=' + userId)
	.then(result => result.json())
	.then(result => {
		result.forEach(center => {
			cloneRow(center);
		})





		var proQty = $('.pro-qty');
		proQty.on('click', '.qtybtn', function() {
			//console.log(document.querySelector(".pro-qty > input"));
			var $button = $(this);
			var oldValue = $button.parent().find('input').val();
			if ($button.hasClass('inc')) {
				var newVal = parseFloat(oldValue) + 1;
			} else {
				// Don't allow decrementing below zero
				if (oldValue > 1) {
					var newVal = parseFloat(oldValue) - 1;
				} else {
					newVal = 0;
				}
			}
			$button.parent().find('input').val(newVal);
		});
		//document.querySelector('.dec qtybtn').addEventListener('click', minuschangeBtn);	// - 부분
		//document.querySelector('.inc qtybtn').addEventListener('click', pluschangeBtn);	// + 부분	
		
		console.log(result);
		
		let cntPrice = document.querySelector('.shoping__cart__total');
		
		document.querySelectorAll('.dec').forEach(ele =>{
			ele.addEventListener('click', function(e){			
					
				minus = parseInt(e.target.nextElementSibling.value) -1;
					
				let row = e.target.closest('tr');
				let price = parseInt(row.querySelector('.shoping__cart__price').innerText.replace('원', ''));
				let total = minus * price;
				row.querySelector('.shoping__cart__total').innerHTML = total + "원";
			});
		});
		
		document.querySelectorAll('.inc').forEach(ele =>{
			ele.addEventListener('click', function(e){
				
				let plus = parseInt(e.target.previousElementSibling.value) + 1;
				let row = e.target.closest('tr');
				let price = parseInt(row.querySelector('.shoping__cart__price').innerText.replace('원', ''));
				let total = plus * price;
				row.querySelector('.shoping__cart__total').innerHTML = total + "원";
			});
		})
		
		


 document.querySelectorAll('#containBtn').forEach(btn => {
     btn.addEventListener('click', function (e) {
         const row = e.target.closest('tr');
         //const proCode = row.querySelector().value;
         const totalCnt = row.querySelector('#totalCnt').value;
         console.log(totalCnt);
         const proCode = row.querySelector('#containBtn').value;
         console.log(proCode);
        fetch('hyunControl3.do?proCode=' + proCode //
        + '&cartVolume=' + totalCnt)
		.then(result => result.json())
		.then(result =>{
				if (result.retCode == 'OK') {
				alert('장바구니담기 완료');
			} else {
				alert('장바구니담기 실패');
			}
		})
         
         
     });
 });
		
		
	})

function cloneRow(pickItem = {}) {
	console.log(pickItem);
	let clone = document.querySelector('tbody>tr:nth-of-type(1)').cloneNode(true);
	clone.querySelector('.shoping__cart__item>img').setAttribute('src', `image/${pickItem.productImage}`);
	clone.querySelector('.shoping__cart__name').innerHTML = pickItem.productName;
	clone.querySelector('.shoping__cart__price').innerHTML = pickItem.price + "원";

	clone.querySelector('.pro-qty>input').setAttribute('id', 'totalCnt');

	//let plusMinus = document.querySelector('.quantity');
	//plusMinus.addEventListener('click', changeBtn);
	clone.querySelector('.shoping__cart__total').innerHTML = pickItem.price + "원";
	clone.querySelector('#deleteBtn').setAttribute('name', 'productCode');
	clone.querySelector('#deleteBtn').setAttribute('value', pickItem.productCode);
	clone.querySelector('#containBtn').setAttribute('name', 'proCode');
	clone.querySelector('#containBtn').setAttribute('value', pickItem.productCode);
	
	clone.style.display = "";
	document.querySelector("#itemsList").appendChild(clone);

}

// 장바구니 전달 event	

/*		let btn = document.querySelector('#containBtn');
	btn.addEventListener('click', function(e) {
	console.log("111adf");
	let totalCnt = document.querySelector('#totalCnt').value;
	
	
	fetch('hyunControl3.dohyunControl3.do?proCode=' + proCode //
		+ '&userId=' + userId + '&cartVolume=' + totalCnt)
		.then(result => result.json())
		.then(result =>{
				if (result.retCode == 'OK') {
				alert('장바구니담기 완료');
			} else {
				alert('장바구니담기 실패');
			}
		})
	
})*/



