package accelerators;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Base {

	public WebDriver driver;
	
	public boolean click(By locator, String locatorName) {
		boolean flag=false;
		try {
			driver.findElement(locator).click();
			System.out.println("Successfully clicked on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;
	}
	public boolean jSClick(By locator, String locatorName) {
		boolean flag=false;
		try {
			WebElement element=driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("Successfully clicked on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;
	}
	public boolean selectByVisibleText(By locator, String text, String locatorName) {
		boolean flag=false;
		try {
			WebElement element=driver.findElement(locator);
			Select select=new Select(element);
			select.selectByVisibleText(text);
			System.out.println("Successfully Selected the value from the dropdown as  "+text);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;
	}
	public boolean sendkeys(By locator, String testdata,String locatorName) {
		boolean flag=false;
		try {
			driver.findElement(locator).sendKeys(testdata);
			System.out.println("Successfully clicked on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;			
	}
	public boolean clear(By locator, String locatorName) {
		boolean flag=false;
		try {
			driver.findElement(locator).clear();
			System.out.println("Successfully cleared the text box for "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;			
	}
	public boolean dblClkBtn(By locator, String locatorName) {
		boolean flag=false;
		try {
			Actions ac=new Actions(driver);
			ac.doubleClick(driver.findElement(locator)).build().perform();
		     System.out.println("Successfully dblclicked on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;
	}
	

	public boolean rightclick(By locator, String locatorName) {
		boolean flag=false;
		try {
			Actions ac=new Actions(driver);
			WebElement element=driver.findElement(locator);
			ac.contextClick(element);
			System.out.println("Successfully rightclicked on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;		
	}
	public boolean mouseHover(By locator, String locatorName) {
		boolean flag=false;
		try {
			Actions ac=new Actions(driver);
			WebElement element=driver.findElement(locator);
			ac.moveToElement(element).build().perform();;
			System.out.println("Successfully mouse hover on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;		
	}
	public boolean mouseHover(WebElement element, String locatorName) {
		boolean flag=false;
		try {
			Actions ac=new Actions(driver);
			
			ac.moveToElement(element).build().perform();
		
			System.out.println("Successfully rightclicked on the web element "+locatorName);
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;		
	}
	public boolean dragandDrop() {
		boolean flag=false;
			try {
			driver.findElement(By.id("sourceImage"));
			driver.findElement(By.id("targetDiv"));
			System.out.println("Successfully drag and dropped web element ");
			flag=true;
		}catch(Exception ex) {
			screenshot();
			ex.printStackTrace();
		}
		return flag;
	}
	
	public boolean screenshot() {
		boolean flag=false;
		try {
			
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\Images\\img.png"));
			//String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			flag=true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
}
