package QA_Testing.Demo;
import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Registeration  {
	
	
	public void Register(WebDriver driver) throws InterruptedException{
		
	WebElement RegisterB1 = driver.findElement(By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]"));
	RegisterB1.click();
	
	
	//with checkbox till cancle
	WebElement CheckBox = driver.findElement(By.id("checkbox-unknown-patient"));
	Select Gender = new Select(driver.findElement(By.id("gender-field")));
	WebElement BtnNext = driver.findElement(By.id("next-button"));
	WebElement Btncancle = driver.findElement(By.id("cancelSubmission"));
	
	Thread.sleep(2000);
	CheckBox.click();
   
    Gender.selectByValue("M");
    Thread.sleep(2000);
   
    BtnNext.click();
    Thread.sleep(2000);
    
    Btncancle.click();
	Thread.sleep(2000);
	
	
	//remove checkbox
	CheckBox.click();
	Thread.sleep(2000);
    
	//Demographics -name
	WebElement First= driver.findElement(By.name("givenName"));
	WebElement Middle = driver.findElement(By.name("middleName"));
	WebElement FamilyName = driver.findElement(By.name("familyName"));
	
	First.sendKeys("Mahmoud");
	Thread.sleep(1000);
	Middle.sendKeys("Tarek");
	Thread.sleep(1000);
	FamilyName.sendKeys("EL-Alfy");
	Thread.sleep(2000);
	BtnNext.click();
	
	//Demographics -gender
	Gender.selectByValue("M");
	Thread.sleep(2000);
	
	//try to previous with previous button 
	WebElement BtnpreviousRegistration = driver.findElement(By.id("prev-button"));
	BtnpreviousRegistration.click();
	Thread.sleep(2000);
	BtnNext.click();
	Thread.sleep(2000);
	
	//select gender 
	Gender.selectByValue("M");
	BtnNext.click();
    Thread.sleep(2000);
    
  
	
    //Demographics -Birthdate 
    //Day
    WebElement Day = driver.findElement(By.id("birthdateDay-field"));
	Day.sendKeys("18");
	
    //month
	Select Month=new Select(driver.findElement(By.xpath("//*[@id=\"birthdateMonth-field\"]")));
	Month.selectByIndex(1);
	
	//year
    WebElement Year = driver.findElement(By.xpath("//*[@id=\"birthdateYear-field\"]"));
	Year.sendKeys("2000"); 
	
	// test by Estimated Years and Estimated Months (or)
    /*WebElement Estimated_Years = driver.findElement(By.xpath("//*[@id=\"birthdateYears-field\"]"));
	Estimated_Years.sendKeys("2000");
	
    WebElement Estimated_Month = driver.findElement(By.xpath("//*[@id=\"birthdateMonths-field\"]"));
	Estimated_Month.sendKeys("1");*/
	
	Thread.sleep(2000);
	BtnNext.click();
    Thread.sleep(2000);
    
	
    //Contact Info -Address
    WebElement Address = driver.findElement(By.id("address1"));
    WebElement Address2 = driver.findElement(By.id("address2"));
    
	Address.sendKeys("Haram");
    Address2.sendKeys("Haram");
	
	//City/Village
    WebElement C_or_V = driver.findElement(By.id("cityVillage"));
    C_or_V.sendKeys("Giza");
    
    //State/Province
    WebElement S_or_P = driver.findElement(By.id("stateProvince"));
    S_or_P.sendKeys("Cairo");
    
    //country
    WebElement Country = driver.findElement(By.id("country"));
    Country.sendKeys("Egypt");
    
    //Postal Code
    WebElement Postal = driver.findElement(By.id("postalCode"));
    Postal.sendKeys("123");
    BtnNext.click();
    Thread.sleep(2000);
    
	//Contact Info -What's the patient phone number?
    WebElement Phone = driver.findElement(By.name("phoneNumber"));
	Phone.sendKeys("0123456789");
	Thread.sleep(2000);
	BtnNext.click();
	Thread.sleep(2000);
	
    
    //Relationships  -Who is the patient related to?
	//select
	Select Relation_Type=new Select(driver.findElement(By.xpath("//*[@id=\"relationship_type\"]")));
	Relation_Type.selectByIndex(1);
	
	//person name
    WebElement Person_Name = driver.findElement(By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]"));
	Person_Name.sendKeys("Marwa Mohamed");
	
	//add another person with relation
    WebElement BtnmPlus = driver.findElement(By.xpath("//*[@id=\"relationship\"]/p[3]/a[1]/i"));
    BtnmPlus.click();
    Thread.sleep(2000);
    
	/*WebElement Btnminus = driver.findElement(By.xpath("//*[@id=\"relationship\"]/p[3]/a[2]/i"));
	Btnminus.click();
	Thread.sleep(3000);*/
	
	BtnNext.click();
	Thread.sleep(2000);
	//confirm
	WebElement Btn_Confirm = driver.findElement(By.id("submit"));
	Btn_Confirm.click();

	WebElement sucsess_Registeration= driver.findElement(By.tagName("h2"));
	org.testng.Assert.assertEquals("Register a patient",sucsess_Registeration.getText() );
	
	}
}
