package blood_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_Blood_Package.Bank_Database;
import db_Blood_Package.GetSet;

/**
 * Servlet implementation class BloodBankUpdate
 */
public class BloodBankUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodBankUpdate() {
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
		String bloodbank=request.getParameter("bloodbank");
		int apos1=Integer.parseInt(request.getParameter("apos1"));
		int aneg1=Integer.parseInt(request.getParameter("aneg1"));
		int bpos1=Integer.parseInt(request.getParameter("bpos1"));
		int bneg1=Integer.parseInt(request.getParameter("bneg1"));
		int abpos1=Integer.parseInt(request.getParameter("abpos1"));
		int abneg1=Integer.parseInt(request.getParameter("abneg1"));
		int opos1=Integer.parseInt(request.getParameter("opos1"));
		int oneg1=Integer.parseInt(request.getParameter("oneg1"));

      //	System.out.println("Account No. : "+accountnumber);
		try
		{
			Connection con=Bank_Database.Connect();
	      	System.out.println("In try block...!");
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bloodbank where bname= '"+bloodbank+"' ");
    		System.out.println("Query check....!");
	      	if(rs.next())
	      	{
	      		int ap=rs.getInt(7);
	      		apos1=apos1+ap;
	      		int an=rs.getInt(8);
	      		aneg1=aneg1+an;
	      		int bp=rs.getInt(9);
	      		bpos1=bpos1+bp;
	      		int bn=rs.getInt(10);
	      		bneg1=bneg1+bn;
	      		int abp=rs.getInt(11);
	      		abpos1=abpos1+abp;
	      		int abn=rs.getInt(12);
	      		abneg1=abneg1+abn;
	      		int op=rs.getInt(13);
	      		opos1=opos1+op;
	      		int on=rs.getInt(14);
	      		oneg1=oneg1+on;
	      	System.out.println("Inside first if");
    	try
    	{
    	System.out.println("\n deposit code to update");
		PreparedStatement pstmt1 = con.prepareStatement("update bloodbank set apos=? ,aneg=?, bpos=?,bneg=?,abpos=?,abneg=?, opos=?, oneg=? where bname= '"+bloodbank+"'");
      	pstmt1.setInt(1,apos1); 
     	pstmt1.setInt(2,aneg1);
     	pstmt1.setInt(3,bpos1);
     	pstmt1.setInt(4,bneg1);
     	pstmt1.setInt(5,abpos1);
     	pstmt1.setInt(6,abneg1);
     	pstmt1.setInt(7,opos1);
     	pstmt1.setInt(8,oneg1);
        int i = pstmt1.executeUpdate();
        if(i>0)
      	{
    		System.out.println("Inside second if for success");
        	response.setContentType("text/html");
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('Blood Stock Updated');");
        	pw.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("updatestock.jsp");
        	rd.include(request, response);	
        	pw.close();
      	}
    	}
		catch(Exception ae)
		{
			System.out.println(ae);
			ae.printStackTrace();
		}
    	}
      	
    	else
    	{
    		System.out.println("Inside else 2 for confirm");
        	//response.setContentType("text/html");
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('Blood Bank Name Not Found');");
        	pw.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("updatestock.html");
        	rd.include(request, response);
        	pw.close();
          	//response.sendRedirect("Login.html");
    		
    	}
		}
		catch(Exception ae)
		{
			System.out.println(ae);
			ae.printStackTrace();
		}
		
	}

}
