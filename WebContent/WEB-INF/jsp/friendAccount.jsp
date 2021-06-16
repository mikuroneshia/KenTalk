<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="javaBeans.Account" %>
<%
Account friend=(Account)session.getAttribute("friendAccount");
String name=friend.getName();
int age=friend.getAge();
String birthday=friend.getBirthday();
String birthplace=friend.getBirthplace();
String hobby=friend.getHobby();
Account account=(Account)session.getAttribute("account");
String accountName=account.getName();
%>
<title>kenTalk/アカウント情報</title>
</head>
<body>
名前:<%=name %></br>
年齢:<%=age %></br>
出身地:<%=birthplace %></br>
生年月日:<%=birthday %></br>
趣味:<%=hobby %></br>
<a href="FriendPage?friend=<%=name %>&accountName=<%=accountName%>">フレンドのページへ</a>
</body>
</html>