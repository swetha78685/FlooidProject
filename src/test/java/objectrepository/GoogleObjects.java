package objectrepository;

import org.openqa.selenium.By;

public class GoogleObjects {
	public static final By COVENTRY_NUMBER=By.xpath("(//span[contains(@aria-label,'Call phone number')])[1]");
	public static final By SEARCHRESULTS=By.xpath("//h3/span");
	public static final By SEARCHBOX=By.name("q");
	public static final By SEARCHLINK=By.xpath("//h3[text()='Selenium']");
	public static final By DOWNLOAD_LINK=By.xpath("//a[text()='Downloads']");
	public static final By PROJECTS_LINK=By.xpath("//a[text()='Projects']");
	public static final By DOC_LINK=By.xpath("//nav[@id='navbar']//a[text()='Documentation']");
	public static final By SUPPORT_LINK=By.xpath("//a[text()='Support']");
}
