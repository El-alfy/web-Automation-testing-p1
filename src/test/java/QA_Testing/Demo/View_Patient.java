package QA_Testing.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class View_Patient {
	public void View(WebDriver driver) throws InterruptedException {
		
		
		
		// find patient from home
		WebElement Find_Patient = driver.findElement(By.xpath("//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]"));
		Find_Patient.click();
		
		//search by id (Don't use 100HRU or 100HNY )
        WebElement Search_Patient = driver.findElement(By.id("patient-search"));
        Search_Patient.sendKeys("100HM1");
        Thread.sleep(1000);
        
        //click id
        WebElement Odd = driver.findElement(By.className("odd"));
		Odd.click();
		
		//Edit demographics
		WebElement edit_patient_demographics = driver.findElement(By.xpath("//*[@id=\"edit-patient-demographics\"]/a"));
		edit_patient_demographics.click();		
		Thread.sleep(1000);
		
		//clear first name and add another 
		WebElement First= driver.findElement(By.name("givenName"));
		First.clear();
		Thread.sleep(1000);
		First.sendKeys("Marwa");
		
		//clear middle name and add another
		WebElement Middle = driver.findElement(By.name("middleName"));
		Middle.clear();
		Thread.sleep(1000);
		Middle.sendKeys("");
		
		//clear FamilyName name and add another
		WebElement FamilyName = driver.findElement(By.name("familyName"));
		FamilyName.clear();
		FamilyName.sendKeys("Mohamed");
		Thread.sleep(1000);
		
		//click next button 
		WebElement BtnNext = driver.findElement(By.id("next-button"));
	    BtnNext.click();
	    Thread.sleep(1000);
	    
	    //select Female and click next
	    Select Gender = new Select(driver.findElement(By.name("gender")));
	    Gender.selectByValue("F");
	    Thread.sleep(1000);
	    BtnNext.click();
	    Thread.sleep(1000);
	    
	    //clear Day and add another
	    WebElement Day = driver.findElement(By.id("birthdateDay-field"));
	    Day.clear();
	    Thread.sleep(1000);
		Day.sendKeys("20");
		
	    //select another month
		Select Month=new Select(driver.findElement(By.name("birthdateMonth")));
		Month.selectByIndex(8);
		Thread.sleep(1000);
		
		//clear year and add another 
	    WebElement Year = driver.findElement(By.xpath("//*[@id=\"birthdateYear-field\"]"));
	    Year.clear();
	    Thread.sleep(1000);
		Year.sendKeys("1996");
		Thread.sleep(1000);
		BtnNext.click();
		Thread.sleep(1000);
		
		//confirm button
		WebElement registration_submit = driver.findElement(By.xpath("//*[@id=\"registration-submit\"]"));
		registration_submit.click();
		Thread.sleep(1000);
		
		//DropDown contact info
		WebElement patient_header_contactInfo = driver.findElement(By.xpath("//*[@id=\"patient-header-contactInfo\"]"));
		patient_header_contactInfo.click();
		Thread.sleep(1000);
		
		//click edit for contact info
		WebElement Editbtn = driver.findElement(By.xpath("//*[@id=\"contact-info-inline-edit\"]/a"));
		Editbtn.click();
		Thread.sleep(1000);
		
		//clear Contact Info -Address and add another 
	    WebElement Address = driver.findElement(By.id("address1"));
	    Address.clear();
	    Thread.sleep(1000);
		Address.sendKeys("Gleem");
		Thread.sleep(1000);
	    WebElement Address2 = driver.findElement(By.id("address2"));
	    Address2.clear();
	    Thread.sleep(1000);
		Address2.sendKeys("ALEX");
		
		//City/Village
	    WebElement C_or_V = driver.findElement(By.id("cityVillage"));
	    C_or_V.clear();
	    Thread.sleep(1000);
	    C_or_V.sendKeys("ALEX");
	    
	    //State/Province
	    WebElement S_or_P = driver.findElement(By.id("stateProvince"));
	    S_or_P.clear();
	    Thread.sleep(1000);
	    S_or_P.sendKeys("ALEX");
	    
	    //country
	    WebElement Country = driver.findElement(By.id("country"));
	    Country.clear();
	    Thread.sleep(1000);
	    Country.sendKeys("Egypt");
	    
	    //Postal Code
	    WebElement Postal = driver.findElement(By.id("postalCode"));
	    Postal.clear();
	    Thread.sleep(1000);
	    Postal.sendKeys("456");
	    Thread.sleep(1000);
	    
	    WebElement BtnNext1 = driver.findElement(By.xpath("//*[@id=\"next-button\"]/icon"));
	    BtnNext1.click();
	    Thread.sleep(1000);
		
	    //clear Contact Info -patient phone number and add another 
	    WebElement Phone = driver.findElement(By.name("phoneNumber"));
	    Phone.clear();
	    Thread.sleep(1000);
		Phone.sendKeys("01234303040");
		Thread.sleep(1000);
		BtnNext1.click();
		Thread.sleep(1000);
		WebElement registration_submit2 = driver.findElement(By.id("registration-submit"));
		registration_submit2.click();
		Thread.sleep(1000);
		

		/*
		//click note
		WebElement note = driver.findElement(By.xpath("//*[@id=\"TextField\"]/pre/i"));
		note.click();
		Thread.sleep(1000);
		
		//write
		WebElement write_your_note= driver.findElement(By.xpath("//*[@id=\"coreapps-fragment-stickyNote\"]/coreapps-click-to-edit-obs/div/div/div[1]/span[1]/form/div/textarea"));
		write_your_note.sendKeys("Patient recovered");
		Thread.sleep(2000);
		
		//paste 
		WebElement Right = driver.findElement(By.className("preformatted-note ng-binding"));
		Right.click();
		Thread.sleep(1000);*/
		
		
		
		//home
		WebElement Icon_Home_Small1 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a"));
		Icon_Home_Small1.click();
		Thread.sleep(1000);
		
		WebElement Find_Patient2 = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
		Find_Patient2.click();
		
		//assertion
		WebElement sucsess_View= driver.findElement(By.tagName("h2"));
		org.testng.Assert.assertEquals("Find Patient Record",sucsess_View.getText() );
		
		WebElement Search_Patient2 = driver.findElement(By.id("patient-search"));
		Search_Patient2.sendKeys("100HM1");
		Thread.sleep(1000);
		WebElement Odd2 = driver.findElement(By.className("odd"));
		Odd2.click();
		Thread.sleep(1000);
		
		WebElement Icon_Home_Small2 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a/i"));
		Icon_Home_Small2.click();
		Thread.sleep(1000);
		
		//assertion
		WebElement sucsess= driver.findElement(By.tagName("h4"));
		org.testng.Assert.assertEquals("Logged in as Super User (admin) at Inpatient Ward.",sucsess.getText() );
		}
	}


