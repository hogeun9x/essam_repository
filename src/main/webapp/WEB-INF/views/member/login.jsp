<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="<%= request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="${ctxPath}/resources/css/basic.css">
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>

<section>
${fMsg}
<form action="access" method="post">
	아이디 <input type="text" name="mbId" id="mbId"/><br>
	비밀번호 <input type="password" name="mbPwd"/><br>
	<input type="submit" value="로그인"/>
</form>
</section>

<%@ include file="../common/footer.jsp" %>
<script>
$(document).ready(function(){ $("#mbId").focus(); });
</script>
</body>
</html>