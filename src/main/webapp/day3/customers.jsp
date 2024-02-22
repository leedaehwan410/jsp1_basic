<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1</title>
<!-- css파일 위치는 context path /jsp1/ (webapp 폴더)기준으로 합니다. -->
<link rel="stylesheet" href="assets/css/customers.css">
</head>
<body>
	<h3>고객전체조회</h3>
	<hr>
	<ul>
	<!-- list 이름의 애트리뷰를 대상으로 합니다. : 애트리뷰트 저장은 서블릿에서 합니다. -->
	<c:forEach items="${list }" var ="vo" varStatus="status" >
		<li>
		<ul class="row">
			<li><c:out value="${status.index + 1}" /></li>
			<li><c:out value="${vo.customId}" /></li>
			<li><c:out value="${vo.name }" /></li>
			<li><c:out value="${vo.email }" /></li>
			<li><c:out value="${vo.age }" /></li>
	<li><fmt:formatDate value="${vo.reg_date }" 
	pattern="yyyy-MM-dd HH:mm:ss"/> </li> 
		</ul>
		</li>
</c:forEach>
	</ul>
</body>
</html>