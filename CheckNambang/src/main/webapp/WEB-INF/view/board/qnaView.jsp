<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-lg-9 col-md-7">
<h3>글번호: ${qna.qnaNo }</h3>
<h3>제목: ${qna.qnaTitle}</h3>
<div style="display: flex; justify-content: space-between;">
<h4>유형:[${qna.qnaType1}]</h4> <h4>상세유형: [${qna.qnaType2}]</h4><h4></h4>
</div>
<textarea class="form-control" rows="6" readonly>${qna.qnaContent}</textarea>
<c:if test="${!empty qna.qnaImage}">
<img alt="ss" src="qnaImage/${qna.qnaImage}" width="100">
</c:if>
<h4>작성일: <fmt:formatDate value="${qna.qnaDate }" pattern="yyyy.MM.dd"/></h4>
<button type="button" class="btn btn-danger" onclick="remove(${qna.qnaNo})">삭제하기</button>
</div> <!-- col-lg-9 col-md-7 END -->
<script>
function remove(no) {
	if(!confirm("글을 삭제하시겠습니까?")){
		return false;		
	}
	location.href='removeQna.do?no=' + no;
}
</script>