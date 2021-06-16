<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/othello.css">
<meta charset="UTF-8">
<%@ page import="othello.OthelloJSP" %>
<%
	OthelloJSP othello=(OthelloJSP)session.getAttribute("othello");
int[][] banmen=othello.getBanmen();
int turn=othello.getTurn();
String resultStr=(String)request.getAttribute("result");
int gyo=10;
int retu=10;
int turnCount=othello.getTurnCount();
boolean result=othello.getResult();
String player1="";
String player2="";
if(othello.getComputer1()){
player1="黒:computer1 Lv." + othello.getCom1Lv();
} else {
player1 = "黒:player1";
}
if(othello.getComputer2()){
player2="白:computer2 Lv." + othello.getCom2Lv();
} else {
player2 = "白:player2";
}
String player = (String) request.getAttribute("player");
if (request.getAttribute("gyo") != null && request.getAttribute("retu") != null) {
		gyo = (Integer) request.getAttribute("gyo");
		retu = (Integer) request.getAttribute("retu");
	}
%>
<%
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
			%>
			<%if(gyo==i&&retu==j){%>
				<style>
			 .masu<%=i%><%=j%>{
				width:58px;
				height:58px;
				border:1px solid;
				color:red;
				display: inline-block;
			}
			</style>
			<%}else{%>
			<style>
			 .masu<%=i%><%=j%>{
				width:58px;
				height:58px;
				border:1px solid;
				color:black;
				display: inline-block;
			}
			</style>
			<%} %>
			<%
				}
			}
			%>

<title>kenTalk/オセロ</title>
<%if(request.getAttribute("com")!=null&&resultStr==null){ %>
<meta http-equiv="Refresh" content="1;URL=Othello">
<%} %>
</head>
<body>
	<div class="banmen">
		<%
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
			%>
		<a href="Othello?masu=<%=i %><%=j%>" class="masu<%=i%><%=j%>"> <%if(banmen[i][j]==1){ %>
			<div class="kuro"></div> <% }else if(banmen[i][j]==2){%>
			<div class="siro"></div> <% }%>
		</a>
		<%
				}
			}
			%>
	</div>
	<div class="player">
		<h2><%=player1%></h2>
		<h2><%=player2%></h2>
	</div>
	<div class="info">
		<%
			if (resultStr != null) {
		%>
		<h2><%=resultStr%></h2>
		<%}else if(turn==1){ %>
		<h2><%=turnCount %>ターン</h2>
		<h2>黒のターンです</h2>
		<%}else if(turn==2){ %>
		<h2><%=turnCount %>ターン</h2>
		<h2>白のターンです</h2>
		<%} %>
		<%if(othello.getReverseCount()==0) {%>
		<h2>石を返せるところに置いてください</h2>
		<%} %>
		<%if(result){ %>
		<a href="Othello?record=back">戻る</a>
		<a href="Othello?record=forward">進む</a>
		<%} %>
	</div>
	<div class="link">
		<a href="Othello?pass=pass">パス</br></a>
	    <a href="OthelloMainMenu">オセロメインメニューへ</br></a>
	    <a href="MyPage">マイページへ</br></a>
	</div>

</body>
</html>