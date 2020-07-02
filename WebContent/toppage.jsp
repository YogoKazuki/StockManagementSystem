<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="javax.servlet.http.HttpServlet" %>
    <%HttpSession hs = request.getSession();
    hs.setAttribute("check","no");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1 align="center">ログイン画面</h1>
<div align="center">
<%if(request.getAttribute("roginfalse")!=null){ %>
<p ><font color="red">ログインに失敗しました<br>IDかパスワードが間違っています</font></p><%} %>
<form action="Rogincheck" method="post">
<table>
<tr>
<th>ユーザーID</th>
<td><input type="text" name="userID"></td>
</tr>

<tr>
<th>パスワード</th>
<td><input type="password" name="password"></td>
</tr>
</table>
<input type="submit" value="ログイン">
</form>
<a href="makeacount.jsp"><button>アカウント作成</button></a>
</div>


</body>
</html>