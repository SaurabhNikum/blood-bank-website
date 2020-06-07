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
import db_Blood_Package.GetSet;

/**
 * Servlet implementation class AddBloodBankCampServlet
 */
public class AddBloodBankCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBloodBankCampServlet() {
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
		String place2=request.getParameter("place1");
		String nod2=request.getParameter("nod1");
		String sd2=request.getParameter("sd1");
		String ed2=request.getParameter("ed1");		
		try
		{
			Connection conn=Bank_Database.Connect();
			Integer bID=GetSet.getBID();
			PreparedStatement ps1=conn.prepareStatement("insert into campdata values(?,?,?,?,?,?)");
			ps1.setString(1,"0");
			ps1.setInt(2,bID);
			ps1.setString(3,place2);			
			ps1.setString(4,nod2);
			ps1.setString(5,sd2);
			ps1.setString(6,ed2);			
			
			int n= ps1.executeUpdate();
			System.out.println("Record inserted");
			
			if(n>=1)
			{

				//request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("addbloodbankcamp.jsp");
	        	rd.include(request, response);
				//response.sendRedirect("addbloodbankcamp.jsp"); 
			}
			else
			{
				//request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
				//response.sendRedirect("addbloodbankcamp.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Failed to Insert due t duplicacy..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("addbloodbankcamp.jsp");
	        	rd.include(request, response);

			}

		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}

	}

}
