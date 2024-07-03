<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-lg-9 col-md-7">
<table class="table">
<tbody>
  <tr>
  	<td class="col-md-2 align-middle">유형</td>
  	<td class="col-md-5">
  		<select class="search_condition w-100" onchange="selectType(event)">
				<option value="">문제유형 선택</option>
				<option value="취소/교환/반품">취소/교환/반품</option>
				<option value="서비스/오류/기타">서비스/오류/기타</option>
		</select>
  	</td>
  	<td class="col-md-5 align-middle">
		<select class="w-100">
				<option value="">상세유형 선택</option>
				<option value="0">답변대기</option>
				<option value="1">답변완료</option>
		</select>
		</td>
  </tr>
	<tr>
		<td>상품</td>
		<td colspan="2" class="align-middl">
			<button type="button" class="w-100">주문상품 선택</button>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="2"><input type="text" class="w-100" placeholder="제목을 입력하세요."></td>
	</tr>
	<tr>
		<td>내용</td>
		<td colspan="2">
			<textarea class="form-control" rows="6"></textarea>
			<input type="file">
		</td>
	</tr>
	<tr>
		<td colspan="3"><button type="button" class="btn btn-primary w-40">등록</button></td>
	</tr>
</tbody>
</table>
</div>
<script>
	
</script>