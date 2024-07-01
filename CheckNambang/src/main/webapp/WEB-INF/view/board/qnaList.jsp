<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
a.active{
    background: #7fad39;
    color: #ffffff;
}
</style>
<div class="col-lg-9 col-md-7">
	<div>
		<div class="blog__sidebar__search">
			<select>
				<option value="T">제목</option>
				<option value="C">내용</option>
				<option value="TC">제목&내용</option>
				<option value="W">작성자</option>
			</select>
	       	<input class="form-control me-2" value="${keyword }"
	       	type="search" placeholder="Search" aria-label="Search" style="width: 80%">
        </div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<tr style="display:none">
					<td>공지사항번호</td><td><a href="">제목</a></td><td>작성자</td><td>작성일</td>
				</tr>
				<c:forEach var="nvo" items="${requestScope.list }">
				<tr>
					<td>${nvo.noticeNo}</td><td><a href="">${nvo.noticeTitle}</a></td><td>${nvo.noticeWriter}</td><td>${nvo.noticeCreation}</td>
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