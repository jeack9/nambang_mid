<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
a.active{
    background: #7fad39;
    color: #ffffff;
}
</style>
<div class="col-lg-9 col-md-7">
	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="nvo" items="${requestScope.list }">
				<tr>
					<td>${nvo.noticeNo}</td><td>${nvo.noticeTitle}</td><td>${nvo.noticeWriter}</td><td>${nvo.noticeCreation}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="product__pagination">
		<!--  -->
		<c:if test="${paging.prev }">
		<a href="noticeList.do?page=${paging.startPage - 1}"><i class="fa fa-long-arrow-left"></i></a>
		</c:if>
		<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
		<a href="noticeList.do?page=${p}" class="${p == paging.currPage ? 'active' : '' }">${p}</a>
		</c:forEach>
		<c:if test="${paging.next }">
		<a href="noticeList.do?page=${paging.endPage + 1}"><i class="fa fa-long-arrow-right"></i></a>
		</c:if>
	</div>
</div>
<script src="boardJs/noticeList.js"></script>