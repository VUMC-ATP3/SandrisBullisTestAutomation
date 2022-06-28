package classRoomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import java.time.Duration;
import java.util.List;

public class SwagLabsTest {
    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://C:\\Users\\Testing\\GIT\\Java4nodarbiba\\SandrisBullisTestAutomation\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
//        atveram browseri
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                        .timeouts()
                                .implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Atveram browseri");

    }

    @Test
    public void testErrorMessage() throws InterruptedException {
//        testejam error
        driver.get(SWAGLABS_URL);

        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        WebElement passWordInputField = driver.findElement(By.name("password"));
        passWordInputField.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

//        userNameInputField.clear();
//        passWordInputField.clear();
//
//        passWordInputField.sendKeys("Passwarod123");
//        loginButton.click();
//        actualErrorMessage = errorMessage.getText();
//        expectedErrorMessage = "Epic sadface: Username is required";
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);


        Thread.sleep(3000);
        System.out.println("Izpildam testu");

    }

    @Test
    public void testErrorMessageWithoutPasswordPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Sandris", "");
        loginPage.getErrorMessageTextField().getText();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }
    @Test
    public void testErrorMessageWithoutUsernamePOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "Parole");
        loginPage.getErrorMessageTextField().getText();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(),"PRODUCTS");

    }

    @Test
    public void testFooterCopyRightText() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Footer footer = new Footer(driver);
        String actualString = footer.getCopyRightTextField().getText();
        String expectedString = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        Assert.assertEquals(actualString, expectedString);
    }





    @Test
    public void testSuccessfullLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        WebElement passWordInputField = driver.findElement(By.name("password"));
        passWordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title'"));
        Assert.assertEquals(titleText.getText(),"PRODUCTS");

        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
        // WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin'] > a"))
        //linkedInLink.click();

        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");

        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();


        Thread.sleep(3000);

    }

    @Test
    public void testSamplePage() throws InterruptedException {
        driver.get(LOCAL_URL);

        WebElement vards = driver.findElement(By.id("fNameID"));
        vards.sendKeys("Sandris");
        WebElement uzVards = driver.findElement(By.id("lNameID"));
        uzVards.sendKeys("Bullis");
        WebElement informacija = driver.findElement(By.name("description"));
        informacija.clear();
        informacija.sendKeys("Šeit ir info par mani!!");
        WebElement students = driver.findElement(By.id("studentID"));
        students.click();
        WebElement radioPogaJava = driver.findElement(By.id("javaID"));
        System.out.println(radioPogaJava.isSelected());
        radioPogaJava.click();
        System.out.println(radioPogaJava.isSelected());

        Select milakaKrasaDropDownn = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropDownn.selectByIndex(0);
        milakaKrasaDropDownn.selectByIndex(3);

        List<WebElement> saraksts = milakaKrasaDropDownn.getOptions();
        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());
        }




        Thread.sleep(3000);
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
//        aizveram browseri
        driver.close();
        System.out.println("Aizveram browseri");

    }

}


