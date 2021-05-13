<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String name=(String)request.getAttribute("name"); 
%>
<title>kenTalk/ログイン</title>
</head>
<body>
<h1>ようこそ、<%=name %>さん！</h1>
<a href="/kenTalk/MyPage">マイページへ</a>
<a href="/kenTalk/Login">ログイン画面へ</a>
</body>
</html>