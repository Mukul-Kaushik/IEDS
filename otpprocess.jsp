<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
String centerid=(String)session.getAttribute("centerid");
String password=(String)session.getAttribute("password");
int otp= (Integer) session.getAttribute("otp");
String otpvalue=request.getParameter("otpvalue");
int enterOtp=Integer.parseInt(otpvalue);
if(otp==enterOtp){
String verified="true";
session.setAttribute("verified",verified);
response.sendRedirect("current_exams.jsp");
}
else
{
out.println("OTP not matched");
}
%>