package QA_Testing.Demo;

import static org.testng.Assert.assertEquals;


import java.lang.ref.Cleaner.Cleanable;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//public class login extends testbase {}
public class Login {



	public void log(WebDriver driver)throws InterruptedException
	{
		

		WebElement Cant_Login = driver.findElement(By.xpath("//*[@id=\"cantLogin\"]")); 
		WebElement Ok_Btn = driver.findElement(By.xpath("//*[@id=\"cannotLoginPopup\"]/div[2]/button"));
	    Cant_Login .click();
	    Thread.sleep(2000);
	    Ok_Btn.click();
		
	    // invalid username and password
		//WebElement invalidUserName= driver.findElement(By.id("username"));
		//WebElement invalidPassword = driver.findElement(By.id("password"));
		WebElement Location = driver.findElement(By.id("Inpatient Ward"));
		WebElement Btnlogin = driver.findElement(By.id("loginButton"));
		
		/*invalidUserName.sendKeys("Admi");
		invalidPassword.sendKeys("Admin");
		Btnlogin.click();
		Thread.sleep(2000);
		
		invalidUserName.clear();
		Thread.sleep(2000);
		invalidPassword.clear();
		Thread.sleep(2000);*/
		
        

		// valid username and password
		WebElement validUserName= driver.findElement(By.id("username"));
		WebElement validPassword = driver.findElement(By.id("password"));
		
		validUserName.sendKeys("Admin");
	    validPassword.sendKeys("Admin123");
	    Location.click();
	    Btnlogin.click();
	    Thread.sleep(2000);
	    
	    WebElement sucsess= driver.findElement(By.tagName("h4"));
		org.testng.Assert.assertEquals("Logged in as Super User (admin) at Inpatient Ward.",sucsess.getText() );
		
			
	}	
	
}
