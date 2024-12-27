package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ItemsPage;
import utils.DriverManager;

import java.util.Iterator;
import java.util.Set;

public class ItemsPageStepdefinition {

	WebDriver driver;
	ItemsPage itemsPage;

	@And("the user switch to the item page")
	public void switchToItemPage() {
		driver = DriverManager.getDriver();
		itemsPage = new ItemsPage(driver);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				break;
			}
		}
	}

	@And("the user clicks on Add to cart")
	public void clickAddTocart() {
		WebElement AddToCart = driver.findElement(itemsPage.btnAddToCart);
		AddToCart.click();
	}

	@Then("the user verifies the cart has been updated and displays the number of items")
	public void verifyCart() {
		WebElement CartIcon = driver.findElement(itemsPage.iconCart);
		Assert.assertTrue("Cart is empty or not updated", CartIcon.getAttribute("alt").contains("1 item"));
	}
}
