package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectsHomework.LoginPage;

import java.time.Duration;

public class SauceDemoTestsStepsHomework {

    WebDriver driver;
    LoginPage loginPage;


    @Before("@browser1")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        loginPage = new pageObjectsHomework.LoginPage(driver);
    }
    @After("@browser1")
    public void tearDown(){
        driver.close();
    }




    @Given("user is navigated to {string}")
    public void userIsNavigatedToString(String Url) {
        driver.get(Url);
    }
}
