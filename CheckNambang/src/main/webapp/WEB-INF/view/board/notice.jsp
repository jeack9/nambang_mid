<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="col-lg-9 col-md-7">
	<h3>공지사항</h3>
	<br>
	<table class="table" id="inputTable" >
		<tr>
			<th class="col-sm-2">제목</th>
			<td class="col-sm-7">${noticeTitle}</td>
			<th class="col-sm-2"></th>
			
		</tr>
		<tr>
			<th class="col-sm-2">작성자</th>
			<td class="col-sm-7">${noticeWriter}</td>
			<th class="col-sm-2"></th>
		</tr>
		<tr>
		    <th class="col-sm-2">작성일</th>
		    <td class="col-sm-7">${noticeCreation}</td>
		    <th class="col-sm-2"></th>
		</tr>
		<tr>
		    <td class="col-sm-1"></td>
		    <td class="col-sm-9">${noticeContent}</td>
		    <td class="col-sm-1"></td>
		</tr>
	</table>
	</div>

 <script src="boardJs/notice2.js"></script>