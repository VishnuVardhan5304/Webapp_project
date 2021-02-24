

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


@WebServlet("/Phno_Edit")
public class Phno_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Phno_Edit() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Scanner sc= new Scanner(System.in);
			int id=Integer.parseInt(request.getParameter("id"));
			String newphno=request.getParameter("newphno");
			
			//pw.println("Id : "+id);
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root", "root");
			PreparedStatement stmt=con.prepareStatement("update employee set phno = ? where id = ?");
			stmt.setString(1,newphno);
			stmt.setInt(2,id);
			
			try {
				int i=stmt.executeUpdate();
				if(i!=0)
					pw.println("<a href=\"admin.html\"> Phone No is Updated  !!, Please Go to Admin Page</a>");
				else
					pw.println("<a href=\"admin.html\"> Employee Record is not Found !!, Please Go to Admin Page</a>");
			}
			catch(Exception e)
			{
				pw.println("<a href=\"admin.html\"> Employee Record is not  Updated !!, Please Go to Admin Page</a>");
			}
			
		}
		catch(Exception e)
		{
			pw.println("<a href=\"admin.html\"> Error in data base connection , Please Go to Admin Page</a>");
		}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
