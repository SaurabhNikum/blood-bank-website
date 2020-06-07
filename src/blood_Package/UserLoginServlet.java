package blood_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_Blood_Package.Bank_Database;
import db_Blood_Package.GetSet;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("email");
		String password=request.getParameter("password");
		try
		{
			Connection con=Bank_Database.Connect();
			PreparedStatement pstmt = con.prepareStatement("select * from userbank where uemail = ? and upass = ?");
	      	pstmt.setString(1,username);
	      	pstmt.setString(2,password);
	      	ResultSet rs = pstmt.executeQuery();	
	      	if(rs.next())
	      	{	      		
	      	int i=rs.getInt(1);
		    GetSet.setuID(i);
		    GetSet.setuNAME(rs.getString("uname"));
		    GetSet.setuCONTACT(rs.getString("ucontact"));
		    GetSet.setuBLOOD(rs.getString("ubloodgroup"));
        	response.setContentType("text/html");
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('Valid Username or Password');");
        	pw.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("viewcamp2.jsp");
        	rd.include(request, response);
        	//response.sendRedirect("Welcome.html");
        	//a=1;
	      	}
	      	else
	      	{
        	response.setContentType("text/html");
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('Invalid Username or Password');");
        	pw.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        	rd.include(request, response);
          	//response.sendRedirect("Login.html");
        	}
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
	}

}
