/**
 * product.js
 */
let code;
//데이터 목록 출력하기
fetch('hyunControl2.do')
	.then(result => result.json())
	.then(result => result.forEach(item => {
		console.log(item);
		cloneDiv(item);
	}))

function productDetail(e){
	console.log(e.target.id);
	location.href ="mocontrol.do?proCode=" + e.target.id; 
}
let totalC = document.getElementById('totalCnt');
function cloneDiv(product = {}) {

	code = product.productCode;
	console.log(code);
	let cloneDiv = document.querySelector("#product_list > div:nth-of-type(1)").cloneNode(true);
	cloneDiv.style.display = "";
	cloneDiv.querySelector(".product_img").style.backgroundImage = `url(moImg/${product.productImage})`+" ";
	cloneDiv.querySelector(".product_img").setAttribute("id", product.productCode);
	cloneDiv.querySelector(".product_img").addEventListener("click", productDetail);
	cloneDiv.querySelector("#product_title").innerHTML = `${product.company}` + `${product.productName}`;
	cloneDiv.querySelector("#product_price").innerHTML = `${product.offPrice}` + "원";
	cloneDiv.querySelector("p").innerHTML = `${product.price}` + "원";
	//할인값 없을때 일반 가격
	let defaultPrice = cloneDiv.querySelector("#product_price")
	if (`${product.offPrice}` == 0 || `${product.offPrice}` == null || `${product.offPrice}` == `${product.price}`) {
		cloneDiv.querySelector("p").innerHTML = "";
		cloneDiv.querySelector("#product_price").style.color = "black";
		defaultPrice.innerHTML = `${product.price}` + "원";
	}
	cloneDiv.querySelector(".product_text>h6").innerHTML = "💬 " + `${product.viewCnt}`;

	//장바구니 버튼 모달창
	cloneDiv.querySelector(".cart_btn").addEventListener("click", (e) => {
		if (e.target.classList.contains('cart_btn')) {
			document.querySelector('.modal').style.display = 'flex';
		}
		document.getElementById('modal_code').textContent = `${product.productCode}`
		document.getElementById('modal_img').style.backgroundImage = `url(moImg/${product.productImage})`;
		document.getElementById('modal_company').innerHTML = `${product.company}` + `${product.productName}`;

		// 할인된 값이 없을 때 기본 값 설정

		let modalPrice = document.getElementById('modal_price'); /*= `${product.offPrice}`+"원";	*/
		if (`${product.offPrice}` == 0) {
			modalPrice.innerHTML = "가격 : " + `${product.price}`;
		} else {
			modalPrice.innerHTML = "가격 : " + `${product.offPrice}`;
		}


		//클릭 개수에 따른 가격 총합 
		let endPrice = document.querySelector('#priceSum');
		document.querySelector('.pro-qty').addEventListener('click', () => {
			let total = totalC.value;
			if (`${product.offPrice}` == 0) {
				endPrice.innerHTML = "총 합계 : " + total * `${product.price}` + "원"
			} else if (`${product.offPrice}` != 0) {
				endPrice.innerHTML = "총 합계 : " + total * `${product.offPrice}` + "원"
			}
		})
	});
	document.querySelector("#product_list").appendChild(cloneDiv); // 복사본 붙이기


}

//장바구니 버튼 클릭시 장바구니 담기
document.querySelector('.putCart').addEventListener('click', () => {
	let proCode = document.getElementById('modal_code').textContent;
	let totalCnt = totalC.value;
	console.log(totalCnt);
	console.log(proCode);
	const putAjax = new XMLHttpRequest();
	putAjax.open('get', 'hyunControl3.do?proCode=' + proCode //
				+ '&userId=' + userId + '&cartVolume=' + totalCnt);
	putAjax.send();
	putAjax.onload = function(){
		let result = JSON.parse(putAjax.responseText);
		if(result.retCode == 'OK'){
			alert('장바구니담기 완료');
		}else{
			alert('장바구니담기 실패');
		}
	}
});






