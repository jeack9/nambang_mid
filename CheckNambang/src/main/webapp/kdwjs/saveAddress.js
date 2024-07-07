/**
 * saveAddress.js
 */

fetch('woonControl14.do?userId='+userId)
	.then(result => result.json())
	.then(result =>{
		console.log(result);
		result.forEach(addrList =>{
			console.log(addrList);
			cloneRow(addrList);
		})		
	})



 function cloneRow(addr={}){
	let copy = document.querySelector('tbody>tr').cloneNode(true);
	copy.querySelector('#address0>input').setAttribute('value',addr.addrNo);
	copy.querySelector('#address0>input').setAttribute('name','addrNo');
	copy.querySelector('#address1>p').innerHTML = addr.addr1;
	copy.querySelector('#address2>p').innerHTML = addr.addr2;
	copy.style.display = "";
	document.querySelector('#addBody').appendChild(copy);
 }
 
 function reloadAddresses() {
    // 화면 비우기
    document.querySelector('#addBody').innerHTML = '';
    
    // 주소 다시 불러오기
    fetch('woonControl14.do?userId=' + userId)
        .then(result => result.json())
        .then(result => {
            result.forEach(addrList => {
                cloneRow(addrList);
            });
        });
}

 // input 태그에 addEvent 를 줘서 클릭이 되면 클릭된 input value 값을 db 에 전달 하여 1으로 만들고  나머지 0
 
 let basicAddr = document.querySelector('#basicBtn');
 
basicAddr.addEventListener('click', function(e){
	
	let addrNo = document.querySelector('input[name=addrNo]:checked').value;
	console.log(addrNo);
	fetch('woonControl17.do?addrNo='+addrNo)
		.then(result => result.json())
		.then(result => {
			console.log(result);
		if(result.retCode == 'Good'){
			alert('업데이트가 잘되었습니다.');
			document.querySelector('#addBody').innerHTML = '';
			console.log(result);
			reloadAddresses();
		}else{
			alert('업데이트가 잘못 되었습니다');
		}
	})
})
 
 
 
 
 
 