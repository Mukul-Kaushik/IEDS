<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="ISO-8859-1"%>
<%
String path =request.getContextPath() ;
String verified="";
verified+=(String)session.getAttribute("verified");
if(verified.equals("true")){
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String address="C:\\Users\\Mukul\\Videos\\work2\\.metadata\\.plugins\\com.genuitec.eclipse.easie.tomcat.myeclipse\\tomcat\\webapps\\ieds\\exams";//Address of the papers on server file system
File[] files = new File(address).listFiles();
 String filePath ="http://localhost:8080/ieds/exams";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Download exams</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center><h2><font color="red">Instant Examination Delivery System</font></h2>
    <table border="1" width="50%"><tr align="center" >
    <th>Active papers</th><th>Download links</th></tr>
    <%for (File file : files ){%>
    <tr align="center"><td><%=file.getName() %></td><td><a href="<%=filePath %>/<%=file.getName() %>"> Download</a></td><tr>
    <%} 
    }else {
   out.println("You are not authorised to access");
   } %>
    </tr></table>
  </body>
</html>
