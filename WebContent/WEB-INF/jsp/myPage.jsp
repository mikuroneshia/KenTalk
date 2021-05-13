<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="javaBeans.Account" %>
<%
Account account=(Account)session.getAttribute("account");
%>
<title>kenTalk/マイページ</title>
</head>
<body>
<%=account.getName() %>さんの部屋</br>
<a href="/kenTalk/MyAccount">アカウント</a></br>
<a href="/kenTalk/MyFriend?page=myPage">友達一覧</a></br>
<a href="OthelloMainMenu">オセロ</a></br>
<a href="GroupTalk">グループトーク</a></br>
<a href="Login">ログアウト</a>
</body>
</html>