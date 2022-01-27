import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lumpofyums.Comments;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/lump_of_yums";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_COMMENT_SQL = "INSERT INTO COMMENT"
			+ " (name, password, email, language) VALUES " + " (?, ?, ?);";
	private static final String SELECT_COMMENT_BY_ID = "select comment,recipe_name,uid from recipe R INNER JOIN user U ON C.uid = U.id where comment =?";
	private static final String SELECT_ALL_COMMENT = "SELECT * FROM comment WHERE recipe_name = ?;";
	private static final String DELETE_COMMENT_SQL = "delete from comment where recipe_name = ?;";
	private static final String UPDATE_COMMENT_SQL = "update comment set name = ?,password= ?, email =?,language =? where name = ?;";
	private static final long serialVersionUID = 1L;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/CommentServlet/list":
				listComment(request, response);
				break;
			case "/CommentServlet/delete":
				deleteComment(request, response);
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

	// Step 5: listComment function to connect to the database and retrieve all
	// users
	// records
	private void listComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String recipe_name = request.getParameter("food_name");
		List<Comments> comments = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENT);) {
			preparedStatement.setString(1, recipe_name);
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String comment = rs.getString("comment");
				int uid = rs.getInt("uid");
				String username = rs.getString("username");
				comments.add(new Comments(comment, uid, username));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// recipe.jsp
		request.setAttribute("listComment", comments);
		request.getRequestDispatcher("/Recipe.jsp").forward(request, response);
	}

	// method to delete comment
	private void deleteComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String recipe_name = request.getParameter("recipe_name");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COMMENT_SQL);) {
			statement.setString(1, recipe_name);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/lumpofyums/RecipeServlet/home");
	}

}
