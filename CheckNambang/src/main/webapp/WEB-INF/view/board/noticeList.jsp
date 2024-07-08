<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
<form action="sooControl4.do">
<div class="col-lg-9 col-md-7">
<h3>공지사항</h3>

<p>컬리의 새로운 소식들과 유용한 정보들을 한눈에 확인하세요.</p>
<input type="submit" value="등록하기" class="btn btn-primary" >
<br>
<br>
  <table class="table table-hover" id="listTable">
      <thead>
          <tr>
              <th class="col-sm-1">번호</th>
              <th class="col-sm-2">제목</th>
              <th class="col-sm-1">작성자</th>
              <th class="col-sm-2">작성일</th>
          </tr>
       </thead>
      <tbody id="listBody">
        <c:forEach var="nt" items="${list }">
        <tr onclick="notice(event)">
          <td>${nt.noticeNo }</td>
          <td>${nt.noticeTitle }</td>
          <td>${nt.noticeWriter }</td>
          <td>${nt.noticeCreation }</td>
        </tr>
        </c:forEach>
      </tbody>   
  </table>
  
  
  <p>${paging }</p>
  <div class="pagination">
  <c:if test="${paging.prev }">
  <a href="noticeList.do?page=${paging.startPage-1 }">&laquo;</a>
  </c:if>
  <c:forEach var="pg" begin="${paging.startPage }" end="${paging.endPage }">
    <c:choose>
      <c:when test="${pg == paging.page }">
        <a class="active" href="noticeList.do?page=${pg }">${pg }</a>    
      </c:when>
      <c:otherwise>
        <a href="noticeList.do?page=${pg }">${pg }</a>
      </c:otherwise>
    </c:choose>
  
  </c:forEach>
  <c:if test="${paging.next }">
  <a href="noticeList.do?page=${paging.endPage+1 }">&raquo;</a>
  </c:if>
  
</div>


</div>
</form>
 <script src="boardJs/noticeList.js"></script>
