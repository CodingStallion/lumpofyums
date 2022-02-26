package lumpofyums;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;
	// Done By Kelmond

	@Test
	public void checkLogin() {
		// Load website as a new page

		// Assert the title to check that we are indeed in the correct website

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/login.jsp");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("btn"));
		username.sendKeys("alicia123");
		password.sendKeys("password");
		login.click();
		String actualUrl = "http://localhost:8090/lumpofyums/account.jsp";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}

	// Done By Kelmond

	@Test
	public void checkRegister() {
		// Load website as a new page

		// Assert the title to check that we are indeed in the correct website
		int phoneInt = 87623098;
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/register.jsp");
		WebElement username = driver.findElement(By.name("username"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement address = driver.findElement(By.name("address"));
		WebElement postalcode = driver.findElement(By.name("postal_code"));
		WebElement firstname = driver.findElement(By.name("first_name"));
		WebElement lastname = driver.findElement(By.name("last_name"));
		WebElement gender = driver.findElement(By.name("gender"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement answer = driver.findElement(By.name("answer"));
		WebElement login = driver.findElement(By.className("btn"));
		username.sendKeys("KevKevMalone");
		password.sendKeys("password");
		email.sendKeys("KevinMalone@dundermifflin.com");
		address.sendKeys("198 FAKE LANE STREET 20");
		postalcode.sendKeys("817654");
		firstname.sendKeys("Kevin");
		lastname.sendKeys("Malone");
		gender.sendKeys("M");
		phone.sendKeys(String.valueOf(phoneInt));
		answer.sendKeys("Cupcake");
		login.click();
		String actualUrl = "http://localhost:8090/lumpofyums/login.jsp";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}

	// Done By Kelmond
	@Test
	public void checkSearch() {
		// Load website as a new page

		// Assert the title to check that we are indeed in the correct website

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/RecipeServlet/home");
		WebElement search = driver.findElement(By.name("food_name"));
		search.sendKeys("roti");
		search.sendKeys(Keys.ENTER);
		String actualUrl = "http://localhost:8090/lumpofyums/search.jsp";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}

	// Done By Kelmond
	@Test
	public void checkEasySort() {
		// Load website as a new page

		// Assert the title to check that we are indeed in the correct website

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/index.jsp");
		WebElement easyButton = driver.findElement(By.id("easyBtn"));
		easyButton.click();
		String actualUrl = "http://localhost:8090/lumpofyums/RecipeServlet/easy";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}

	// Done By Kelmond
	@Test
	public void checkNormalSort() {
		// Load website as a new page

		// Assert the title to check that we are indeed in the correct website

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/index.jsp");
		WebElement easyButton = driver.findElement(By.id("normalBtn"));
		easyButton.click();
		String actualUrl = "http://localhost:8090/lumpofyums/RecipeServlet/normal";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}

	// Done By Kelmond
	@Test
	public void checkHardSort() {
		// Load website as a new page

		// Assert the title to check that we are indeed in the correct website

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/index.jsp");
		WebElement easyButton = driver.findElement(By.id("hardBtn"));
		easyButton.click();
		String actualUrl = "http://localhost:8090/lumpofyums/RecipeServlet/hard";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}

	// Done By Eithan
	@Test
	public void checkCreateInput() {
		Random r = new Random();
		int low = 1;
		int high = 99;
		int result = r.nextInt(high - low) + low;
		int prepInt = 9;
		int cookingInt = 5;
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/lumpofyums/login.jsp");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("btn"));
		username.sendKeys("alicia123");
		password.sendKeys("password");
		login.click();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/create_recipe.jsp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement food_name = driver.findElement(By.name("food_name"));
		WebElement prep_time = driver.findElement(By.name("prep_time"));
		WebElement cooking_time = driver.findElement(By.name("cooking_time"));
		WebElement description = driver.findElement(By.name("description"));
		WebElement ingredients = driver.findElement(By.name("ingredients"));
		WebElement preparation = driver.findElement(By.name("preparation"));
		WebElement btn = driver.findElement(By.className("btn"));
		food_name.sendKeys("Korean Bimbap " + result);
		prep_time.sendKeys(String.valueOf(prepInt));
		cooking_time.sendKeys(String.valueOf(cookingInt));
		description.sendKeys("test");
		ingredients.sendKeys("test");
		preparation.sendKeys("test");
		btn.click();
		driver.quit();
	}

	// Done By Eithan
	@Test
	public void checkUpdateInput() {
		Random r = new Random();
		int low = 1;
		int high = 99;
		int result = r.nextInt(high - low) + low;
		int low1 = 1;
		int high1 = 99;
		int result1 = r.nextInt(high1 - low1) + low1;
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/lumpofyums/login.jsp");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("btn"));
		username.sendKeys("alicia123");
		password.sendKeys("password");
		login.click();
		driver.get("http://localhost:8090/lumpofyums/RecipeServlet/recipe?food_name=Chicken%20Ramen");
		WebElement edit = driver.findElement(By.id("editbtn"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		edit.click();
		WebElement food_name = driver.findElement(By.name("food_name"));
		WebElement prep_time = driver.findElement(By.name("prep_time"));
		WebElement cooking_time = driver.findElement(By.name("cooking_time"));
		WebElement description = driver.findElement(By.name("description"));
		WebElement ingredients = driver.findElement(By.name("ingredients"));
		WebElement preparation = driver.findElement(By.name("preparation"));
		WebElement btn = driver.findElement(By.className("btn"));
		food_name.sendKeys(Keys.CONTROL + "a");
		food_name.sendKeys(Keys.DELETE);
		prep_time.sendKeys(Keys.CONTROL + "a");
		prep_time.sendKeys(Keys.DELETE);
		cooking_time.sendKeys(Keys.CONTROL + "a");
		cooking_time.sendKeys(Keys.DELETE);
		food_name.sendKeys("Chicken Ramen");
		prep_time.sendKeys(String.valueOf(result));
		cooking_time.sendKeys(String.valueOf(result1));
		description.sendKeys("test1");
		ingredients.sendKeys("test2");
		preparation.sendKeys("test3");
		btn.click();
		driver.quit();

	}

	@Test
	public void checkCommentInput() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/lumpofyums/login.jsp");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("btn"));
		username.sendKeys("KevKevMalone");
		password.sendKeys("password");
		login.click();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/lumpofyums/RecipeServlet/recipe?food_name=Chicken%20Ramen");
		WebElement comment = driver.findElement(By.name("comment"));
		WebElement btn = driver.findElement(By.className("btn"));
		comment.sendKeys("Nice Food ");
		btn.click();
		driver.quit();

	}

	@Test
	public void checkUpdateComments() {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/lumpofyums/login.jsp");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("btn"));
		username.sendKeys("alicia123");
		password.sendKeys("password");
		login.click();
		driver.get("http://localhost:8090/lumpofyums/CommentServlet/edit?id=8");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement comment = driver.findElement(By.name("comment"));
		WebElement btn = driver.findElement(By.className("btn"));
		comment.sendKeys(Keys.CONTROL + "a");
		comment.sendKeys(Keys.DELETE);
		comment.sendKeys("Terrible Food");
		btn.click();
		driver.quit();

	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

}
