package lumpofyums;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RecipeTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  
  @Test
  public void checkInput() {
	  
      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("http://localhost:8090/lumpofyums/login.jsp");
      WebElement username=driver.findElement(By.name("username"));
      WebElement password=driver.findElement(By.name("password"));
      WebElement login=driver.findElement(By.className("btn"));
      username.sendKeys("e");
      password.sendKeys("kysplslol");
      login.click();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/create_recipe.jsp");
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
      WebElement food_name=driver.findElement(By.name("food_name"));
      WebElement prep_time=driver.findElement(By.name("prep_time"));
      WebElement cooking_time=driver.findElement(By.name("cooking_time"));
      WebElement description=driver.findElement(By.name("description"));
      WebElement ingredients=driver.findElement(By.name("ingredients"));
      WebElement preparation=driver.findElement(By.name("preparation"));
      WebElement btn=driver.findElement(By.className("btn"));
      food_name.sendKeys("nicefood");
      prep_time.sendKeys("");
      cooking_time.sendKeys("");
      description.sendKeys("test");
      ingredients.sendKeys("test");
      preparation.sendKeys("test");
      btn.click();

      driver.quit();
  }
	    
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}