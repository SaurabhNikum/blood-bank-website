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

/**
 * Servlet implementation class AddBloodBankServlet
 */
public class AddBloodBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBloodBankServlet() {
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
		String bname=request.getParameter("bname1");
		String blocation=request.getParameter("blocation1");
		Long bcontact=Long.parseLong(request.getParameter("bcontact1"));
		String bemail=request.getParameter("bemail");
		String bpass=request.getParameter("bpassword");		
		try
		{
			Connection conn=Bank_Database.Connect();
			
			PreparedStatement ps1=conn.prepareStatement("insert into bloodbank values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps1.setString(1,"0");
			ps1.setString(2,bname);
			ps1.setString(3,blocation);			
			ps1.setLong(4,bcontact);
			ps1.setString(5,bemail);
			ps1.setString(6,bpass);			
			ps1.setString(7,"0");
			ps1.setString(8,"0");			
			ps1.setString(9,"0");
			ps1.setString(10,"0");
			ps1.setString(11,"0");
			ps1.setString(12,"0");
			ps1.setString(13,"0");
			ps1.setString(14,"0");
			
			int n= ps1.executeUpdate();
			System.out.println("Record inserted");
			
			if(n>=1)
			{
				//request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
				//response.sendRedirect("addbloodbank.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("addbloodbank.jsp");
	        	rd.include(request, response);
			}
			else
			{
				//request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
				//response.sendRedirect("addbloodbank.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Failed to Insert due to duplicacy..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("addbloodbank.jsp");
	        	rd.include(request, response);
			}

		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}

	}

}
