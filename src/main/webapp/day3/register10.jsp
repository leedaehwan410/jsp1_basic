<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/customers.css">
</head>
<body>

<h3>고객 등록</h3>

	<hr>
	<form >
	<input type="text" name="customId" placeholder="고객아이디를 입력하세요." required>
	<input type="text" name="name" placeholder="이름을 입력하세요." required>
	<input type="email" name="email" placeholder="이메일을 입력하세요." required>
	<input type="text" name="age" placeholder="나이를 입력하세요." required>
	<button type="button" onclick="join()">고객 등록 완료</button> 
	
	</form>
</body>
</html>