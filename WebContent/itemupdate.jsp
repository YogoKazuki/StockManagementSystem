<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "controller.DTO"
    import="javax.servlet.http.*"%>
    <%DTO dto = new DTO();
		if(request.getParameter("return")!=null){
			HttpSession hs = request.getSession();
			dto = (DTO)hs.getAttribute("oneitem");
		}else{
			dto = (DTO)request.getAttribute("oneitem");
		}
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データの変更</title>
</head>
<body>
<h1>こちらでデータの変更が可能です。</h1>
<form action="ItemUpdateConfirm" method="post">
ID:<%=dto.getID() %><br>
<input type="hidden" name="ID" value="<%=dto.getID() %>">
名前:<input type="text" name="name" value="<%=dto.getName()%>"><br>
個数:<input type="text" name="number"value="<%=dto.getNumber()%>"><br>
<input type="submit" value="確認画面へ">
</form>
<form action="Rogincheck" method="post">
<input type="submit" value="製品一覧へ戻る">
</form>

</body>
</html>