
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uEmail=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		Connection connect = null;
		RequestDispatcher dispatcher=null;
		PreparedStatement statement = null;
		 ResultSet rs = null; 
		try {
			connect = dataSource.getConnection();
              // Step 2: Create a SQL statements string
				String query = "select * from user_de where name = ? and password = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, uEmail);
				statement.setString(2, password);
				rs=statement.executeQuery();
				if(rs.next()) {
                    session.setAttribute("name", rs.getNString("name"));
                    dispatcher=request.getRequestDispatcher("index.jsp");
				}else {
					request.setAttribute("status","faild");
					dispatcher=request.getRequestDispatcher("login.jsp");
				}
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
//				response.getWriter().println(e.print);
			}
	      
	}
	
	

}
