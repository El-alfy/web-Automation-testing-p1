package QA_Testing.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Data_Managment {
	public void View(WebDriver driver) throws InterruptedException {
	
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
		PatientID2.sendKeys("100HM1");
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
		
		//assertion
		WebElement sucsess_View= driver.findElement(By.tagName("h3"));
		org.testng.Assert.assertEquals("Select two patients to merge...",sucsess_View.getText() );
		
		
		// home
		WebElement Icon_Home_Small2 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a/i"));
		Icon_Home_Small2.click();
		
		// logout
		WebElement log_out = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]"));
		log_out.click();
		
		
}
}