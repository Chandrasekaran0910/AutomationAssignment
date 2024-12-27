package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

	public By searchBox = By.id("gh-ac");
	 public By searchButton = By.id("gh-btn");
	 public By FirstItem = By.xpath("(//a[@class='s-item__link'])[3]");

}
