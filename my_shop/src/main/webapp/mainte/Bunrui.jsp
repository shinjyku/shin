<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="common.*"%>
<%
List<String> names = (ArrayList<String>)request.getAttribute("cols");
List<ArrayList<String>> datas = (List<ArrayList<String>>)request.getAttribute("datas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="<%=request.getContextPath() %>/js/script.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>Bunrui.jsp</title>
</head>
<body>
<h1>分類デーブル</h1>

<form action="/my_shop/Bunrui" method="post" id="form1">
<input type="submit" name="search" id="search" value="表示"> 
<input type="text" name="code" id="code" value=""> 
</form>

<table border="1">
<tr>
<%
if(names != null){
for( String name : names ) {
%>

<th><%= name %></th>

<% } } %>
</tr>

<%
if(datas != null){
for( ArrayList<String> data : datas ) {
%>
<tr>
<td><%= data.get(0) %></td>
<td><%= data.get(1) %></td>
<td><%= data.get(2) %></td>
<td><%= data.get(3) %></td>
</tr>
<% } } %>
</table>

<form action="/my_shop/Bunrui" method="post" id="form2">
<table border="1">

<tr>
<th>コード</th>
<td>
<input type="text" name="bcode" value="">
</td>
</tr>
<tr>
<th>名称</th>
<td>
<input type="text" name="bname" value="">
</td>
</tr>
<tr>
<th>削除</th>
<td>
<input type="text" name="delflg" value="">
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="insert" id="insert" value="登録"> 
</td>
</tr>
<tr>
<td colspan="2">
<input type="text" name="err" id="err" value="" size="100" readonly="readonly"> 
</td>
</tr>

</table>

</form>

<hr>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>