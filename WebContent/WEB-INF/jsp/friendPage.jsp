<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="javaBeans.Account,java.util.ArrayList" %>
<%
String friend=(String)request.getAttribute("friend");
System.out.println("friendPage.jsp:"+friend);
Account account=(Account)session.getAttribute("account");
String accountName=account.getName();
System.out.println("friendPage.jsp:"+accountName);
ArrayList<ArrayList<String>>sentenseList=
(ArrayList<ArrayList<String>>)request.getAttribute("sentenseList");
%>
<title>kenTalk/<%=friend %>のページ</title>
</head>
<body>
<a href="FriendAccount?friend=<%=friend %>">アカウント情報</a>
<h1>トーク</h1>
<a href="FriendPage?friend=<%=friend %>&accountName=<%=accountName%>">更新</br></a>
<% for(ArrayList<String>list:sentenseList){%>
<%=list.get(0) %>><%=list.get(1) %>   <%=list.get(2) %></br>
<%} %>
<form action="FriendPage" method="post">
<input type="text" name="sentense"></br>
<input type="hidden" name="accountName" value=<%=accountName %>>
<input type="hidden" name="friend" value=<%=friend %>>
<input type="submit">
</form>
<a href="MyPage">マイページへ</a>
</body>
</html>