package with_design_patterns;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class Login_test extends TestBase {
   
	
	@Test
	public void validlog()throws InterruptedException{
		
		LoginPage Login_TC = new LoginPage(driver) ;
		
		Login_TC.press_Cant_Login();
		Thread.sleep(1000);
		Login_TC.press_Ok_Btn();
		Thread.sleep(1000);
		Login_TC.send_validUserName();
		Thread.sleep(1000);
		Login_TC.send_validPassword();
		Thread.sleep(1000);
		Login_TC.press_Location();
		Thread.sleep(1000);
		Login_TC.press_Btnlogin();
		Thread.sleep(1000);
		
	}
	
	
}
