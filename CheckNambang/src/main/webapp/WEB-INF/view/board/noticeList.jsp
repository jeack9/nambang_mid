<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="col-lg-9 col-md-7">
<h3>공지사항</h3>
<p>${myName}님 컬리의 새로운 소식들과 유용한 정보들을 한눈에 확인하세요.</p>
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
</div>

 <script src="boardJs/noticeList.js"></script>
