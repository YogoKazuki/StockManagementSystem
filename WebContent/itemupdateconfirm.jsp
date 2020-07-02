<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "controller.DTO"
    import="javax.servlet.http.*" %>
    <%DTO dto = new DTO();
    	HttpSession hs = request.getSession();
		dto = (DTO)hs.getAttribute("oneitem");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
<h1>変更します、よろしければ確定を押してください。</h1>
ID:<%=dto.getID() %><br>
名前:<%=dto.getName() %><br>
個数:<%=dto.getNumber() %><br>
<form action="UpdateResult" method="post">
<input type="submit" value="確定">
</form>
<form action="itemupdate.jsp" method="post">
<input type="hidden" name="return" value="return">
<input type="submit" value="編集画面へ戻る">
</form>

</body>
</html>