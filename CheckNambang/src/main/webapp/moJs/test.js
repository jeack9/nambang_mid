/**
 * moJs/test.js
 */
fetch("mocontrol2.do?productCode=A001" )
.then(result => result.json())
.then(result => result.forEach(item => {
	let list = document.querySelector('#detailList');
	let tr = document.createElement('tr');
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
	console.log(fields1.length);
	
	tr= document.createElement('tr');
	let td=document.createElement('td');
	th = document.createElement('th');
	for(let i = 0; i < fields1.length;i++){
	
		th.innerHTML = fields1[i];
		td.innerHTML = fields2[i];
		tr.appendChild(th);
		tr.appendChild(td);
		list.appendChild(tr);
	}
	return list;
	
}))
.catch(err => console.log(err));

/*feild1['id','pw','name'];
feild2['아이디','비번','이름'];
tr
for(let i = 0; i<feild1.length; i++) {
	th = feild2[i];
	td = feild1[i];
	tr.appendChild(th);
	tr.appendChild(td);
	
}*/
