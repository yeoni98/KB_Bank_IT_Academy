<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!--  jstl �� ����ϱ� ���ؼ��� 
1. jar���� 2���� �ʿ��ϴ�.
2. taglib�� �����ؼ� ����ؾ� �Ѵ�.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>If���� jstl</title>
</head>
<body>
<h2>jstl if.. ���</h2>
<c:if test="${param.NUM}=='100'">
<B>������ 100������ �Ա� �Ǿ����ϴ�.</B><BR></c:if>
<c:if test="${param.NUM}=='200'">
<B>������ 200������ �Ա� �Ǿ����ϴ�.</B><BR></c:if>

</body>
</html>