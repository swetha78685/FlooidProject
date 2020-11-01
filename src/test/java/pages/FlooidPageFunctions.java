package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectrepository.GoogleObjects;
import pages.CommonFunctions;

public class FlooidPageFunctions extends CommonFunctions{
	public static String coventryNumber=null;
	
	public void searchFlooidCoventryNumber(String searchText) throws Throwable {
		click(GoogleObjects.SEARCHBOX, "Search Box");
		sendkeys(GoogleObjects.SEARCHBOX, searchText, searchText);
		Thread.sleep(5000);
		driver.findElement(GoogleObjects.SEARCHBOX).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	
	public String validateSearchResultsInHomePage() {
		coventryNumber=driver.findElement(GoogleObjects.COVENTRY_NUMBER).getText();
		List<WebElement> searchResults=driver.findElements(GoogleObjects.SEARCHRESULTS);
		for(WebElement ele : searchResults) {
			System.out.println("Search Results for the Flooid Coventry Number is : "+ele.getText());
		}
		System.out.println(coventryNumber);
		return coventryNumber;
	}

	public void validateTopWebsitesFromSearchResults() {
		List<WebElement> searchResults=driver.findElements(GoogleObjects.SEARCHRESULTS);
		int count=0;			
		for(WebElement ele : searchResults) {
			System.out.println("Search Results for the Flooid Coventry Number is : "+ele.getText());
			count++;
			if(count==10) {
				break;
			}
		}
	}

	public void openAnyWebsiteFromSearchResults() {
		List<WebElement> searchResults=driver.findElements(GoogleObjects.SEARCHRESULTS);
		int count=0;			
		for(WebElement ele : searchResults) {
			System.out.println("Search Results for the Flooid Coventry Number is : "+ele.getText());
			count++;
			if(count==2) {
				ele.click();
				break;
			}
		}
	}

	public void validateAnyWebsiteDetails() {
		if(driver.getPageSource().contains(coventryNumber)){
			System.out.println("Coventry Number details are present on the website : Phone number as :"+coventryNumber);
		}else{
			System.out.println("Coventry Number details are not present on the website");
		}
	}

	public void closeAndBrowser() {
		try {				
			driver.close();
			driver.quit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {

		}
	}
}





