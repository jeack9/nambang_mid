/**
 * moJs/test.js
 */
let data = window.location.search;
let param = new URLSearchParams(data);
let proCode = param.get('proCode');

let totalCnt = document.querySelector('#totalCnt').value;
fetch('mocontrol2.do?proCode='+proCode)
	.then(result => result.json())
	.then(result => result.product.forEach(pro => {
		
		let img = document.querySelector('.product__details__pic__item--large')

		let imageName = pro.productImage;
		if (!imageName.includes('.')) {
			imageName += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
		}
		
		img.src = 'moImg/' + imageName;
		
		let title = document.querySelector('#titleList');
		title.innerHTML = pro.company + pro.productName;

		console.log(pro.offPrice);
		let price = document.querySelector('.product__details__price');
		if (pro.offPrice == 0) {
			price.innerHTML = pro.price + '원';
		} else if (pro.offPrice != 0) {
			price.innerHTML = pro.offPrice + '원';
		}

		let text = '23시 이전주문 시 내일 아침 7시 전 도착\n(대구,부산,울산 샛별배송 운영시간 별도 확인)';
		fields1 = ['배송', '포장타입', '중량/용량', '상품선택'];
		fields2 = [text, pro.packageType, pro.weight, pro.company + pro.productName + pro.weight]
		let list = document.querySelector('#detailList');

		fields1.forEach((field, idx, arry) => {
			let tr = document.createElement('tr');
			let td = document.createElement('td');
			th = document.createElement('th');

			th.innerText = field;
			if (idx == 2 || idx == arry.length - 1) {
				if (pro.weight >= 1000) td.innerText = fields2[idx] + "kg";
				else td.innerText = fields2[idx] + "g";
			}
			else td.innerText = fields2[idx];
			tr.appendChild(th);
			tr.appendChild(td);

			list.appendChild(tr);
		});

		/*for(let i = 0; i < fields1.length;i++){
			let tr = document.createElement('tr');
			let td = document.createElement('td');
			th = document.createElement('th');
			
			th.innerText = fields1[i];
			td.innerText = fields2[i];
			tr.appendChild(th);
			tr.appendChild(td);
			
			list.appendChild(tr);
		}*/

		let endPrice = document.querySelector('#endPrice');
		document.querySelector('.pro-qty').addEventListener('click', function() {
			totalCnt = document.querySelector('#totalCnt').value;
			if (pro.offPrice == 0) {
				endPrice.innerHTML = '총 상품금액 : ' + (totalCnt * pro.price) + '원';
			} else if (pro.offPrice != 0) {

				endPrice.innerHTML = '총 상품금액 : ' + (totalCnt * pro.offPrice) + '원';
			}
		})
		if (pro.offPrice == 0) {
			endPrice.innerHTML = '총 상품금액 : ' + pro.price + '원';
		} else if (pro.offPrice != 0) {

			endPrice.innerHTML = '총 상품금액 : ' + pro.offPrice + '원';
		}

		let descrip = document.querySelector('#tabs-1');
		let p = document.createElement('p')
		p.innerHTML = pro.descript;
		descrip.appendChild(p);

		let info = document.querySelector('#tabs-2');
		img = document.createElement('img');
		let infoImg = pro.descriptImage;
		if (!infoImg.includes('.')) {
			infoImg += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
		}
		img.src = 'moImg/' + infoImg;
		info.appendChild(img);

		return list;

	}))
	.catch (err => console.log(err));



// 후기 행 만들기
fetch('mocontrol5.do?proCode='+proCode)
	.then(result => result.json())
	.then(result => result.forEach(hugi => {
		let hugiList = document.querySelector('#hugiList');

		field1 = [hugi.userName];
		field2 = [hugi.company + hugi.productName, hugi.hugiContent, hugi.hugiImage, hugi.hugiDate]
		for (let i = 0; i < field1.length; i++) {
			let tr = document.createElement('tr');
			let th = document.createElement('th');
			th.innerHTML = field1[i];
			tr.appendChild(th);

			for (let j = 0; j < field2.length; j++) {
				let td = document.createElement('td');
				td.innerHTML = field2[j];
				tr.appendChild(td);
			}


			hugiList.appendChild(tr);
		}
		return hugiList;
	}))

document.querySelector('#zzimBtn').addEventListener('click', zzimFnc);
function zzimFnc() {
	fetch('mocontrol3.do?proCode='+proCode)
		.then(result => result.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'OK') {
				alert('찜 등록 성공');
			}
		})
}

document.querySelector('#cartBtn').addEventListener('click', cartFnc);
function cartFnc() {
	fetch('mocontrol4.do?proCode='+proCode+'&userId=' + userId + '&cartVolume=' + totalCnt)
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('장바구니 등록 성공');
			} else if (result.retCode == 'NG') {
				alert('장바구니 등록 실패');
			}
		})
}

