package Week2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOpportunity extends BaseClass {

	@Test
	public  void runDeleteOpportunity() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Click on toggle menu button from the left corner
				Thread.sleep(9000);
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				//Click view All and click Sales from App Launcher
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				
			//Click on Opportunity tab 
				Thread.sleep(5000);
				WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
			// Search the Opportunity 'Salesforce Automation by Your Name'
				Thread.sleep(3000);
				WebElement search=driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
				search.sendKeys("Salesforce Automation by Dhanusha"+ Keys.ENTER);
				driver.findElement(By.xpath("//div[@role='status']/span")).click();
				
			// Click on  the Dropdown icon and Select Delete
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Show Actions']//ancestor::a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				Thread.sleep(2000);
				WebElement success=(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]//span")));
				System.out.println(success.getText());
				
			
						
						
	}

}
