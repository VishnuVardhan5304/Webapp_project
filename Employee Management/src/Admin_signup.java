

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin_signup")
public class Admin_signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Admin_signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String uname=request.getParameter("uname");
		String password = request.getParameter("pswd1");
		PrintWriter pw = response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root", "root");
			
			PreparedStatement stmt=con.prepareStatement("insert into admin (name,username,password) values (?,?,?)");
			
				//pw.println("Connection not established");
			stmt.setString(1,name);
			stmt.setString(2,uname);
			stmt.setString(3,password);
			try {
				int i=stmt.executeUpdate();
				pw.println("<a href=\"home.html\"> Admin Record is Inserted !!, Please Go to Home Page</a>");
			}
			catch(Exception e)
			{
				pw.println("<a href=\"home.html\"> Admin Record is not Inserted !!, Please Go to Home Page</a>");
			}
			
		}
		catch(Exception e)
		{
			pw.println("<a href=\"home.html\"> Error in data base connection , Please Go to Home Page</a>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
