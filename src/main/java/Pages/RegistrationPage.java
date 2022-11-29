package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By Registerpatient = By.xpath("//*[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']");
	public void press_Registerpatient() {
	driver.findElement(Registerpatient).click();
	}
	
	private By Checkbox = By.id("checkbox-unknown-patient");
	public void press_Checkbox() {
	driver.findElement(Checkbox).click();
	}
	
	
	//private By Genderbox = By.id("gender-field");
	//public void list_Genderbox() {
	//Select Gender = new Select(Genderbox) ;
	//Gender.selectByValue("M");
    //driver.findElement(Genderbox).click(Gender);	
		
	
	
	//}
	
}
