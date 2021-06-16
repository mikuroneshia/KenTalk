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
名前 <%=account.getName() %></br>
年齢 <%=account.getAge() %></br>
出身地 <%=account.getBirthplace() %></br>
生年月日 <%=account.getBirthday() %></br>
趣味 <%=account.getHobby() %></br>
<a href="EditAccount">アカウント編集</a><br/>
<a href="MyPage">マイページへ</a>
</body>
</html>