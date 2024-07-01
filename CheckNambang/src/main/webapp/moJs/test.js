/**
 * moJs/test.js
 */
let totalCnt = document.querySelector('#totalCnt').value;
fetch('mocontrol2.do?productCode=A001&userId='+userId )
.then(result => result.json())
.then(result => result.forEach(item => {
	
	let img = document.querySelector('.product__details__pic__item--large')
	
	let imageName = item.productImage;
        if (!imageName.includes('.')) {
            imageName += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
        }
	img.src = 'moImg/'+imageName;

	let title = document.querySelector('#titleList');
	title.innerHTML = item.company+item.productName;
	
	console.log(item.offPrice);
	let price = document.querySelector('.product__details__price');
	if(item.offPrice == 0){
		price.innerHTML = item.price + '원';
	}else if(item.offPrice != 0){
		price.innerHTML = item.offPrice +'원';
	}
	
	let text = '23시 이전주문 시 내일 아침 7시 전 도착\n(대구,부산,울산 샛별배송 운영시간 별도 확인)';
	fields1 = ['배송','포장타입','중량/용량','상품선택'];
	fields2 = [text,item.packageType,item.weight,item.company+item.productName+item.weight]
	let list = document.querySelector('#detailList');
	
	for(let i = 0; i < fields1.length;i++){
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		th = document.createElement('th');
		
		th.innerText = fields1[i];
		td.innerText = fields2[i];
		tr.appendChild(th);
		tr.appendChild(td);
		
		list.appendChild(tr);
	}
		
	let endPrice = document.querySelector('#endPrice');
	document.querySelector('.pro-qty').addEventListener('click', function(){
			totalCnt = document.querySelector('#totalCnt').value;
		if(item.offPrice == 0){
			endPrice.innerHTML = '총 상품금액 : ' + (totalCnt * item.price) + '원';
		}else if(item.offPrice != 0){
			
			endPrice.innerHTML = '총 상품금액 : ' + (totalCnt * item.offPrice) + '원';
		}
	})
	if(item.offPrice == 0){
			endPrice.innerHTML = '총 상품금액 : ' + item.price + '원';
		}else if(item.offPrice != 0){
			
			endPrice.innerHTML = '총 상품금액 : ' + item.offPrice + '원';
		}
	
	let descrip = document.querySelector('#tabs-1');
	let p = document.createElement('p')
	p.innerHTML = item.descript;
	descrip.appendChild(p);
	
	let info = document.querySelector('#tabs-2');
	img = document.createElement('img');
	let infoImg = item.descriptImage;
        if (!infoImg.includes('.')) {
            infoImg += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
        }
	img.src = 'moImg/'+infoImg;
	info.appendChild(img);
	
	return list;
	
}))
.catch(err => console.log(err));

fetch('mocontrol5.do?proCode=A001')
	.then(result => result.json())
	.then(result => result.forEach(hugi =>{
		let hugiList = document.querySelector('#hugiList');
		
		field1 = [hugi.userName];
		field2 = [hugi.user]
	}))

document.querySelector('.heart-icon').addEventListener('click', zzimFnc);
function zzimFnc(){
	fetch('mocontrol3.do?proCode=A001&userId='+userId)
		.then(result => result.json())
		.then(result =>{
			console.log(userId);
			if(result.retCode == 'OK'){
				alert('찜 등록 성공');
			}
		})
}

document.querySelector('.primary-btn').addEventListener('click', cartFnc);
function cartFnc(){
	fetch('mocontrol4.do?proCode=A001&userId='+userId+'&cartVolume='+totalCnt)
		.then(result => result.json())
		.then(result => {
			if(result.retCode == 'OK'){
				alert('장바구니 등록 성공');
			}
		})
}

