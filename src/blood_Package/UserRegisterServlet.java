package blood_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_Blood_Package.Bank_Database;

/**
 * Servlet implementation class UserRegisterServlet
 */
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		doGet(request, response);
		String un=request.getParameter("un");
		String ue=request.getParameter("ue");
		String up=request.getParameter("up");
		String ua=request.getParameter("ua");		
		Long uc=Long.parseLong(request.getParameter("uc"));	
		String ubg=request.getParameter("bg");	
		try
		{
			Connection conn=Bank_Database.Connect();
			
			PreparedStatement ps1=conn.prepareStatement("insert into userbank values(?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,un);
			ps1.setString(3,ue);			
			ps1.setString(4,up);
			ps1.setString(5,ua);
			ps1.setLong(6,uc);			
			ps1.setString(7,ubg);

			
			int n= ps1.executeUpdate();
			System.out.println("Record inserted");
			
			if(n>=1)
			{
				//request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
				//response.sendRedirect("userlogin.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("userlogin.jsp");
	        	rd.include(request, response);
			}
			else
			{
				//request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
				//response.sendRedirect("register.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
	        	rd.include(request, response);
			}

		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}

	}

}
