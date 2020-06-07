package db_Blood_Package;
import java.sql.*;
public class Bank_Database 
{

		static Connection con=null;
		public static Connection Connect()
		{
			try
			{
				if(con==null)
				{
					Class.forName("com.mysql.jdbc.Driver");  	  
					System.out.println("Drivers Loaded");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sabkabloodbank","root","");  
					System.out.println("Connection Established");
				}
			}
			catch(Exception ae)
			{
				System.out.println(ae);
			}
			return con; 	
		}

}



