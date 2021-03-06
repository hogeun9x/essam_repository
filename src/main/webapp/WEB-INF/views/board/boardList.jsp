<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="<%= request.getContextPath() %>"/>
<% //Author : 고연미 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>e-쌤</title>
<link rel="stylesheet" type="text/css" href="${ctxPath}/resources/css/basic.css">
<link rel="icon" href="${ctxPath}/resources/images/favicon_essam.ico" type="image/x-icon">
<link rel="shortcut icon" href="${ctxPath}/resources/images/favicon_essam.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp"%>
<section>
<div id="contents">
	<div id="aside">
		<div id="aside_area">
			<%@ include file="../common/aside.jsp"%>
		</div>
	</div>
	<div id="contents_area">
	<!---------- 본문 시작 ---------->
	
		<table class="container">
		<tr>
			<td align="left" style="padding:20px 0;">
				<h6><i class="fab fa-edge-legacy"></i> 클래스 <i class="fas fa-angle-right"></i> <span style="font-weight: bold;background-color:#f4edd8;">${clsName}</span></h6>
				<hr class="hr_${mbColor}"></td>
		</tr></table>
		
		<table class="container">
		<tr><td></td>
			<td align="left">전체 : ${totalNum} 건</td>
			<td align="right">
				<c:if test="${sessionScope.loginData.mbType==2}">
					<button type="button" onclick="location.href='${ctxPath}/class/goboardwrite?clsNo=${clsNo}&clsBrdType=${clsBrdType}';" class='btn_normal_t w100'>글쓰기 <i class="fas fa-pencil-alt"></i></button>
				</c:if></td>
			<td></td></tr>
		</table>
		<div class="container">
		<table class='table table-hover' style="background-color:white;">
		<thead>
		<tr>
			<th>번호</th>
			<th>제 목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
			<th>조회</th>
		</tr>
		</thead>
		<c:if test="${empty bList}">
			<thead>
			<tr class='prod'>
				<td colspan="6" align="center" height="200">등록된 게시물이 없습니다.</td>
			</tr>
			</thead>
		</c:if>
		<c:if test="${!empty bList}">
			<tbody class='tbl'>
				<c:forEach var="board" items="${bList}">
					<tr class='prod'>
						<td>${board.clsBrdNo}</td>
						<td><a href="${ctxPath}/class/boardread?clsNo=${clsNo}&clsBrdNo=${board.clsBrdNo}&pageNum=${param.pageNum}">${board.clsBrdTitle}</a></td>
						<td>${board.mbNickName}</td>
						<td>${board.clsBrdDate}</td>
						<td><c:if test="${board.clsBrdfileCnt > 0}"><i class="fas fa-save" style="width:24px;color:#666;"></i><%-- <img src="${ctxPath}/resources/images/icon_file.jfif" width=20> --%></c:if></td>
						<td>${board.clsBrdView}</td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
		</table>
		</div>
		<!-- 페이징 -->
		${paging}<br><br><br><br>

	<!---------- 본문 끝 ---------->
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp" %>
</body>
</html>