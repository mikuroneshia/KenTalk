<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="java.util.ArrayList,javaBeans.Account" %>
<%
ArrayList<ArrayList<String>>gtList=(ArrayList<ArrayList<String>>)request.getAttribute("gtList");
Account account=(Account)session.getAttribute("account");
String name=account.getName();
%>
<title>kenTalk/グループトーク</title>
</head>
<body>
<h1>グループトーク</h1>
<%for(ArrayList<String>list:gtList){%>
<%=list.get(0) %>> <%=list.get(1) %>  <%=list.get(2) %></br>
<%} %>
</br>
<form action="GroupTalk?name=<%=name %>" method="post">
<input type="text" name="sentense">
<input type="submit" value="送信">
<a href="MyPage">マイページへ</a>
</form>
</body>
</html>