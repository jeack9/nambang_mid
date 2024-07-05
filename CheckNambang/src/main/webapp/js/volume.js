/**
 * 
 */
document.querySelectorAll(".dec").forEach(dec => {
  dec.addEventListener("click", (e) => {
    let cartNo = e.target.parentElement.dataset.no;
    let volume = e.target.parentElement.children[1].value - 1;
    volume = volume < 0 ? 0 : volume;
    if(updateCart(cartNo, volume)){// 카트 수정되면 view 변경
      
    }
	});
});
document.querySelectorAll(".inc").forEach(inc =>{
  inc.addEventListener("click", (e) => {
    let cartNo = e.target.parentElement.dataset.no;
    let volume = parseInt(e.target.parentElement.children[1].value) + 1; 
    updateCart(cartNo, volume);
  });
});

async function updateCart(cartNo, volume){
  let url = `editCartAjax.do?cartNo=${cartNo}&volume=${volume}`;
  let response = await fetch(url);
  let jsonData = await response.json();
  return jsonData.retCode == "OK";
}

//let tr = document.querySelector("tbody> tr:nth-of-type(1)").cloneNode(true);
//document.querySelector("tbody").appendChild(tr);