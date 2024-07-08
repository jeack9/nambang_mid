<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<div class="col-lg-9 col-md-7">
		<form action="sooControl3.do">
			<h3>공지사항</h3>
			<br>
			<table class="table" id="inputTable">
				<tr>
					<th class="col-sm-2">제목</th>
					<td class="col-sm-7"><input type="text" name="title"></td>
				</tr>
				<tr>
					<th class="col-sm-2">작성자</th>
					<td class="col-sm-7"><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea class="form-control" rows="6" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록하기" class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
	<script src="boardJs/notice3.js"></script>