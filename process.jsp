<%@page import="java.util.*"%>
<%@page import="java.net.*"%>
<%@page import="java.io.BufferedReader"%>
<%@page import ="java.io.IOException" %>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%> 
<%@page import=" java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String centerid=request.getParameter("centerid");
String password=request.getParameter("password");
session.setAttribute("centerid",centerid); 
session.setAttribute("password",password);
String apiKey = "210895AHohvoQIfV5ad8a21d";
Random rand = new Random();
int otp = rand.nextInt(900000) + 100000;
String mobile="917351729908";//Here is the mobile number that of examiner of exam center,we have to getit from database
session.setAttribute("otp",otp);
String route="4";
String message="Your IEDS OTP is :"+otp;
String senderId="IEDSys";
 try{
URLConnection myURLConnection=null;
URL myURL=null;
BufferedReader reader=null;
//encoding message 
String encoded_message=URLEncoder.encode(message);
//Send SMS API
String mainUrl="http://api.msg91.com/api/sendhttp.php?";
//Prepare parameter string 
StringBuilder sbPostData= new StringBuilder(mainUrl);
sbPostData.append("authkey="+apiKey); 
sbPostData.append("&mobiles="+mobile); 
sbPostData.append("&message="+encoded_message);
sbPostData.append("&route="+route);
sbPostData.append("&sender="+senderId);
//final string
mainUrl = sbPostData.toString();
myURL = new URL(mainUrl);
myURLConnection = myURL.openConnection();
myURLConnection.connect();
reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
String success="Your message sent sucessfully";
response.sendRedirect("otp.jsp");
reader.close(); 
        }
        catch (Exception e){
            e.printStackTrace();
        }
%>
</body>
</html>