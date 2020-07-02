<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="javax.servlet.http.HttpServlet"
    import="java.util.ArrayList"
    import="controller.DTO"
    import="java.text.SimpleDateFormat"
    %>
    <%HttpSession hs = request.getSession();
    if(request.getAttribute("check")!=null){
    	response.sendRedirect("toppage.jsp");
    }
    ArrayList<DTO> itemList = new ArrayList<DTO>((ArrayList<DTO>)hs.getAttribute("itemlist"));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理ページ</title>
</head>
<body>
<h1>在庫管理画面</h1>
<p>商品の追加</p>
<form action="AddItem" method="POST">
商品名<input type="text" name="name">
個数<input type="text" name="number">
<input type="submit" value="追加">
</form>
<p>商品一覧</p>

<table border="1">
<tr>
<th>商品ID</th><th>商品名</th><th>在庫</th><th>最終更新日時</th>
</tr>
<%for(DTO list : itemList){ %>
<tr>
<td><%=list.getID() %></td>

<td><a href="ItemUpdate?itemID=<%=list.getID()%>"><%=list.getName() %></a></td>
<td><%=list.getNumber() %></td>
<td><%=sdf.format(list.getUpdateTime()) %></td>
<td><a href="DeleteConfirm?itemID=<%=list.getID()%>">削除</a></td>
</tr>

<%} %>
</table>

<a href="Rogout">ログアウト</a>
</body>
</html>