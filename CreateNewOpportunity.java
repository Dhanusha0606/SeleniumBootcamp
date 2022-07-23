package Week2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity extends BaseClass {

	@Test
	public  void runCreateNewOpportunity()  {
		// TODO Auto-generated method stub
		
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);	
		
		driver.findElement(By.xpath("//a[@title='New']//div")).click();
		
		WebElement name=driver.findElement(By.xpath("(//label[text()='Opportunity Name'])//following-sibling::div//input"));
		name.sendKeys("Salesforce Automation by Dhanusha");
		
		String opportunityName=name.getAttribute("value");
		//System.out.println(opportunityName);
		driver.findElement(By.xpath("(//label[text()='Close Date'])//following-sibling::div//input")).sendKeys("7/9/2022");
		
		Actions actions = new Actions(driver);
		WebElement abc = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		
		abc.click();
		
		
		actions.moveToElement(driver.findElement(By.xpath("//span[@title='Needs Analysis']"))).click().perform();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		js.executeScript("arguments[0].click();", ele);
		
		
		Boolean result=driver.findElement(By.linkText(opportunityName)).isDisplayed();
		if(result==true)
			{
			System.out.print(opportunityName+" is created");
			}
		
		
		

	}

	
}
