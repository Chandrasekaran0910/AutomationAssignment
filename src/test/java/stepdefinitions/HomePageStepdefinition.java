package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.DriverManager;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepdefinition {

	WebDriver driver;

	HomePage homePage;

	@Given("the user opens the browser")
	public void openBrowser() {
		driver = DriverManager.getDriver(); // Use shared WebDriver
		homePage = new HomePage(driver); // Initialize HomePage with shared driver
		driver.manage().window().maximize();
	}

	@And("the user navigates to ebay.com")
	public void navigateToEbay() {
		driver.get("https://www.ebay.com");
		String pageTitle = driver.getTitle();
		assertThat(pageTitle).as("Page title should contain 'eBay'").contains("eBay");
	}

	@And("the user search for {string}")
	public void searchForItem(String item) {
		WebElement searchInput = driver.findElement(homePage.searchBox);
		WebElement searchBtn = driver.findElement(homePage.searchButton);
		searchInput.sendKeys(item);
		searchBtn.click();
	}

	@And("the user clicks on the first book in the list")
	public void clickFirstBook() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.FirstItem));
		firstItem.click();
	}

}
