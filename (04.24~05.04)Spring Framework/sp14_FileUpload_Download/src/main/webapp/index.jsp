<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
���� ���ε� �ۼ��� �����ؾ� �� ��Ģ
1. method="post" �� ������!!
2. enctype="miltipart/form-data"
3. input type = "file"
4. pom.xml :: commons-fileupload ���̺귯�� �߰�
5. !!! �߿�.. ��������
6.

 -->
</head>
<body>
<h2 align="center">File Upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
     ����� ��<input type="text" name = "userName">
     <input type ="file" name ="uploadFile">
     <input type = "submit" value="���� ���ε�">

</form>
</body>
</html>