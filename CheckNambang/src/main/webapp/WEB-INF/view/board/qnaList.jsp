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
				<option value="">답변대기</option>
				<option value="">답변완료</option>
			</select>
	       	<input class="form-control me-2" value="${keyword }"
	       	type="search" placeholder="Search" aria-label="Search" style="width: 80%">
        </div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="col-md-6">제목</th><th class="col-md-2">작성자</th><th class="col-md-2">작성일</th><th class="col-md-2">답변상태</th>
				</tr>
				<tr>
					<td>제목</td><td>작성자</td><td>작성일</td><td>답변상태</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="qvo" items="${requestScope.list }">
				<tr>
					<td>${qvo.qnaTitle}</td><td>${qvo.userId}</td><td>${qvo.qnaDate}</td><td>${qvo.qnaState }</td>
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

<script>
	const userId = '${sessionScope.login.userId}';
</script>
<script src="boardJs/qnaList.js"></script>