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
<h2>c:choose���� ����ϱ�</h2>
<c:choose>
   <c:when test ="${param.NUM=='100'}">
   <B>����, 100���� �Ա� �ϼ̽��ϴ�.</B>
   </c:when>
<c:when test ="${param.NUM=='200'}">
   <B>����, 200���� �Ա� �ϼ̽��ϴ�.</B>
   </c:when>
   <c:otherwise>
   <B>���� �Աݾ� �ٽ� Ȯ�����ּ���.</B>
   </c:otherwise>
</c:choose>
</body>
</html>