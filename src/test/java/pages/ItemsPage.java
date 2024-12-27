package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsPage {

	WebDriver driver;
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	public By btnAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
	public By iconCart = By.xpath("//a[contains(@href,'cart.payments.ebay.com/sc')]");
			

}
