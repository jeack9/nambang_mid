/**
 * product.js
 */

//데이터 목록 출력하기
fetch('hyunControl2.do')
	.then(result => result.json())
	.then(result => result.forEach(item => {
		console.log(item);
		cloneDiv(item);
	}))

function cloneDiv(product = {}) {
	let cloneDiv = document.querySelector("#product_list > div:nth-of-type(1)").cloneNode(true);
	cloneDiv.style.display = "";
	cloneDiv.querySelector(".product_img").style.backgroundImage = `url(moImg/${product.productImage}.jpg)`;
	cloneDiv.querySelector(".product_text>h5").innerHTML = `${product.company}` + `${product.productName}`;
	cloneDiv.querySelector(".product_text>h4").innerHTML = `${product.price}` + "원";
	cloneDiv.querySelector(".product_text>h6").innerHTML = "💬 " + `${product.viewCnt}`;
	document.querySelector("#product_list").appendChild(cloneDiv); // 복사본 붙이기
}

document.querySelector('#product_list').addEventListener('click', (event) => {
	if (event.target.classList.contains('btn-open-modal')) {
		document.querySelector('.modal').style.display = 'flex';
	}
});

document.querySelector('.modal').addEventListener('click', (event) => {
	if (event.target === event.currentTarget) {
		document.querySelector('.modal').style.display = 'none';
	}
});