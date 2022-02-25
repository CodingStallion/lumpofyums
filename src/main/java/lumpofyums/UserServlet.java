package lumpofyums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lumpofyums.User;
import lumpofyums.UsersDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/UserServlet/delete":
				deleteUser(request, response);
				break;
			case "/UserServlet/edit":
				showEditForm(request, response);
				break;
			case "/UserServlet/update":
				updateUser(request, response);
				break;
	
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/lump_of_yums";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_USERS_SQL = "INSERT INTO USER"
			+ " (  username  ,  email  , address  , password, first_name ,last_name ,phone ,gender  ) VALUES " + " (?, ?, ?, ?,? ,? ,? ,?);";
	private static final String SELECT_USER_BY_ID = "select username  ,  email  , address  , password, first_name ,last_name ,phone ,gender from USER where id =?";
	private static final String SELECT_ALL_USERS = "select * from USER ";
	private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user set username =? ,  email =? , address =? , password =?, first_name =? ,last_name =? ,phone =? ,gender =? where id = ? ;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	
	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String username = request.getParameter("username");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		UsersDetails existingUser= new UsersDetails("", "", "", "","","",1,"",1);
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				username = rs.getString("username");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name= rs.getString("last_name");
				int phone = rs.getInt("phone");
				String gender= rs.getString("gender");
				existingUser = new UsersDetails( username  ,  email  , address  , password, first_name ,last_name ,phone ,gender, id );
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String gender = request.getParameter("gender");
		int id = Integer.parseInt(request.getParameter("id"));

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setString(3, address);
			statement.setString(4, password);
			statement.setString(5, first_name);
			statement.setString(6, last_name);
			statement.setInt(7, phone);
			statement.setString(8, gender);
			statement.setInt(9, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet
		response.sendRedirect("http://localhost:8090/lumpofyums/LogoutServlet");
		
	
	}

	// method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		//Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard
		response.sendRedirect("http://localhost:8090/lumpofyums/LogoutServlet");
	}
}
