<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<body><center><h2> Instant Examination Delivery System</h2>
<form method="post" action="process.jsp">CenterId:<br>
<input type="text" name="centerid">
<br> 
Password:<br>
<input type="password" name="password">
<br>
<input type="submit" name="save" value="submit">
</form></center>
</body>
</html>