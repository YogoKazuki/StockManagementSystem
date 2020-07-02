<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウントを作成しました</title>
</head>
<body>
<h1>アカウントの作成が完了いたしました</h1>
<p><%=request.getAttribute("name") %>様のアカウントが作成されました</p>
<a href="toppage.jsp">トップへ戻る</a>
</body>
</html>