package Test_Scenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
	@BeforeMethod
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://sadmin.paletteu.com/");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("superadmin@proceededu.net.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("superadmin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test(priority = 1)
	public void test_login() throws InterruptedException {
		
		
		
		
//		 List<WebElement> elements = driver.findElements(By.xpath("/html/body/app-root/app-organizations-list/div/div[3]/div[2]/div/div/table/tbody/tr/td[1]/u"));
//		 System.out.println("List");
//	        // Print the text of each element
//	        for (WebElement element : elements) {
//	            System.out.println(element.getText());
//	        }
//		  int numberOfElements = 10; // Change this to the actual number of elements
		
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        for (int i = 1; i <= 15; i++) {
	        	
	        	
	            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-organizations-list//tr["+i+"]/td[1]/u")));
	            System.out.println(element.getText());
	            element.click();
	            String AdminName = driver.findElement(By.xpath("/html/body/app-root/app-view-organization//table/tbody/tr/td[1]")).getText();
	            String AdminEmailId = driver.findElement(By.xpath("/html/body/app-root/app-view-organization//table/tbody/tr/td[2]")).getText();
	            String AdminStatus = driver.findElement(By.xpath("/html/body/app-root/app-view-organization//table/tbody/tr/td[3]")).getText();
	            
	            System.out.println("Admin Name : "+AdminName +"\n"+ "Email Id: "+ AdminEmailId +"\n"+"Sratus : "+AdminStatus+"\n");
	            driver.navigate().back();
	            
	            
	        }
	        
	        
	        
		
		
	  
	}
	@Test(priority = 2)
    public void test_createOrg() throws Exception {
    	Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-organizations-list/div/div[2]/div/div[3]/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-create-organization/div/form/div[1]/div[1]/div/div[2]/input")).sendKeys("Study");
		driver.findElement(By.xpath("/html/body/app-root/app-create-organization/div/form/div[1]/div[1]/div/div[2]/input")).sendKeys("blr");
		driver.findElement(By.xpath("/html/body/app-root/app-create-organization/div/form/div[1]/div[1]/div/div[3]/textarea")).sendKeys("random descrptionsss");
		driver.findElement(By.xpath("/html/body/app-root/app-create-organization/div/form/div[2]/div/button")).click();
//		String sucessText = driver.findElement(By.xpath("//*[@id=\"toast-container\"]")).getText();
//		System.out.println(sucessText);
    }
	@AfterMethod
	public void tearDown() {
//		driver.findElement(By.xpath("/html/body/app-root/app-organizations-list/div/div[1]/div[2]/span/img")).click();
		driver.quit();
	}
}
