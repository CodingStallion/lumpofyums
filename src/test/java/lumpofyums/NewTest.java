/*package lumpofyums;

import org.openqa.selenium.By;
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

*/