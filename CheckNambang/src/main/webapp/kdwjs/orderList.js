/**
 * kdwjs/orderList.js
 */



const target = document.querySelector('#target');
fetch('woonControl5.do?userId'+userId)
 	.then(result => result.json())
 	.then(result => {
		console.log(result);
			result.forEach(center =>{
				console.log(center);
			//target.appendChild(makeRow(center));	
			cloneRow(center);
			
		})
})
function productDetail(e){
	let on = e.target.orderNo;
	console.log(on);
	location.href ='woonControl10.do?orderNo='+on
	
}

function cloneRow(cart={}){
	let orderList = document.querySelector('thead').cloneNode(true);
	orderList.querySelector('#paymentTime').innerHTML = "결제시간>" + cart.orderDate;
	orderList.querySelector('#orderNo').innerHTML = "주문번호> " + cart.orderNo;
	orderList.querySelector('#orderPrice').innerHTML = "결제금액> " + cart.orderPrice;
	orderList.querySelector('#orderStatus').innerHTML = "주문상태> 주문완료" ;
	orderList.querySelector('.detaileView').setAttribute("href", "woonControl9.do?orderNo=" + cart.orderNo);
	//orderList.setAttribute('src', )
	orderList.style.display = "";
	document.querySelector('#target').appendChild(orderList);
}













		
	
/*let fields = ['orderNo','orderPrice','paymentStatus']	
function makeRow(center){
	console.log(center);
	let paymentTime = document.querySelector('#paymentTime');
	paymentTime.innerHTML = "결제 시간 " + center.orderDate;
	
	tr = document.createElement('tr');
	fields.forEach(field =>{
		console.log(field);
		let td = document.createElement('td');
		//td.innerHTML = center[field];
		 if (field === 'paymentStatus' && !center[field]) {
            td.innerHTML = "주문완료";
        } else {
            td.innerHTML = center[field];
        }
		tr.appendChild(td);
	})
	return tr;
}	*/
	
	
	
	
	
	
	
	
	
	