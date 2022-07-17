package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By checkoutFirstName = By.id("first-name");
    private By checkoutLastName = By.id("last-name");
    private By checkoutZipCode = By.id("postal-code");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public WebElement getErrorMessageTextField(){
        return driver.findElement(errorMessage);
    }



}
