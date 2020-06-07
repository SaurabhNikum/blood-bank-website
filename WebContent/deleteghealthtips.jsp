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
String id2=request.getParameter("id");
java.sql.PreparedStatement ps=conn.prepareStatement("delete from healthtips where hid=?");
ps.setString(1,id2);
int i=ps.executeUpdate();
if(i==1)
{
	//response.sendRedirect("viewhealthtips.jsp");
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("<script type=\"text/javascript\">");
	pw.println("alert('Record deleted Successfully..!!');");
	pw.println("</script>");
	RequestDispatcher rd=request.getRequestDispatcher("viewhealthtips.jsp");
	rd.include(request, response);
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>