<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成</title>
</head>
<body>
<h1>アカウントを作成します</h1>
<p>利用者のお名前とログインに利用するユーザーIDとパスワードを登録してください</p>
<%if(request.getAttribute("false")!=null){%>
	<p><font color="red">IDとパスワードは半角の英数字6～12文字で入力してください</font></p>
	<%}else{%>
<p>IDとパスワードは半角の英数字6～12文字で入力してください</p><%} %>
<form action="MakeAcount" method="post">
<table>
<tr>
<th>お名前</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>ユーザーID</th>
<td><input type="text" name="userID"></td>
</tr>
<tr>
<th>パスワード</th>
<td><input type="password" name="password"></td>
</tr>
</table>
<input type="submit" value="登録"><br>
</form>
<a href="toppage.jsp" ><button>戻る</button></a>

</body>
</html>