package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjectsHomework.LoginPage;

import java.time.Duration;

public class SauceDemoTestsSteps {

    WebDriver driver;
    LoginPage loginPage;


    @Before("@browser1")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        loginPage = new pageObjectsHomework.LoginPage(driver);
    }
    @After("@browser")
    public void tearDown(){
        driver.close();
    }

    @Given( "User is navigated to {string}")
    public void userIsNavigatedTo(String url){
        driver.get(url);
    }







}
