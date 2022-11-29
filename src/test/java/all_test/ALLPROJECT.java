package all_test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ALLPROJECT  {
	
	WebDriver driver = new ChromeDriver();
	
	SoftAssert soft = new SoftAssert();
	@BeforeTest
	public void openUrl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","\\resources\\chromedriver.exe");
		//driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
        Thread.sleep(3000);

	}


	@Test (priority = 1)
	public void log()throws InterruptedException
	{
		
		driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/login.htm");
		WebElement Cant_Login = driver.findElement(By.xpath("//*[@id=\"cantLogin\"]")); 
		WebElement Ok_Btn = driver.findElement(By.xpath("//*[@id=\"cannotLoginPopup\"]/div[2]/button"));
	    Cant_Login .click();
	    Thread.sleep(2000);
	    Ok_Btn.click();
		
	    // invalid username and password
		WebElement invalidUserName= driver.findElement(By.id("username"));
		WebElement invalidPassword = driver.findElement(By.id("password"));
		WebElement Location = driver.findElement(By.id("Inpatient Ward"));
		WebElement Btnlogin = driver.findElement(By.id("loginButton"));
		
		invalidUserName.sendKeys("Admi");
		invalidPassword.sendKeys("Admin");
		Btnlogin.click();
		Thread.sleep(2000);
		
		invalidUserName.clear();
		Thread.sleep(2000);
		invalidPassword.clear();
		Thread.sleep(2000);
		
        

		// valid username and password
		WebElement validUserName= driver.findElement(By.id("username"));
		WebElement validPassword = driver.findElement(By.id("password"));
		
		validUserName.sendKeys("Admin");
	    validPassword.sendKeys("Admin123");
	    Location.click();
	    Btnlogin.click();
	    Thread.sleep(2000);
	    
	    
	    String expectedResult_login = "Logged in as Super User (admin) at Inpatient Ward.";
        String actualResult_login = driver.findElement(By.tagName("h4")).getText();
        soft.assertTrue(actualResult_login.contains(expectedResult_login));

	}
	
	@Test (priority = 2) 
	public void Register() throws InterruptedException{
	
	driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/referenceapplication/home.page");
	WebElement RegisterB1 = driver.findElement(By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]"));
	RegisterB1.click();
	Thread.sleep(3000);

	
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

	String expectedResult_regist = "Register a patient";
    String actualResult_regist = driver.findElement(By.tagName("h2")).getText();
    soft.assertTrue(actualResult_regist.contains(expectedResult_regist));
	
	}
	
	@Test (priority = 3)
	public void LoginWithCapture()throws InterruptedException
	{
        
		driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId=37f765a3-8b87-4057-916b-0368a4ca3af9");
		
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
		
		String expectedResult_capture = "Capture Vitals for Patient";
        String actualResult_capture = driver.findElement(By.tagName("h2")).getText();
        soft.assertTrue(actualResult_capture.contains(expectedResult_capture));
		
		//go to home by icon
		WebElement Icon_Home_Small1 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a"));
		Icon_Home_Small1.click();
		Thread.sleep(2000);
		
		String expectedResult_gohome = "Logged in as Super User (admin) at Inpatient Ward.";
        String actualResult_gohome = driver.findElement(By.tagName("h4")).getText();
        soft.assertTrue(actualResult_gohome.contains(expectedResult_gohome));
	}
	
	@Test (priority = 4)
    public void View() throws InterruptedException {
		
		driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/index.htm");
		// find patient from home
		WebElement Find_Patient = driver.findElement(By.xpath("//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]"));
		Find_Patient.click();
		
		//search by id (Don't use 100HRU or 100HNY )
        WebElement Search_Patient = driver.findElement(By.id("patient-search"));
        Search_Patient.sendKeys("100HUN");
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
		String expectedResult_find = "Find Patient Record";
        String actualResult_find = driver.findElement(By.tagName("h2")).getText();
        soft.assertTrue(actualResult_find.contains(expectedResult_find));
        
        
		WebElement Search_Patient2 = driver.findElement(By.id("patient-search"));
		Search_Patient2.sendKeys("100HUN");
		Thread.sleep(1000);
		WebElement Odd2 = driver.findElement(By.className("odd"));
		Odd2.click();
		Thread.sleep(1000);
		WebElement Icon_Home_Small2 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a/i"));
		Icon_Home_Small2.click();
		Thread.sleep(1000);
		
		String expectedResult_gohome1 = "Logged in as Super User (admin) at Inpatient Ward.";
        String actualResult_gohome1 = driver.findElement(By.tagName("h4")).getText();
        soft.assertTrue(actualResult_gohome1.contains(expectedResult_gohome1));
		}
	
	@Test (priority = 5)
	
	public void View_DATA() throws InterruptedException {
		
		driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/index.htm");
		
		WebElement DataManagement = driver.findElement(By.id("coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension"));
		DataManagement.click();
		Thread.sleep(2000);
		
		WebElement MergePatient = driver.findElement(By.xpath("//*[@id=\"coreapps-mergePatientsHomepageLink-app\"]"));
		MergePatient.click();
		Thread.sleep(2000);
		
		// first id
		WebElement PatientID1= driver.findElement(By.xpath("//*[@id=\"patient1-text\"]"));
		PatientID1.sendKeys("100HTR");
		Thread.sleep(2000);
		
		// second id
		WebElement PatientID2 = driver.findElement(By.xpath("//*[@id=\"patient2-text\"]"));
		PatientID2.sendKeys("100HUN");
		Thread.sleep(2000);
		
		// send empty 
		WebElement dynamically_search= driver.findElement(By.xpath("//*[@id=\"patient1-text\"]"));
		dynamically_search.sendKeys("");
		Thread.sleep(2000);
	
		// confirm
		WebElement Btncont = driver.findElement(By.xpath("//*[@id=\"confirm-button\"]"));
		Btncont.click();
		Thread.sleep(4000);
		
		// no
		WebElement BtnNO = driver.findElement(By.xpath("//*[@id=\"cancel-button\"]"));
		BtnNO.click();
		Thread.sleep(2000);
		
		String expectedResult_merg = "Select two patients to merge...";
        String actualResult_merg = driver.findElement(By.tagName("h3")).getText();
        soft.assertTrue(actualResult_merg.contains(expectedResult_merg));
		
		// home
		WebElement Icon_Home_Small2 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a/i"));
		Icon_Home_Small2.click();
		
		// logout
		WebElement log_out = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]"));
		Thread.sleep(2000);
		log_out.click();
		Thread.sleep(1000);
		
}
	
	@AfterTest
    public void CloseDriver(){
        driver.quit();
}
}
