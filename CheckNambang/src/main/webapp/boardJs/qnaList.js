/**
 *  boardJs/noticeList.js
 */

let search = {page : 1, searchCondition: -1, keyword: ""};
let pageDTO = {};

// Qna 목록 가져오기
function qnaList(search = {}){
  url = `qnaListAjax.do?page=${search.page}&sc=${search.searchCondition}&kw=${search.keyword}`;
  console.log(url);
  fetch(url)
    .then(result => result.json())
    .then(result => {
      search = result.search;
      pageDTO = result.paging;
      document.querySelector("tbody").innerHTML = "";
      result.list.forEach(qna => {
        cloneRow(qna);
      });
      paging(pageDTO);
    })
    .catch(err => console.log(err));
}
qnaList(search);// 공지사항 목록 첫 로딩

// 검색이벤트
document.querySelector("input[type='search']").addEventListener("keyup", (e) =>{
  if(e.keyCode == 13) {
    search.page = 1;
    search.searchCondition = document.querySelector("#search_condition").value;
    search.keyword = e.target.value;
    console.log(search);
    qnaList(search);
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
  cloneTr.addEventListener("click", (e) =>{
	location.href = `viewQna.do?no=${qna.qnaNo}`;
  });
  document.querySelector("tbody").appendChild(cloneTr);
}

// 페이지 만들기
function paging(pageDTO ={}){
  let pageBody = document.querySelector(".product__pagination>div");
  pageBody.innerHTML = "";
  if(pageDTO.prev){ // 페이지 좌측화살표
    let cloneLarrow = document.querySelector(".product__pagination > a:nth-of-type(1)").cloneNode(true);
    cloneLarrow.style.display = "";
    cloneLarrow.addEventListener("click", (e) => {
      search.page = pageDTO.startPage - 1;
      e.preventDefault();
      qnaList(search);
    });
    pageBody.appendChild(cloneLarrow);
  }
  for(let p = pageDTO.startPage; p <= pageDTO.endPage; p++){ // 페이지
    let clonePage = document.querySelector(".product__pagination > a:nth-of-type(2)").cloneNode(true);
    clonePage.innerHTML = p;
    clonePage.style.display = "";
    if(p == pageDTO.page) clonePage.setAttribute("class", "active");
    clonePage.addEventListener("click", (e) => {
      e.preventDefault();
      search.page = p;
      qnaList(search);
    }); // 페이지 클릭 이벤트
    pageBody.appendChild(clonePage);
  }
  if(pageDTO.next){ // 페이지 우측화살표
    let cloneRarrow = document.querySelector(".product__pagination > a:nth-of-type(3)").cloneNode(true);
    cloneRarrow.style.display = "";
    cloneRarrow.addEventListener("click", (e) => {
      search.page = pageDTO.endPage + 1;
      e.preventDefault();
      qnaList(search);
    });
    pageBody.appendChild(cloneRarrow);
  }
}
