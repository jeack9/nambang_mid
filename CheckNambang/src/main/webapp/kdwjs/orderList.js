/**
 * kdwjs/orderList.js
 */



const target = document.querySelector('#target');
fetch('woonControl5.do?userId'+userId)
 	.then(result => result.json())
 	.then(result => {
			result.forEach(center =>{
			target.appendChild(makeRow(center));	
		})
})
		
		
	
let fields = ['productName', 'orderNo','orderPrice','paymentStatus']	
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
}	
	
	
	
	
	
	
	
	
	
	