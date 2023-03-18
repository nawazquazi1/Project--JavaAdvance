
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import sing.user;

public class UsersModel {

//	public List<user> listUsers(DataSource dataSource) {
//		// Step 1: Initialize connection objects
//		List<user> listUsers = new ArrayList<>(); 
//        Connection connect = null;
//        Statement stmt = null;
//        ResultSet rs = null;       
//        try {
//			connect = dataSource.getConnection();			
//			// Step 2: Create a SQL statements string
//			String query = "select * from new_table;";
//			stmt = connect.createStatement();
//			// Step 3: Execute SQL query
//         rs = stmt.executeQuery(query);
//			// Step 4: Process the result set
//			while(rs.next()){
//				listUsers.add(new user(rs.getInt("user_id"), rs.getString("username"), rs.getString("email")));
//			}	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//        return listUsers;
//	}

	public void addUser(DataSource dataSource, user newUser,HttpServletRequest request) {
		Connection connect = null;
		PreparedStatement statement = null;
		RequestDispatcher dispatcher=null;
		try {
			connect = dataSource.getConnection();
			String username = newUser.getName();
			String email = newUser.getEmail();
			String password = newUser.getPassword();
			String phoneNo = newUser.getMobileNo();
			String query = "insert into user_de (name,email,password,number) values (?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, phoneNo);
			int rowCount=statement.executeUpdate();
			if(rowCount>0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");	
			}	

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	public void updateUser(DataSource dataSource, user updatedUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int userId = updatedUser.getId();
			String username = updatedUser.getName();
			String email = updatedUser.getEmail();
			String password = updatedUser.getPassword();
			String number = updatedUser.getMobileNo();
			String query = "update user_de set name = ? , email = ? , password =?, number = ? where user_Id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, number);
			statement.setInt(3, userId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void deleteUser(DataSource dataSource, int usersID) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from user_de where user_Id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, usersID);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
