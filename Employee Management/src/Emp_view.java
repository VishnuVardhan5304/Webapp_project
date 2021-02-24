

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Emp_view")
public class Emp_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Emp_view() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 
	        try
	        {
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root", "root");
				PreparedStatement stmt=con.prepareStatement("select * from employee where id = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();

				/*if(rs==null)
				{
					pw.println("<a href=\"admin.html\">Employee Record is not Found !!, Please Go to Admin Page</a>");
				}
				pw.println("<html><style>table, th, td {\r\n"
						+ "  border: 1px solid black;\r\n"
						+ "  border-collapse: collapse;\r\n"
						+ "}\r\n"
						+ "th, td {\r\n"
						+ "  padding: 15px;\r\n"
						+ "}</style><body><table><tr> <td align=\"position\"valign=\"position\">Name</td> <td align=\"position\"valign=\"position\">Id</td> <td align=\"position\"valign=\"position\">Job</td> <td align=\"position\"valign=\"position\">Salary</td> <td align=\"position\"valign=\"position\">Phone No</td> </tr>");
				while(rs.next())
				{
					pw.println("<tr><td align=\"position\"valign=\"position\">"+rs.getString(1)+"</td><td align=\"position\"valign=\"position\">"+rs.getInt(2)+"</td><td align=\"position\"valign=\"position\">"+rs.getString(3)+"</td><td align=\"position\"valign=\"position\">"+rs.getString(4)+"</td><td align=\"position\"valign=\"position\">"+rs.getString(5)+"</td></tr>");
				}*/
				if (!rs.next() ) {
				
					//pw.println("<a href=\"admin.html\">Employee Record is not Found !!, Please Go to Admin Page</a>");
					response.sendRedirect("admin.html");
				} else {
					pw.println("<html><style>table, th, td {\r\n"
							+ "  border: 1px solid black;\r\n"
							+ "  border-collapse: collapse;\r\n"
							+ "}\r\n"
							+ "th, td {\r\n"
							+ "  padding: 15px;\r\n"
							+ "}</style><body><table><tr> <td align=\"position\"valign=\"position\">Name</td> <td align=\"position\"valign=\"position\">Id</td> <td align=\"position\"valign=\"position\">Job</td> <td align=\"position\"valign=\"position\">Salary</td> <td align=\"position\"valign=\"position\">Phone No</td> </tr>");

				    do {
				    	pw.println("<tr><td align=\"position\"valign=\"position\">"+rs.getString(1)+"</td><td align=\"position\"valign=\"position\">"+rs.getInt(2)+"</td><td align=\"position\"valign=\"position\">"+rs.getString(3)+"</td><td align=\"position\"valign=\"position\">"+rs.getString(4)+"</td><td align=\"position\"valign=\"position\">"+rs.getString(5)+"</td></tr>");
				    } while (rs.next());
				}
				pw.println("<br><br>");
				pw.println("<a href=\"admin.html\"> Employee Record is Viewed !!, Please Go to Admin Page</a><br><br>");
				
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
