<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="db_Blood_Package.*"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="javax.servlet.RequestDispatcher"%>

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
Statement statement = null;
ResultSet resultSet = null;
%>

<%
try{
Connection conn=Bank_Database.Connect();
statement=conn.createStatement();
String id1=request.getParameter("id10");
int bID=GetSet.getBID();
java.sql.PreparedStatement ps1=conn.prepareStatement("select * from bloodbank where bid='"+bID+"'");
resultSet=ps1.executeQuery();
resultSet.next();
String uBLOOD6=GetSet.getuBLOOD();
System.out.println("uBLOOD6"+uBLOOD6);
int result=resultSet.getInt(uBLOOD6);
System.out.println("RESULT"+result);
result=result-1;
String compare="update bloodbank set " + uBLOOD6 + "= " + result + " where bid=" + bID +";";
System.out.println("Compare"+compare);

java.sql.PreparedStatement ps2=conn.prepareStatement(compare);
ps2.executeUpdate();

java.sql.PreparedStatement ps=conn.prepareStatement("delete from request where rid=?");
ps.setString(1,id1);
int i=ps.executeUpdate();
if(i==1)
{

	System.out.println("It is to delete the request");
	//response.sendRedirect("viewrequest.jsp");
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("<script type=\"text/javascript\">");
	pw.println("alert('Record deleted Successfully..!!');");
	pw.println("</script>");
	RequestDispatcher rd=request.getRequestDispatcher("viewrequest.jsp");
	rd.include(request, response);
}
} catch (Exception e) {
e.printStackTrace();
}
try{
Connection conn=Bank_Database.Connect();
statement=conn.createStatement();
String id11=request.getParameter("idid");
java.sql.PreparedStatement ps=conn.prepareStatement("delete from request where rid=?");
ps.setString(1,id11);
int i=ps.executeUpdate();
if(i==1)
{
	System.out.println("It is to disapprove the request");
	//response.sendRedirect("viewrequest.jsp");
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("<script type=\"text/javascript\">");
	pw.println("alert('Record deleted Successfully..!!');");
	pw.println("</script>");
	RequestDispatcher rd=request.getRequestDispatcher("viewrequest.jsp");
	rd.include(request, response);
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>