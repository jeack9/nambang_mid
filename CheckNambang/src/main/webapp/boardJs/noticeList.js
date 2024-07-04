/**
 *  boardJs/noticeList.js
 */

// 공지사항 선택 이벤트
function notice(event){
	console.log(event.target.parentElement.children[0]);
	console.log(event.target.parentElement.querySelector("td:nth-of-type(1)"));
	location.href="sooControl.do?no=" + event.target.parentElement.children[0].innerHTML;
}

// 페이지 만들기
function paging(paging ={}){
  
}