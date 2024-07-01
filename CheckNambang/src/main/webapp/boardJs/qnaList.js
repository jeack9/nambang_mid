/**
 *  boardJs/noticeList.js
 */

// 공지사항 목록 가져오기
console.log("호출");
let url = `qnaListAjax.do`;
function init(){
  fetch(url)
  .then(result => result.json())
  .then(result => {
      result.list.forEach(qna => {
        cloneRow(qna);
      });
  })
  .catch(err => console.log(err));
}
init();

// 검색이벤트
document.querySelector("input[type='search']").addEventListener("keyup", (e) =>{
  if(e.keyCode == 13) {
    url = `qnaListAjax.do?keyword=${e.target.value}`;
    fetch(url)
    .then(result => result.json())
    .then(result => {
      document.querySelector("tbody").innerHTML = "";
      result.list.forEach(qna => {
        cloneRow(qna);
      });
    })
    .catch(err => console.log(err));
  }
});

// 행 만들기
function cloneRow(qna = {}){
  let cloneTr = document.querySelector("thead > tr:nth-of-type(2)").cloneNode(true);
  cloneTr.querySelector("td:nth-of-type(1)").innerHTML = qna.qnaTitle;
  cloneTr.querySelector("td:nth-of-type(2)").innerHTML = qna.userId;
  cloneTr.querySelector("td:nth-of-type(3)").innerHTML = qna.qnaDate;
  cloneTr.querySelector("td:nth-of-type(4)").innerHTML = qna.qnaState == 0 ? "대기 중" : "답변완료";
  cloneTr.style.display = "";
  document.querySelector("tbody").appendChild(cloneTr);
}

// 페이지 만들기
function paging(paging ={}){
  
}