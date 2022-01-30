import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lumpofyums.CommentsDetails;
import lumpofyums.Comments;
import lumpofyums.Recipe;

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
	private static final String SELECT_COMMENT_BY_ID = "select comment,recipe_name,uid from comment where created_at =?";
	private static final String SELECT_ALL_COMMENT = "select * from comment C INNER JOIN user U ON C.uid = U.id";
	private static final String DELETE_COMMENT_SQL = "delete from comment where created_at = ?;";
	private static final String UPDATE_COMMENT_SQL = "update comment set comment  = ?,  recipe_name =?, uid =? where created_at = ?;";
	private static final long serialVersionUID = 1L;

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
			case "/CommentServlet/edit":
				showCommentEditForm(request, response);
				break;
			case "/CommentServlet/update":
				updateComment(request, response);
				break;
				
				
				
			}
		}catch(

	SQLException ex)
	{
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
		List<Comments> comments = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENT);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String comment = rs.getString("comment");
				String username = rs.getString("username");
				int uid = rs.getInt("uid");
				String recipe_name = rs.getString("recipe_name");
				Timestamp created_at = rs.getTimestamp("created_at");
				comments.add(new Comments(comment, username, uid, recipe_name, created_at));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// recipe.jsp

		request.setAttribute("listComment", comments);
		request.getRequestDispatcher("/Comment.jsp").forward(request, response);
	}
//edited by eithan: took in created_at parameters instead of recipe_name since created_at is more unique.
	// method to delete comment
	private void deleteComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String created_at = request.getParameter("created_at");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COMMENT_SQL);) {
			statement.setString(1, created_at);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/lumpofyums/RecipeServlet/home");
	}

	private void showCommentEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String created_at = request.getParameter("created_at");
		// get parameter passed in the URL
		CommentsDetails existingComment = new CommentsDetails ("", 1, "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENT_BY_ID);) {
			preparedStatement.setString(1, created_at);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				String comment = rs.getString("comment");
				String recipe_name = rs.getString("recipe_name");
				int uid = rs.getInt("uid");
				
				
				existingComment = new CommentsDetails( comment, uid ,recipe_name);

			}
			
			
		
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("edit", existingComment);
		request.getRequestDispatcher("/editComments.jsp").forward(request, response);

	}
	
	private void updateComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String comment = request.getParameter("comment");		
		String recipe_name = request.getParameter("recipe_name");
		int uid = Integer.parseInt(request.getParameter("uid"));
	
	
		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COMMENT_SQL);) {

			statement.setString(1, comment);
			statement.setString(2, recipe_name);
			statement.setInt(3, uid);
		
			int i = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your project name)
		response.sendRedirect("http://localhost:8090/lumpofyums/RecipeServlet/home");
	}	
	

}
