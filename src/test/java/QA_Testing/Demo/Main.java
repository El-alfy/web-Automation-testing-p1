package QA_Testing.Demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

	WebDriver driver;

	@BeforeTest
	public void openUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/login.htm");
		
	}
	@Test
	public void Main_Function() throws InterruptedException {
		

 
		Login login = new Login();
		login.log(driver);
		Thread.sleep(2000);
	    
		
		Registeration regist =new Registeration();
		regist.Register(driver);
		Thread.sleep(2000);
		
		/*Capture_Vitals cap = new Capture_Vitals();
		cap.LoginWithCapture(driver);
		Thread.sleep(2000);
		
		View_Patient Vpatient = new View_Patient();
		Vpatient.View(driver);
	    Thread.sleep(2000);
	    
		Data_Managment merge = new Data_Managment();
		merge.View(driver);
		Thread.sleep(2000);*/
	
		
	}
	
	@AfterMethod
	public void close() {
		
		driver.close();
	}
	
}
