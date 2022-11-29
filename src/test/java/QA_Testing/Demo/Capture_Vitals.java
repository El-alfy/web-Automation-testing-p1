package QA_Testing.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Capture_Vitals {
	public void LoginWithCapture(WebDriver driver)throws InterruptedException
	{
        
		//go to home by icon
		WebElement Icon_Home_Small = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a"));
		Icon_Home_Small.click();
		
		// go to Capture Vitals
		WebElement Capture_Vitalss = driver.findElement(By.xpath("//*[@id=\"referenceapplication-vitals-referenceapplication-vitals-extension\"]"));
		Capture_Vitalss.click();
		Thread.sleep(2000);
		
		//search by name
		WebElement Patient_Search = driver.findElement(By.id("patient-search"));
		Patient_Search.sendKeys("Mahmoud");
		Thread.sleep(2000);
		Patient_Search.click();
		
		//select first name 
		WebElement Odd = driver.findElement(By.className("odd"));
		Odd.click();
		
		
        //Edit demographics
		WebElement edit_patient_demographics = driver.findElement(By.xpath("//*[@id=\"edit-patient-demographics\"]/a"));
		edit_patient_demographics.click();		
		Thread.sleep(2000);
		
		//save demographics
		WebElement Saveform1 = driver.findElement(By.xpath("//*[@id=\"save-form\"]"));
		Saveform1.click();		
		Thread.sleep(2000);
		
		//Exit demographics
		WebElement Exitform1 = driver.findElement(By.xpath("//*[@id=\"exit-form-container\"]/a[2]"));
		Exitform1.click();		
		Thread.sleep(2000);
		
		//dropdown contact info
		WebElement patient_header_contactInfo = driver.findElement(By.xpath("//*[@id=\"patient-header-contactInfo\"]"));
		patient_header_contactInfo.click();
		Thread.sleep(2000);
		
		//click edit for contact info
		WebElement Editbtn = driver.findElement(By.xpath("//*[@id=\"contact-info-inline-edit\"]/a"));
		Editbtn.click();
		Thread.sleep(2000);
		
		//EditAddress1
		WebElement EditAddress1 = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		EditAddress1.sendKeys("Giza ");
		Thread.sleep(2000);
		
		//save
		WebElement save_form2 = driver.findElement(By.xpath("//*[@id=\"save-form\"]"));
		save_form2.click();
		Thread.sleep(2000);
		
		//confirm
		WebElement registration_submit = driver.findElement(By.xpath("//*[@id=\"registration-submit\"]"));
		registration_submit.click();
		Thread.sleep(2000);
		
		//Find another patient by arrow
		WebElement icon_arrow_left = driver.findElement(By.className("icon-arrow-left"));
		icon_arrow_left.click();
		Thread.sleep(2000);
		
		//search by invalid name
		WebElement Patient_Search2 = driver.findElement(By.id("patient-search"));
		Patient_Search2.sendKeys("spiderman");
		Thread.sleep(2000);
		
		//delete
		WebElement patient_search_clear_button = driver.findElement(By.id("patient-search-clear-button"));
		patient_search_clear_button.click();
		Thread.sleep(2000);
		
		//search by id
		Patient_Search2.sendKeys("100HNY");
		Thread.sleep(2000);
		//WebElement Odd2 = driver.findElement(By.className("odd"));
		//Odd2.click();
		//Thread.sleep(2000);
		
		//assertion
		WebElement sucsess_Capture= driver.findElement(By.tagName("h2"));
		org.testng.Assert.assertEquals("Capture Vitals for Patient",sucsess_Capture.getText() );
		
		//go to home by icon
		WebElement Icon_Home_Small1 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a"));
		Icon_Home_Small1.click();
		Thread.sleep(2000);
		
		//assertion
		WebElement sucsess= driver.findElement(By.tagName("h4"));
		org.testng.Assert.assertEquals("Logged in as Super User (admin) at Inpatient Ward.",sucsess.getText() );
		
		
	}

}
