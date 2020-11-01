package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import accelerators.Base;

public class CommonFunctions extends Base{

	
	public void launchBrowser(String browser) {
		try {
			//open browser
			if(browser.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}else if(browser.contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\\\geckodriver.exe");
				driver=new FirefoxDriver();
			}else if(browser.contains("ie")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}else if(browser.contains("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\\\msedgedriver.exe");
				driver=new EdgeDriver();
			}else if(browser.contains("safari")) {
				System.setProperty("webdriver.safari.driver", System.getProperty("user.dir")+"\\Drivers\\\\XXXXXXXXX");
				driver=new SafariDriver();
			}		

			driver.manage().window().maximize();

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void launchApplication(String url) {
		try {

			driver.get(url);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		try {
			//close the browser
			driver.close();
			//quit the driver
			driver.quit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//driver.close();
			//driver.quit();
		}
	}
	public void framesExample() {
		try {
			
			driver.switchTo().frame(0);
			String str= driver.findElement(By.xpath("//h1")).getText();
			System.out.println(str);
			driver.switchTo().defaultContent();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
