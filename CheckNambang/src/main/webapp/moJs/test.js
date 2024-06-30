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
	
	fields1 = ['포장타입','중량/용량','상품선택'];
	fields2 = [item.packageType,item.weight,item.company+item.productName+item.weight]
	
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
	
	console.log(item.descript);
	let descrip = document.querySelector('#description');
	let p = document.createElement('p')
	p.innerHTML = item.description;
	descrip.appendChild(p);
	
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


