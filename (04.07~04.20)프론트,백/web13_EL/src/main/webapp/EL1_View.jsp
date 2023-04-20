<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 원래는 서블릿으로 작성해야 하는데...일단 서블릿이라고 치자... --%>
<!-- Attribute에 바인딩 되어있는 값을 받아오는 작성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element 로 받아오기</b><br>
<%= request.getAttribute("RESULT1") %><br>
<%= session.getAttribute("RESULT2") %><br>

<hr>
<b>2. JSP EL로 받아오기</b><br>
1. ${RESULT1}<br>
2. ${RESULT2}<br>
3. ${RESULT1+10000}<br>

</body>
</html>