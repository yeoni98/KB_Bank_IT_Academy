<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 원래는 서블릿으로 작성해야 하는데...일단 서블릿이라고 치자... --%>
<!-- Attribute에 바인딩 되어있는 값을 받아오는 작성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이것은 원래 서블릿입니다.</h2>
<h2>Attribute 에 바인딩된 값 EL로 받아오기</h2>
<%
	int sum = 0;
	for(int cnt = 0; cnt<=50; cnt++) sum+= cnt;//5050
	
	//내장객체
	request.setAttribute("RESULT1", sum);
	session.setAttribute("RESULT2", "session");
	application.setAttribute("NAME", "KBSTAR");
	
	request.getRequestDispatcher("EL1_View.jsp").forward(request, response);
	
	
%>
</body>
</html></>