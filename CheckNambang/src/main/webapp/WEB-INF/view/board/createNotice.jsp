<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="sooControl3.do">
<div class="col-lg-9 col-md-7">
		<h3>공지사항</h3>
		<br>
		<table class="table" id="inputTable">
			<tr>
				<th class="col-sm-2">제목
				<th>
				<td class="col-sm-7"><input type="text" name="title"></td>
			</tr>
			<tr>
				<th class="col-sm-2">작성자</th>
				<td class="col-sm-7"><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th class="col-sm-1"></th>
				<td class="col-sm-9"><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록하기"
					class="btn btn-primary"></td>
			</tr>
		</table>
</div>
</form>
<script src="boardJs/notice3.js"></script>