/**
 *  boardJs/noticeList.js
 */


// Qna 목록 가져오기
function selectQna(page = 1, sc = -1, kw = ""){
  url = `qnaListAjax.do?page=${page}&sc=${sc}&kw=${kw}`;
  console.log(url);
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
selectQna();// 공지사항 목록 첫 로딩

// 검색이벤트
document.querySelector("input[type='search']").addEventListener("keyup", (e) =>{
  if(e.keyCode == 13) {
    
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