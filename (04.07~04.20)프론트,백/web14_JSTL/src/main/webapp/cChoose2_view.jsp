<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>c:choose문법 사용하기</h2>
<c:choose>
   <c:when test ="${param.NUM=='100'}">
   <B>고객님, 100만원 입금 하셨습니다.</B>
   </c:when>
<c:when test ="${param.NUM=='200'}">
   <B>고객님, 200만원 입금 하셨습니다.</B>
   </c:when>
   <c:otherwise>
   <B>고객님 입금액 다시 확인해주세요.</B>
   </c:otherwise>
</c:choose>
</body>
</html>