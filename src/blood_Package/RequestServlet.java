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
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
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
		int rbid1=Integer.parseInt(request.getParameter("rbid"));
		String rbname1=request.getParameter("rbname");		
		try
		{

			Connection conn=Bank_Database.Connect();
			String UNAME5=GetSet.getuNAME();
			String UCONTACT5=GetSet.getuCONTACT();
			String UBLOOD5=GetSet.getuBLOOD();
			System.out.print(UBLOOD5);
			
			PreparedStatement ps1=conn.prepareStatement("insert into request values(?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,UNAME5);
			ps1.setString(3,UCONTACT5);
			ps1.setString(4,UBLOOD5);
			ps1.setInt(5,rbid1);
			ps1.setString(6,rbname1);
			
			int n= ps1.executeUpdate();
			System.out.println("Record inserted");
			
			if(n>=1)
			{
				//request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
				//response.sendRedirect("request.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("request.jsp");
	        	rd.include(request, response);
			}
			else
			{
				//request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
				//response.sendRedirect("request.jsp"); 
	        	response.setContentType("text/html");
	        	PrintWriter pw=response.getWriter();
	        	pw.println("<script type=\"text/javascript\">");
	        	pw.println("alert('Record Inserted Successfully..!!');");
	        	pw.println("</script>");
	        	RequestDispatcher rd=request.getRequestDispatcher("request.jsp");
	        	rd.include(request, response);
			}

		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}

}
