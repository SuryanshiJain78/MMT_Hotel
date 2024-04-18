package DriverSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver {
	public static WebDriver driver;
	public static ChromeOptions chromeOptions;
	public static EdgeOptions edgeOptions;
		public static WebDriver chromeDriver() throws InterruptedException 
		{
			WebDriverManager.chromedriver().setup();
			chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("disable-notifications");
			chromeOptions.addArguments("disable-popup-blocking");
			driver=new ChromeDriver(chromeOptions);
			driver.get("https://www.makemytrip.com/");
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
//		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[contains(@title,'notif')]")));
			Thread.sleep(3000);
	        try {
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'notif')]")));
			WebElement close_popup = driver.findElement(By.cssSelector("a.close"));
			close_popup.click();
			driver.switchTo().defaultContent();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return driver;	
		}
		public static WebDriver edgeDriver() {
			WebDriverManager.edgedriver().setup();
			edgeOptions=new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("disable-notifications");
			edgeOptions.addArguments("disable-popup-blocking");
			driver=new EdgeDriver(edgeOptions);
			driver.get("https://www.makemytrip.com/");
			return driver;
		}
}
