<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kenTalk/新規登録</title>
</head>
<body>
<form action="/kenTalk/SignUp" method="post">
名前<input type="text" name="name"></br>
年齢(半角数字)<input type="text" name="age"></br>
出身地<input type="text" name="birthplace"></br>
誕生日 (例:2021-02-22)<input type="text" name="birthday"></br>
パスワード<input type="password" name="pass">
<input type="submit" value="送信">
</form>
</body>
</html>