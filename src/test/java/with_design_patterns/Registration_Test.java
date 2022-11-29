package with_design_patterns;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.RegistrationPage;

public class Registration_Test extends TestBase {
	
	@Test
	public void validReg()throws InterruptedException{
		
		RegistrationPage Reg_TC = new RegistrationPage(driver);
		
		Reg_TC.press_Registerpatient();
		Reg_TC.press_Checkbox();
	}
	

}
