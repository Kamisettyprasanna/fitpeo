package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitpeoRevenue {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://fitpeo.com/home");
		driver.findElement(By.xpath("//*[name()='svg' and @data-testid='MenuIcon']")).click();
		driver.findElement(By.xpath("//span[text()='Revenue Calculator']")).click();
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)");
		WebElement sliderElement = driver.findElement(By.xpath("//input[@type='range']"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
//		float f = 93.5f;
//		int x = (int)f;
	//	 action.dragAndDropBy(sliderElement, x, 0).perform();
		Thread.sleep(4000);
		action.dragAndDropBy(sliderElement, -30, 0).perform();
		Thread.sleep(4000);
		action.dragAndDropBy(sliderElement, 124, 0).perform();
		String valueOfSlider = sliderElement.getAttribute("value");
		System.out.println("The slider is moved to: " + valueOfSlider);
		WebElement sliderTextField = driver.findElement(By.xpath("//input[@type='number']"));
		Thread.sleep(3000);
		sliderTextField.clear();
		Thread.sleep(3000);
		action.dragAndDropBy(sliderElement, -124, 0).perform();
		Thread.sleep(3000);
		action.dragAndDropBy(sliderElement, 85, 0).perform();
	//	sliderTextField.sendKeys(String.valueOf(560)); -->Syntax to pass the value 560 through js but slider is 
														//not moving
//		jse.executeScript("arguments[0].value='560';", sliderTextField);
//		Thread.sleep(3000);
		System.out.println("The slider is now moved to: " +sliderElement.getAttribute("value"));
		Thread.sleep(3000);
		action.dragAndDropBy(sliderElement, -85, 0).perform();
		Thread.sleep(3000);
		action.dragAndDropBy(sliderElement, 124, 0).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='CPT-99091']/../label/span/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='CPT-99453']/../label/span/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='CPT-99454']/../label/span/input")).click();
		Thread.sleep(3000);
		String totalReimbursement=driver.findElement(By.xpath("//p[contains(text(),'Total Recurring')]/p")).getText();
		if(totalReimbursement.contains("110700"))
		{
			System.out.println("Total reimbursement validation succesfull");
		}
		else
		{
			System.out.println("Total reimbursement validation failed");
		}
		driver.quit();
	}

}
