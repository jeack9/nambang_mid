/**
 * moJs/test.js
 */
fetch("mocontrol2.do?productCode=A001&userId=ahn" )
.then(result => result.json())
.then(result => result.forEach(item => {
	
	let list = document.querySelector('#detailList');
	let tr = document.createElement('tr');
	let td = document.createElement('td');
	let img = document.createElement('img');
	
	let imageName = item.productImage;
        if (!imageName.includes('.')) {
            imageName += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
        }
	img.src = 'moImg/'+imageName;
	td.appendChild(img);
	tr.appendChild(td);
	list.appendChild(tr);
	
	tr = document.createElement('tr');
	
	let th = document.createElement('th');
	th.innerHTML = item.company+item.productName;
	tr.appendChild(th);
	list.appendChild(tr);
	
	tr = document.createElement('tr');
	th = document.createElement('th');
	th.innerHTML = item.offPrice +'원';
	tr.appendChild(th);
	list.appendChild(tr);
	
	let text = '23시 이전주문 시 내일 아침 7시 전 도착\n(대구,부산,울산 샛별배송 운영시간 별도 확인)';
	fields1 = ['배송','포장타입','중량/용량','상품선택'];
	fields2 = [text,item.packageType,item.weight,item.company+item.productName+item.weight]
	
	for(let i = 0; i < fields1.length;i++){
		tr= document.createElement('tr');
		let td=document.createElement('td');
		th = document.createElement('th');
		
		th.innerText = fields1[i];
		td.innerText = fields2[i];
		tr.appendChild(th);
		tr.appendChild(td);
		
		list.appendChild(tr);
	}
	
	td=document.createElement('td');
	tr= document.createElement('tr');
	td.innerHTML = '총 상품금액 : ' + item.offPrice;
	tr.appendChild(td);
	list.appendChild(tr);
	
	let descrip = document.querySelector('#description');
	let p = document.createElement('p')
	p.innerHTML = item.descript;
	descrip.appendChild(p);
	
	let info = document.querySelector('#information');
	img = document.createElement('img');
	let infoImg = item.descriptImage;
	console.log(infoImg);
        if (!infoImg.includes('.')) {
            infoImg += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
        }
	img.src = 'moImg/'+infoImg;
	info.appendChild(img);
	
	
	return list;
	
	
}))
.catch(err => console.log(err));

document.querySelector('#zzimBtn').addEventListener('click', zzimFnc);
function zzimFnc(){
	fetch("mocontrol3.do?proCode=A001&userId=ahn")
		.then(result => result.json())
		.then(result =>{
			if(result.retCode == 'OK'){
				alert('등록 성공');
			}
		})
}


