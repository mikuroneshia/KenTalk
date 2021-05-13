<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="javaBeans.Account" %>
<%Account account=(Account)session.getAttribute("account"); %>
<title>kenTalk/アカウント情報</title>
</head>
<body>
<h1>アカウント情報</h1>
name <%=account.getName() %></br>
age <%=account.getAge() %></br>
birthplace <%=account.getBirthplace() %></br>
birthday <%=account.getBirthday() %></br>
hobby <%=account.getHobby() %></br>
<a href="EditAccount">アカウント編集</a>
</body>
</html>