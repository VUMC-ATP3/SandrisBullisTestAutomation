import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver chromeParluks;

    @Test
    public void testPageTitle(){
        chromeParluks = new ChromeDriver(); // atver parlūkprogrammu
        chromeParluks.navigate().to("https://www.lu.lv/");
        chromeParluks.manage().window().maximize();
        String expectedTitle = "Latvijas Universitāte";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        chromeParluks.quit();

    }

    @AfterMethod
    public void closeBrowser(){
        chromeParluks.quit();
    }


}
