
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class CreateRecipeServlet
 */
@WebServlet("/CreateRecipeServlet")
@MultipartConfig
public class CreateRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRecipeServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response
		PrintWriter out = response.getWriter();
		FileInputStream fis=null;
		// Step 2: retrieve the four parameters from the request from the web form

		String food = request.getParameter("food_name");
		int n = Integer.parseInt(request.getParameter("prep_time"));
		int p = Integer.parseInt(request.getParameter("cooking_time"));
		String e = request.getParameter("level");
		String c = request.getParameter("description");
		String b = request.getParameter("ingredients");
		String a = request.getParameter("preparation");
		int user = Integer.parseInt(request.getParameter("uid"));
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lump_of_yums", "root",
					"password");
			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement(
					"insert into recipe(food_name, prep_time, cooking_time, level, description, ingredients, preparation, uid, image) values(?,?,?,?,?,?,?,?,?)");
			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, food);
			ps.setInt(2, n);
			ps.setInt(3, p);
			ps.setString(4, e);
			ps.setString(5, c);
			ps.setString(6, b);
			ps.setString(7, a);
			ps.setInt(8, user);
			ps.setBinaryStream(9, fileContent);
			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();
			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,
			if (i > 0) {
				response.sendRedirect("http://localhost:8090/lumpofyums/RecipeServlet/home");
			}
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}

		doGet(request, response);

	}

}
