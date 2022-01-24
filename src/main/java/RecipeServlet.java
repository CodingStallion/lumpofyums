
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lumpofyums.Recipe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class RecipeServlet
 */
@WebServlet("/RecipeServlet")
public class RecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/lump_of_yums";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_RECIPE_SQL = "INSERT INTO RECIPE"
			+ " (food_name, prep_time, cooking_time, level, description, ingredients, preparation, uid) VALUES "
			+ " (?,?,?,?,?,?,?,?);";
	private static final String SELECT_RECIPE_BY_ID = "select food_name, prep_time, cooking_time, level, description, ingredients, preparation, uid, username from recipe R INNER JOIN user U ON R.uid = U.id where food_name =?";
	private static final String SELECT_ALL_RECIPE = "select * from recipe R INNER JOIN user U ON R.uid = U.id";
	private static final String DELETE_RECIPE_SQL = "delete from recipe where food_name = ?;";
	private static final String UPDATE_RECIPE_SQL = "update recipe set food_name = ?,prep_time= ?, cooking_time =?,description =?,ingredients =?,preparation =?,uid =? where food_name = ?;";

	// private static final String UPDATE_RECIPE_SQL = "update recipe set name =
	// ?,password= ?, email =?,language =? where name = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
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
	public RecipeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/RecipeServlet/recipe":
				showRecipe(request, response);
				break;
			case "/RecipeServlet/home":
				listUsers(request, response);
				break;
			case "/RecipeServlet/delete":
				deleteRecipe(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Recipe> recipes = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RECIPE);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String food_name = rs.getString("food_name");
				int prep_time = rs.getInt("prep_time");
				int cooking_time = rs.getInt("cooking_time");
				String level = rs.getString("level");
				String description = rs.getString("description");
				String ingredients = rs.getString("ingredients");
				String preparation = rs.getString("preparation");
				int uid = rs.getInt("uid");
				String username = rs.getString("username");

				recipes.add(new Recipe(food_name, prep_time, cooking_time, level, description, ingredients, preparation,
						uid, username));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listUsers", recipes);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showRecipe(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String food_name = request.getParameter("food_name");
		Recipe existingRecipe = new Recipe("", 1, 1, "", "", "", "", 1, "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RECIPE_BY_ID);) {
			preparedStatement.setString(1, food_name);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				food_name = rs.getString("food_name");
				int prep_time = rs.getInt("prep_time");
				int cooking_time = rs.getInt("cooking_time");
				String level = rs.getString("level");
				String description = rs.getString("description");
				String ingredients = rs.getString("ingredients");
				String preparation = rs.getString("preparation");
				int uid = rs.getInt("uid");
				String username = rs.getString("username");
				existingRecipe = new Recipe(food_name, prep_time, cooking_time, level, description, ingredients,
						preparation, uid, username);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("recipe", existingRecipe);
		request.getRequestDispatcher("/Recipe.jsp").forward(request, response);
	}

	private void deleteRecipe(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String food_name = request.getParameter("food_name");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_RECIPE_SQL);) {
			statement.setString(1, food_name);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to RecipeServlet dashboard
		response.sendRedirect("http://localhost:8090/lumpofyums/RecipeServlet/home");
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

}
