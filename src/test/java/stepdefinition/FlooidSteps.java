package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FlooidPageFunctions;
import utilities.ReadExcelData;

public class FlooidSteps extends FlooidPageFunctions{
	String filepath=System.getProperty("user.dir")+"/TestData/TestData.xlsx";

	public String browserName=ReadExcelData.columnDataByHeaderName(1, "Browser Name", "FlooidTestData", filepath);
	public String appURL=ReadExcelData.columnDataByHeaderName(1, "Application URL", "FlooidTestData", filepath);

	
	//public String searchText="flooid coventry number";
	@cucumber.api.java.Before
	public void launchBrowser() {
		launchBrowser(browserName);
	}
	
	@Given("launch the google application")
	public void givenMethod() {
		//launchBrowser(browserName);
		launchApplication(appURL);
	}

	@When("^Search text as (.+)$")
	public void search(String searchText) throws Throwable {
		searchFlooidCoventryNumber(searchText);
	}

	@Then("Validate the search results")
	public void validateSearchResults() {
		validateSearchResultsInHomePage();
	}
	
	@Then("Enter Coventry Phone Number in search box")
	public void searchWithCoventryPhoneNumber() throws Throwable {
		String coventryNumber=validateSearchResultsInHomePage();
		searchFlooidCoventryNumber(coventryNumber);		
	}
	
	@Then("Validate the top 10 websites")
	public void validateTopWebsites() {
		validateTopWebsitesFromSearchResults();
	}
	
	@Then("Click on any website other than Flooid")
	public void openAnyWebsite() {
		openAnyWebsiteFromSearchResults();
	}
	
	@Then("Validate the website details other than Flooid from search results")
	public void validateWebsiteDetails() {
		validateAnyWebsiteDetails();
	}
	
	@cucumber.api.java.After
	public void afterBrowser() {
		closeAndBrowser();
	}
	
	/*
	 * @Then("close browser") public void closeBrowser() { closeAndBrowser(); }
	 */
}