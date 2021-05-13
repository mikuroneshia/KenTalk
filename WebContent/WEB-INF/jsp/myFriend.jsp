<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="java.util.ArrayList,javaBeans.Account" %>
<%
ArrayList<String> friends=(ArrayList<String>)request.getAttribute("friends");
Account account=(Account)session.getAttribute("account");
String accountName=account.getName();
System.out.println("myFriend.jsp:accountName:"+accountName);
%>
<title>kenTalk/友達一覧</title>
</head>
<body>
<form>
<%
for(String friend:friends){
	if(!friend.equals(accountName)){
%>
<a href="/kenTalk/FriendPage?accountName=<%=accountName %>&friend=<%= friend%>&page=myFriend"><%=friend %></br></a>
<%}
} %>
<a href="MyPage">マイページへ</a>
</form>
</body>
</html>