
/*
package lumpofyums;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Part;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class RecipeJUnitTest {
	private RecipeServlet recipeservlet;
	private CreateRecipeServlet createRecipeservlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
		recipeservlet = new RecipeServlet();
		createRecipeservlet = new CreateRecipeServlet();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testCreateRecipeServlet() throws ServletException, IOException {

		request.addParameter("food_name", "test");
		request.addParameter("prep_time", Integer.toString(1));
		request.addParameter("cooking_time", Integer.toString(2));
		request.addParameter("level", "test");
		request.addParameter("description", "go test");
		request.addParameter("ingredients", "go test");
		request.addParameter("preparation", "go test");
		request.addParameter("uid", Integer.toString(2));
		request.addParameter("file", Integer.toString(2));

		createRecipeservlet.doPost(request, response);

	}

	@Test
	public void testEditRecipeServlet() throws ServletException, IOException, SQLException {

		request.addParameter("food_name", "test");
		request.addParameter("prep_time", Integer.toString(1));
		request.addParameter("cooking_time", Integer.toString(2));
		request.addParameter("level", "test");
		request.addParameter("description", "go test");
		request.addParameter("ingredients", "go test");
		request.addParameter("preparation", "go test");
		request.addParameter("uid", Integer.toString(2));
		request.addParameter("oriname", "test");
		recipeservlet.updateRecipe(request, response);

	}

	@Test
	public void testDeleteRecipeServlet() throws ServletException, IOException, SQLException {
		request.addParameter("food_name", "asdasda");
		recipeservlet.deleteRecipe(request, response);

	}
	@Test
	public void testGetRecipeServlet() throws ServletException, IOException, SQLException {
		recipeservlet.showRecipe(request, response);

	}
}




/*
 * @Test void testSetUsername() { fail("Not yet implemented"); }
 * 
 * @Test void testGetimageData() { fail("Not yet implemented"); }
 * 
 * @Test void testSetimageData() { fail("Not yet implemented"); }
 * 
 * @Test void testGetImage() { fail("Not yet implemented"); }
 * 
 * @Test void testSetImage() { fail("Not yet implemented"); }
 * 
 * @Test void testRecipe() { fail("Not yet implemented"); }
 * 
 * @Test void testGetId() { fail("Not yet implemented"); }
 * 
 * @Test void testSetId() { fail("Not yet implemented"); }
 * 
 * @Test void testGetFood_name() { fail("Not yet implemented"); }
 * 
 * @Test void testSetFood_name() { fail("Not yet implemented"); }
 * 
 * @Test void testGetPrep_time() { fail("Not yet implemented"); }
 * 
 * @Test void testSetPrep_time() { fail("Not yet implemented"); }
 * 
 * @Test void testGetCooking_time() { fail("Not yet implemented"); }
 * 
 * @Test void testSetCooking_time() { fail("Not yet implemented"); }
 * 
 * @Test void testGetLevel() { fail("Not yet implemented"); }
 * 
 * @Test void testSetLevel() { fail("Not yet implemented"); }
 * 
 * @Test void testGetDescription() { fail("Not yet implemented"); }
 * 
 * @Test void testSetDescription() { fail("Not yet implemented"); }
 * 
 * @Test void testGetIngredients() { fail("Not yet implemented"); }
 * 
 * @Test void testSetIngredients() { fail("Not yet implemented"); }
 * 
 * @Test void testGetPreparation() { fail("Not yet implemented"); }
 * 
 * @Test void testSetPreparation() { fail("Not yet implemented"); }
 * 
 * @Test void testGetUid() { fail("Not yet implemented"); }
 * 
 * @Test void testSetUid() { fail("Not yet implemented"); }
 * 
 * }
 */
