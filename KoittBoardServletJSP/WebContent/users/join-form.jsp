<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>회원가입 페이지</title></head>
<body>
	<h1>회원가입 페이지</h1>
	
	<!-- HTTP Method 중 post 방식으로 UsersServlet에 정보를 전달 (쿼리문자열을 사용할 수 없음) -->
	<form action="<c:url value='/UsersServlet' />" method="post">	<!-- insert에 해당하는 HTTP Method는 post -->
		<input type="hidden" name="cmd" value="CMD_JOIN">
		<label>이메일 : <input type="email" name="email"></label><br>
		<label>비밀번호 : <input type="password" name="password"></label><br>
		<label>비밀번호확인 : <input type="password" name="password-confirm"></label><br>
		<label>이름 : <input type="text" name="name"></label><br>
		<input type="submit" value="회원가입하기">
	</form>
	
	<!--
		SQL문	HTTP Method
		SELECT	GET
		INSERT	POST
		UPDATE	PUT		html에서는 POST	-> javascript ajax에서 PUT을 사용
		DELETE	DELETE	html에서는 POST -> javascript ajax에서 DELETE을 사용
	-->
</body>
</html>
