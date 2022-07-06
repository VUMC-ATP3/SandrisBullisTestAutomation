package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest {
    WebDriver ChromeBrowser;

    @BeforeMethod
    public void MakeDriver(){
        ChromeBrowser = new ChromeDriver();
        ChromeBrowser.manage().window().maximize();
    }

    @Test
    public void HomePageTestOne(){
        ChromeBrowser.get("https://bbt.lv/");
        String expectedTitle = "Baltijas Biroju Tehnoloģijas • BBT • Interaktīvie un audiovizuālie risinājumi";
        String actualTitle = ChromeBrowser.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void HomePageTestTwo(){
        ChromeBrowser.get("https://smartboard.lv/");
        String expectedTitle = "SMARTBOARD";
        String actualTitle = ChromeBrowser.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterMethod
    public void CloseDriver(){
        ChromeBrowser.quit();
    }
}
