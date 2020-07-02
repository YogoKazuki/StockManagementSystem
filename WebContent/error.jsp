<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="javax.servlet.http.HttpSession"
    %>
    <%HttpSession hs = request.getSession(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>

       <%if(hs.getAttribute("check")==null||hs.getAttribute("check")=="no") {%>
        不正なアクセスです。<br>

         <%}else{%>
         エラーが発生しました。以下の項目を確認してください。<br>
         <%=request.getAttribute("error")%><br><br>
		<%} %>
		<%if(hs.getAttribute("check")=="ok"){ %>
		<a href="Rogincheck">在庫一覧画面へ戻る</a><br><%} %>
        <a href="toppage.jsp">トップ画面へ戻る。</a>
</body>
</html>