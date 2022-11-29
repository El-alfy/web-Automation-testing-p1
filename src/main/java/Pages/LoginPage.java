package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {


	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By Cant_Login = By.id("cantLogin");
	public void press_Cant_Login() {
	driver.findElement(Cant_Login).click();
	}
	
	private By Ok_Btn = By.xpath("//*[@id=\"cannotLoginPopup\"]/div[2]/button");
	public void press_Ok_Btn() {
	driver.findElement(Ok_Btn).click();
	}
	
	private By validUserName = By.id("username");
	public void send_validUserName() {
	driver.findElement(validUserName).sendKeys("Admin");	
	}
	
	private By validPassword = By.id("password");
	public void send_validPassword() {
	driver.findElement(validPassword).sendKeys("Admin123");
	}
	
	private By Location = By.id("Inpatient Ward");
	public void press_Location() {
	driver.findElement(Location).click();
	}
	
	private By 	Btnlogin = By.id("loginButton");
	public void press_Btnlogin() {
	driver.findElement(Btnlogin).click();
	}
}
