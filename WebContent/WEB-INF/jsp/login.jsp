<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kenTalk/ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<hr/>
<form action="/kenTalk/Login" method="post">
名前<input type="text" name="name"></br>
パスワード<input type="password" name="pass"></br>
<input type="submit" value="ログイン">
</form>
<a href="/kenTalk/SignUp">新規登録はこちら</a>
</body>
</html>