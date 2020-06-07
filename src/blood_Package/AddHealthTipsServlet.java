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
 * Servlet implementation class AddHealthTipsServlet
 */
public class AddHealthTipsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHealthTipsServlet() {
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
		String healthtips=request.getParameter("htips");

		try
		{
			Connection conn=Bank_Database.Connect();
			
			PreparedStatement ps1=conn.prepareStatement("insert into healthtips values(?,?)");
			ps1.setString(1,"0");
			ps1.setString(2,healthtips);

			
			int n= ps1.executeUpdate();
			System.out.println("Record inserted");
			
			if(n>=1)
			{
				//request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
				//response.sendRedirect("healthtips.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("healthtips.jsp");
	        	rd.include(request, response);
			}
			else
			{
				//request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
				//response.sendRedirect("healthtips.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("healthtips.jsp");
	        	rd.include(request, response);
			}

		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}

}
