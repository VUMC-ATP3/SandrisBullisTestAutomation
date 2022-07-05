package classRoomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcodemyShopTest {
    RemoteWebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://oauth-sandrisbullis-4a735:ef3b3b15-25d1-4074-94d6-1218284d69b3@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);



//        ChromeOptions options = new ChromeOptions();
//        EdgeOptions options = new EdgeOptions();

//        driver = new RemoteWebDriver(new URL("https://oauth-sandrisbullis-4a735:ef3b3b15-25d1-4074-94d6-1218284d69b3@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);
//        driver = new ChromeDriver();
//        driver = new WebDriver(new URL("https://oauth-sandrisbullis-4a735:ef3b3b15-25d1-4074-94d6-1218284d69b3@ondemand.eu-central-1.saucelabs.com:443/wd/hub"));

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 2 results");
        Thread.sleep(2000);
        mainPage.searchProduct("t-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");
        Thread.sleep(2000);
        mainPage.searchProduct("hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(),3);
        Thread.sleep(2000);

        List<WebElement> results =  mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("##########################");
            System.out.println(results.get(i).getText());
        }
        List<WebElement> results1 =  mainPage.getSearchResults();
        for (int i = 0; i < results1.size(); i++) {
            System.out.println("##########################");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }

    }
//    @Test
//    public void testEmptySearch()  {
//        driver.get("http://shop.acodemy.lv/");
//        MainPage mainPage = new MainPage(driver);
//        mainPage.searchProduct("JurisJuris");
//        Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);
//    }

    @Test
    public void testSwitchTabs() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");

        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
    }

    @Test
    public void testJavaScript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
//        ((JavascriptExecutor) driver).executeScript("alert('Sandris Sandris)");

        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);


    }

    @Test
    public void mouseActionsTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(3000);

    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.keyDown(Keys.CONTROL).sendKeys("K").perform();
        Thread.sleep(3000);

    }



    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }
}
