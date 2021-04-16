<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<h1>회원가입 페이지 ${fMsg}</h1>
<!--  get : 크기제한 있음. url?param1=aaa&param2=bbb -->
<!-- post : 크기제한 없음. url에 정보 표시 X, 
            form이나 ajax만으로 전송 가능 -->           
<form action="memberjoin" method="post">
	아이디 <input type="text" name="mbId" id="mbId" required/>
	<div id="result"><!-- 중복체크 결과 출력 --></div>
	<br>
	
	비밀번호 <input type="text" name="mbPwd" required/><br>
	이름 <input type="text" name="mbName" required/><br>
	전화번호 <input type="text" name="mbTel" required/><br>
	생년월일 <input type="date" name="mbBirth" required/><br>
	주소 <input type="text" name="mbAddr" required/><br>
	닉네임 <input type="text" name="mbNickName" required/><br>
	성별 
	<input type="radio" name="mbGender" value="m" checked/> 남
	<input type="radio" name="mbGender" value="w"/> 여 <br>
	회원타입
	<input type="radio" name="mbType" value="1" checked/> 학생
	<input type="radio" name="mbType" value="2"/> 강사 <br>
	<input type="submit" value="회원가입">
</form>


<script>
	$(function(){
		$('#mbId').on('focusout',function(){
			let mbIdval = $('#mbId').val(); // 입력값 가져오기
			if(mbIdval==''){ 
				$('#result').text('아이디를 입력하세요');
			}else{
				$.ajax({
					url : 'checkemail',
					data : {mbId: mbIdval}, // {이름 : 값}
					dataType : 'json',
					method : 'get' // get일 경우 생략 가능
				}).done(function(data){
					$('#result').text(data.msg);
				}).fail(function(err){
					$('#result').text('서버 통신 실패');
				});
			}
		}); // on End
		
	}); // ready End
</script>
</body>
</html>