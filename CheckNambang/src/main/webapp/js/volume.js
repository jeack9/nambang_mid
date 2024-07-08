/**
 * 
 */
document.querySelectorAll(".dec").forEach(dec => { // 장바구니 상품 개수 감소
  dec.addEventListener("click", async (e) => {
    let cartNo = e.target.parentElement.dataset.no;
    let volume = e.target.parentElement.children[1].value - 1;
    let pcode = e.target.parentElement.dataset.pcode;
    if(volume < 1) {
    	volume =  1;
		return;
	}
    let jsonData = await updateCart({cartNo, volume, pcode});
    if(jsonData.retCode == "OK"){// 카트 수정되면 view 변경
   	  let cost = document.querySelector(`#cost${cartNo}`);
      cost.innerHTML = jsonData.product.price * jsonData.cart.cartVolume;
      let off = document.querySelector(`#off${cartNo}`);
   	  off.innerHTML = jsonData.product.offPrice != 0 ? jsonData.product.offPrice * jsonData.cart.cartVolume : cost.innerHTML;
      calcPrice(); // 최종금액 계산
    }
  });
});
document.querySelectorAll(".inc").forEach(inc =>{ // 장바구니 상품 개수 증가
  inc.addEventListener("click", async (e) => {
    let cartNo = e.target.parentElement.dataset.no;
    let volume = parseInt(e.target.parentElement.children[1].value) + 1;
    let pcode = e.target.parentElement.dataset.pcode;
    let jsonData = await updateCart({cartNo, volume, pcode});
    if(jsonData.retCode == "OK"){// 카트 수정되면 view 변경
      let cost = document.querySelector(`#cost${cartNo}`);
   	  cost.innerHTML = jsonData.product.price * jsonData.cart.cartVolume;
   	  let off = document.querySelector(`#off${cartNo}`);
   	  off.innerHTML = jsonData.product.offPrice != 0 ? jsonData.product.offPrice * jsonData.cart.cartVolume : cost.innerHTML;
      calcPrice(); // 최종금액 계산
    }
  });
});

async function updateCart(cvo = {}){ // fetch 장바구니 개수 업데이트
  let url = `editCartAjax.do?cartNo=${cvo.cartNo}&volume=${cvo.volume}&pcode=${cvo.pcode}`;
  let response = await fetch(url);
  let jsonData = await response.json();// return 해주면 promise 객체로 리턴됨... => 이벤트리스너 콜백함수 자체를 async 로 변경
  return jsonData;
}

// 상품 총 금액, 결제 예정금액 계산
function calcPrice(){
  let subtotal = 0;
  document.querySelectorAll(".cost").forEach(cost =>{
	if($(`#cart${cost.dataset.no}`)[0].checked) subtotal += parseInt(cost.innerText);
  });
  let total = 0;
  document.querySelectorAll(".off").forEach(cost =>{
	if($(`#cart${cost.dataset.no}`)[0].checked) total += parseInt(cost.innerText);
  });
  document.querySelector("#subtotal").innerText = subtotal;
  document.querySelector("#total").innerText = total;
}
calcPrice();

// 장바구니 우측 삭제 이벤트
document.querySelectorAll(".icon_close").forEach(removeBtn =>{
  removeBtn.addEventListener("click", (e)=> {
	if(!confirm("삭제할까요?")) return;
    fetch(`removeCartAjax.do?cartNo=${e.target.dataset.no}`)
      .then(result => result.json())
      .then(result => {
        if(result.retCode == "OK"){
          calcPrice();
          document.querySelector(`#C${e.target.dataset.no}`).remove();
        }
      })
      .catch(err => console.log(err));
  });
});

// 체크박스 전체(선택, 해제)
function checkAll(target){
	let cks = document.querySelectorAll("input[name='cartNo']");
	cks.forEach(ck =>{
		ck.checked = target.checked;
	});
	calcPrice();
}
// 체크박스 한개 클릭이벤트
function check(){
	let cks = document.querySelectorAll("input[name='cartNo']");
	let isCks = document.querySelectorAll("input[name='cartNo']:checked");
	document.querySelector("input.ckAll").checked = cks.length == isCks.length ? true : false;
	calcPrice();
}

// 선택 삭제 클릭이벤트
document.querySelector(".shoping__cart__btns > a:nth-of-type(1)").addEventListener("click", (e) => {
  e.preventDefault(); // a 태그 href 이벤트 방지
  let isCks = document.querySelectorAll("input[name='cartNo']:checked");
  if(isCks.length == 0){
    alert("삭제할 상품을 선택하세요.");
    return;
  }
  let delCarts = [];
  isCks.forEach(checked =>{
    delCarts.push(checked.value);
  });
  checkRemoveJSON({delCarts});
});


// 선택삭제
async function checkRemoveJSON(data) {
  try {
    const response = await fetch("delCartsAjax.do", {
      method: "POST", // 또는 'PUT'
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
    
    const result = await response.json();
    if(result.retCode == "OK"){
      data.delCarts.forEach(id => {
        document.querySelector(`#C${id}`).remove();
      });
    }
  } catch (error) {
    console.error("실패:", error);
  }
}

// 주문하기 클릭
function orderFnc(e){
	e.preventDefault();
	let isCks = document.querySelectorAll("input[name='cartNo']:checked");
    if(isCks.length == 0){
      alert("주문할 상품을 선택하세요.");
      return;
    }
  	document.orderfrm.submit();
}


// 배송지 변경 버튼 이벤트
function modiAddr(e){
	let popupX = (document.body.offsetWidth / 2) - (700 / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음
	let popupY= (window.screen.height / 2) - (800 / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
	window.open('myAddress.do?mode=1', '배송지 변경', 'width=700px,height=800px,scrollbars=yes, left='+ popupX + ', top='+ popupY);
}