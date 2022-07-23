package Week2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunityWithoutMandatoryFields extends BaseClass {

	@Test
	public  void runOpportunityWithoutMandatoryFields() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='New']//div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Close Date'])//following-sibling::div//input")).sendKeys("7/11/2022");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement validation= driver.findElement(By.xpath("(//label[text()='Opportunity Name'])//following-sibling::div//input"));
		String validationMessage= (String) js.executeScript("return arguments[0].validationMessage;", validation);
		
		WebElement validation2=driver.findElement(By.xpath("//div[contains(@id,'help-text')]"));
		String validationMessage2= validation2.getText();
		
		System.out.println(validationMessage+ " :Name ");
		System.out.println(validationMessage2+ " :Stage ");
		
		
	}

}
