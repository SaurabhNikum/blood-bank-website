package blood_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		if(email.equals("admin@gmail.com") && pass.equals("admin"))
		{
			//response.sendRedirect("addbloodbank.jsp");
        	response.setContentType("text/html");
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('Invalid Password or Email..!!');");
        	pw.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("addbloodbank.jsp");
        	rd.include(request, response);
		}
		else
		{
			//request.getSession().setAttribute("msg", "Wrong User Credentials..!!");
			//response.sendRedirect("index.jsp");
        	response.setContentType("text/html");
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('Successfully Loggeed in!!');");
        	pw.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        	rd.include(request, response);
		}
	}

}
