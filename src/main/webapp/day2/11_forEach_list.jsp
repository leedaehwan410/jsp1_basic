<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_forEach_list</title>
</head>
<body>
   <!-- 7. 자바 객체 컬렉션(리스트) 활용하기-->
   <h5>자바 객체 컬렉션(리스트) 활용하기</h5>
   <%
      //jdbc로 sql 조회한 결과List에 활용합니다.
      List<CustomerVo> list = List.of( new CustomerVo("momo22","강모모","momo22@daum.net",29,null),
             new CustomerVo("momo22","강모모","momo22@daum.net",28,null),
             new CustomerVo("momo22","강모모","momo22@daum.net",27,null),
             new CustomerVo("momo22","강모모","momo22@daum.net",26,null),
             new CustomerVo("momo22","강모모","momo22@daum.net",25,null));
      
      pageContext.setAttribute("list", list);
   %>
   <!-- 컬렉션list에서 값을 하났기 가져와 애트리뷰트 이름 vo에저장하기 -->
   <c:forEach items="${list}" var="vo" varStatus="status">
      <c:out value="${status.index}"/>
      <c:out value="${vo}"/>
      <!-- varstatus 속성index는 지금처럼 items로 컬렉션 다룰 때 사용합니다 -->
      <ul>
         <li><c:out value="${vo.customId}"></c:out></li>
         <li><c:out value="${vo.name}"></c:out></li>
         <li><c:out value="${vo.email}"></c:out></li>
         <li><c:out value="${vo.age}"></c:out></li>
      </ul>
      
   
   </c:forEach>

</body>
</html>