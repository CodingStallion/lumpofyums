package lumpofyums;

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
  //declare Selenium WebDriver
  private WebDriver webDriver;		
 
  @Test
  public void checkLogin() {
      //Load website as a new page

      //Assert the title to check that we are indeed in the correct website

      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/login.jsp");
      WebElement username=driver.findElement(By.name("username"));
      WebElement password=driver.findElement(By.name("password"));
      WebElement login=driver.findElement(By.className("btn"));
      username.sendKeys("alicia123");
      password.sendKeys("password");
      login.click();
      String actualUrl="http://localhost:8090/lumpofyums/account.jsp";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
      driver.quit();
  }
  
  @Test
  public void checkRegister() {
      //Load website as a new page

      //Assert the title to check that we are indeed in the correct website
      int phoneInt = 87623098;
      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/register.jsp");
      WebElement username=driver.findElement(By.name("username"));
      WebElement email=driver.findElement(By.name("email"));
      WebElement password=driver.findElement(By.name("password"));
      WebElement address=driver.findElement(By.name("address"));
      WebElement postalcode=driver.findElement(By.name("postal_code"));
      WebElement firstname =driver.findElement(By.name("first_name"));
      WebElement lastname =driver.findElement(By.name("last_name"));
      WebElement gender=driver.findElement(By.name("gender"));
      WebElement phone=driver.findElement(By.name("phone"));
      WebElement login=driver.findElement(By.className("btn"));
      username.sendKeys("KevKevMalone");
      password.sendKeys("password");
      email.sendKeys("KevinMalone@dundermifflin.com");
      address.sendKeys("198 FAKE LANE STREET 20");
      postalcode.sendKeys("817654");
      firstname.sendKeys("Kevin");
      lastname.sendKeys("Malone");
      gender.sendKeys("M");
      phone.sendKeys(String.valueOf(phoneInt));
      login.click();
      String actualUrl="http://localhost:8090/lumpofyums/login.jsp";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
      driver.quit();
  }
  
  

  
  @Test
  public void checkSearch() {
      //Load website as a new page

      //Assert the title to check that we are indeed in the correct website

      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/RecipeServlet/home");
      WebElement search=driver.findElement(By.name("food_name"));
      search.sendKeys("roti");
      search.sendKeys(Keys.ENTER);
      String actualUrl="http://localhost:8090/lumpofyums/search.jsp";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
      driver.quit();
  }
  
  @Test
  public void checkEasySort() {
      //Load website as a new page

      //Assert the title to check that we are indeed in the correct website

      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/index.jsp");
      WebElement easyButton=driver.findElement(By.id("easyBtn"));
      easyButton.click();
      String actualUrl="http://localhost:8090/lumpofyums/RecipeServlet/easy";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
      driver.quit();
  }

  @Test
  public void checkNormalSort() {
      //Load website as a new page

      //Assert the title to check that we are indeed in the correct website

      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/index.jsp");
      WebElement easyButton=driver.findElement(By.id("normalBtn"));
      easyButton.click();
      String actualUrl="http://localhost:8090/lumpofyums/RecipeServlet/normal";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
      driver.quit();
  }

  @Test
  public void checkHardSort() {
      //Load website as a new page

      //Assert the title to check that we are indeed in the correct website

      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8090/lumpofyums/index.jsp");
      WebElement easyButton=driver.findElement(By.id("hardBtn"));
      easyButton.click();
      String actualUrl="http://localhost:8090/lumpofyums/RecipeServlet/hard";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
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