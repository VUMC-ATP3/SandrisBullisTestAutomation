package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ProductsPage;

public class sauceDemoTests {
    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";


    @BeforeMethod()
        public void openBrowser() {
            driver = new ChromeDriver();
            driver.get(SWAGLABS_URL);
            driver.manage().window().maximize();
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passWordInputField = driver.findElement(By.id("password"));
        passWordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
        public void checkOut() {
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(),"PRODUCTS");
        WebElement addItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        addItem.click();
        WebElement checkItem = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertEquals(checkItem.getText(),"1");
        WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));
        shoppingCartContainer.click();
        WebElement cartItem = driver.findElement(By.id("item_5_title_link"));
        Assert.assertEquals(cartItem.getText(),"Sauce Labs Fleece Jacket");
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebElement checkoutFirstName = driver.findElement(By.id("first-name"));
        checkoutFirstName.sendKeys("Sandris");
        WebElement checkoutLastName = driver.findElement(By.id("last-name"));
        checkoutLastName.sendKeys("Bullis");
        WebElement checkoutZipCode = driver.findElement(By.id("postal-code"));
        checkoutZipCode.sendKeys("2022");
        WebElement checkoutContinue = driver.findElement(By.id("continue"));
        checkoutContinue.click();
        String checkOver = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals(checkOver,"CHECKOUT: OVERVIEW");
        WebElement cartItemOver = driver.findElement(By.id("item_5_title_link"));
        Assert.assertEquals(cartItemOver.getText(),"Sauce Labs Fleece Jacket");
        WebElement checkFinish = driver.findElement(By.id("finish"));
        checkFinish.click();
        String checkComplete = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals(checkComplete,"CHECKOUT: COMPLETE!");
        WebElement backHome = driver.findElement(By.id("back-to-products"));
        backHome.click();
        }

        @Test()
        public void checkOutFieldsFirst() {
            WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));
            shoppingCartContainer.click();
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();
            WebElement checkoutFirstName = driver.findElement(By.id("first-name"));
            checkoutFirstName.sendKeys("");
            WebElement checkoutLastName = driver.findElement(By.id("last-name"));
            checkoutLastName.sendKeys("Bullis");
            WebElement checkoutZipCode = driver.findElement(By.id("postal-code"));
            checkoutZipCode.sendKeys("2022");
            WebElement checkoutContinue = driver.findElement(By.id("continue"));
            checkoutContinue.click();
            WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
            Assert.assertEquals(errorMessage.getText(),"Error: First Name is required");
        }

        @Test()
        public void checkOutFieldsLast() {
            WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));
            shoppingCartContainer.click();
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();
            WebElement checkoutFirstName = driver.findElement(By.id("first-name"));
            checkoutFirstName.sendKeys("Sandris");
            WebElement checkoutLastName = driver.findElement(By.id("last-name"));
            checkoutLastName.sendKeys("");
            WebElement checkoutZipCode = driver.findElement(By.id("postal-code"));
            checkoutZipCode.sendKeys("2022");
            WebElement checkoutContinue = driver.findElement(By.id("continue"));
            checkoutContinue.click();
            WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
            Assert.assertEquals(errorMessage.getText(),"Error: Last Name is required");
        }

    @Test()
    public void checkOutFieldsZip() {
        WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));
        shoppingCartContainer.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebElement checkoutFirstName = driver.findElement(By.id("first-name"));
        checkoutFirstName.sendKeys("Sandris");
        WebElement checkoutLastName = driver.findElement(By.id("last-name"));
        checkoutLastName.sendKeys("Bullis");
        WebElement checkoutZipCode = driver.findElement(By.id("postal-code"));
        checkoutZipCode.sendKeys("");
        WebElement checkoutContinue = driver.findElement(By.id("continue"));
        checkoutContinue.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorMessage.getText(),"Error: Postal Code is required");
    }


    @AfterMethod()
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}


