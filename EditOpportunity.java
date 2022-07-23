package Week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOpportunity extends BaseClass {

	@Test
	public  void runEditOpportunity() throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		//Click on toggle menu button from the left corner
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Click view All and click Sales from App Launcher
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on Opportunity tab 
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		
		// Search the Opportunity 'Salesforce Automation by Your Name'
		
		WebElement search=driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
				search.sendKeys("Salesforce Automation by Dhanusha"+ Keys.ENTER);
				driver.findElement(By.xpath("//div[@role='status']/span")).click();
				
		//Click on the Dropdown icon and Select Edit
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Show Actions']//ancestor::a")).click();
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		//Choose close date as Tomorrow date
	
		WebElement date=driver.findElement(By.xpath("(//label[text()='Close Date'])//following-sibling::div//input"));
		date.clear();
		date.sendKeys("7/11/2022" + Keys.TAB);
		
		//Select 'Stage' as Perception Analysis
		
		Actions actions =new Actions(driver);
		driver.findElement(By.xpath("//label[text()='Stage']//following::span")).click();
		actions.moveToElement(driver.findElement(By.xpath("//span[@title='Perception Analysis']"))).click().perform();
		
		//Select Deliver Status as In Progress
	Thread.sleep(2000);
		WebElement status=driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']//following::span"));
		js.executeScript("arguments[0].scrollIntoView();", status);
		status.click();	
		actions.moveToElement(driver.findElement(By.xpath("//span[@title='In progress']"))).click().perform();
		
		//Enter Description as SalesForce
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Salesforce");
		
		//Click on Save and Verify Stage as Perception Analysis
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		

	}

}
