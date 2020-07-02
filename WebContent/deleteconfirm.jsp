<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="javax.servlet.http.HttpSession"
    import="controller.DTO"%>
    <%HttpSession hs = request.getSession();
    DTO dto = new DTO();
    dto = (DTO)hs.getAttribute("deleteitem");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
<h1>こちらのデータを削除します、よろしければ確定をクリックしてください。</h1>
ID:<%=dto.getID() %><br>
名前:<%=dto.getName() %><br>
個数:<%=dto.getNumber() %><br>
<form action="Delete" method="post">
<input type="submit" value="確定">
</form>
<a href="Rogincheck"><button >製品一覧へ戻る</button></a>
</body>
</html>