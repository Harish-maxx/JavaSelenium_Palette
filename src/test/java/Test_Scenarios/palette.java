package Test_Scenarios;

import org.testng.annotations.AfterMethod;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class palette {
	WebDriver driver;
	 Properties locators;
	@BeforeMethod //basic setup
	public void setUP()
	{
		
		  try {
	            // Load locators from properties file
	            locators = new Properties();
	            FileInputStream fis = new FileInputStream("locators.properties");
	            locators.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
		  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(locators.getProperty("url"));
		driver.findElement(By.xpath(locators.getProperty("email_xpath"))).sendKeys(locators.getProperty("email_value"));;
		driver.findElement(By.xpath(locators.getProperty("password_xpath"))).sendKeys(locators.getProperty("password_value"));
        driver.findElement(By.xpath(locators.getProperty("submit_btn_xpath"))).click();
        
	}
	@Test(priority = 1)//get details in home page
	public void test_login() throws InterruptedException {
		

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        for (int i = 1; i <= 15; i++) {
	        	
	        	
	            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-organizations-list//tr["+i+"]/td[1]/u")));
	            System.out.println(element.getText());
	            element.click();
	            String AdminName = driver.findElement(By.xpath(locators.getProperty("admin_name_xpath"))).getText();
	            String AdminEmailId = driver.findElement(By.xpath(locators.getProperty("admin_email_xpath"))).getText();
	            String AdminStatus = driver.findElement(By.xpath(locators.getProperty("admin_status_xpath"))).getText();
	            
	            System.out.println("Admin Name : "+AdminName +"\n"+ "Email Id: "+ AdminEmailId +"\n"+"Sratus : "+AdminStatus+"\n");
	            driver.navigate().back();
	            
	            
	        }
	        
	        
	        
		
		
	  
	}
	@Test(priority = 2)//Create organizations
    public void test_createOrg() throws Exception {
    	Thread.sleep(3000);
		driver.findElement(By.xpath(locators.getProperty("create_orgBtn_xpath"))).click();
		driver.findElement(By.xpath(locators.getProperty("org_name_xpath"))).sendKeys(locators.getProperty("org_name_value"));
		driver.findElement(By.xpath(locators.getProperty("org_address_xpath"))).sendKeys(locators.getProperty("org_address_value"));
		driver.findElement(By.xpath(locators.getProperty("org_desc_xpath"))).sendKeys(locators.getProperty("org_desc_value"));
		driver.findElement(By.xpath(locators.getProperty("click_btn_reg"))).click();

    }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
