/**
 * kdwjs/pick.js
 */

let salePrice = document.querySelector('#salePrice');
let regularPrice = document.querySelector('#regularPrice');
let itemImage = document.querySelector('#itemImage');
let itemName = document.querySelector('#itemName');
let pickitems = document.querySelector('#items'); 	


 fetch('woonControl7.do?userId=' +userId)
 	.then(result => result.json())
 	.then(result => {
		console.log(result);
		result.forEach(center =>{
			cloneRow(center);

			
		})
		var proQty = $('.pro-qty');
	    proQty.on('click', '.qtybtn', function () {
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

	})
	
function cloneRow(pickItem = {}){
	console.log(pickItem);

	
	let clone = document.querySelector('tbody>tr:nth-of-type(1)').cloneNode(true);
	clone.querySelector('.shoping__cart__item>img').setAttribute('src', `img/${pickItem.productImage}`);
	clone.querySelector('.shoping__cart__name').innerHTML = pickItem.productName;
	clone.querySelector('.shoping__cart__price').innerHTML = pickItem.price + "원";
	
	clone.querySelector('.pro-qty>input').setAttribute('id', pickItem.zzimNo);
	
	// 

	
	clone.querySelector('.shoping__cart__total').innerHTML = pickItem.price;
	clone.querySelector('#deleteBtn').setAttribute('name', 'productCode');
	clone.querySelector('#deleteBtn').setAttribute('value', pickItem.productCode);	
	clone.style.display = "";
	document.querySelector("#itemsList").appendChild(clone);
	
}

// 장바구니 전달 event	
let btn = document.querySelector('#containBtn');
btn.addEventListener('click', function(e){
		document.forms.relayForm.action = "woonControl.do"; //일단 장바구니 table 모르기에 
		document.forms.relayForm.submit();
})	

 let minus =  document.querySelector('.dec qtybtn');
 let plus =  document.querySelector('.inc qtybtn');
 let plusMinus = document.querySelector('.pro-qty');

//minus.addEventListener('click', minuschangeBtn)
//plus.addEventListener('click', pluschangeBtn)



function minuschangeBtn(){
	console.log("1");
	minus.children.value;
	
}

function pluschangeBtn(){
		console.log("2");
	plusMinus.children.children.value;
}

