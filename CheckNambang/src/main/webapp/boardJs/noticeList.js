/**
 *  boardJs/noticeList.js
 */
//공지사항 목록 가져오기
noticeList();

function noticeList(){
	document.querySelector('#listBody').innerHTML = "";
	showNoctis();
}
// 공지사항 목록 가져오기
let url = "noticeList.do?page=1";
function showNoctis(){
  fetch(url)
  .then(result => result.json())
  .then(result => {
      result.list.forEach(notice => {
        cloneRow(notice);
      });
  })
  .catch(err => console.log(err));
}

// 검색이벤트
document.querySelector("input[type='search']").addEventListener("keyup", (e) =>{
  if(e.keyCode == 13) console.log("엔터누름");
});

// 행 만들기
function cloneRow(notice = {}){
  // let fields = ["noticeNo", "noticeTitle", "noticeWriter", "noticeCreation"];
  let cloneTr = document.querySelector("tbody > tr:nth-of-type(1)").cloneNode(true);
  cloneTr.querySelector("td:nth-of-type(1)").innerHTML = notice.noticeNo;
  cloneTr.querySelector("td:nth-of-type(2)").innerHTML = notice.noticeTitle;
  cloneTr.querySelector("td:nth-of-type(3)").innerHTML = notice.noticeWriter;
  cloneTr.querySelector("td:nth-of-type(4)").innerHTML = notice.noticeCreation;
  cloneTr.style.display = "";
  document.querySelector("tbody").appendChild(cloneTr);
}

// 페이지 만들기
function paging(paging ={}){
  
}