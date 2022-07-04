package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorOneTest {
    public CalculatorOne calculator;

    @Test
    public void testAdd() {
        Assert.assertEquals(calculator.add(1,1),2);
        Assert.assertEquals(calculator.add(2,2),4);
        Assert.assertEquals(calculator.add(2,-2),0);
    }

    @Test
    public void testSubstract() {
        Assert.assertEquals(calculator.substract(3,3),0);
        Assert.assertEquals(calculator.substract(3,-3),6);
        Assert.assertEquals(calculator.substract(0,3),-3);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(2,2),4);
        Assert.assertEquals(calculator.multiply(2,0),0);
        Assert.assertEquals(calculator.multiply(2,1),2);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(calculator.divide(2,2),1);
        Assert.assertEquals(calculator.divide(2,1),2);
        Assert.assertEquals(calculator.divide(2,-2),-1);
    }



    @BeforeTest
    public void beforeTest(){
        System.out.println(" Testēsim kalkulatoru... ");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println(" Tests ir sācies! ");
    }
    @BeforeClass
    public void beforeClass(){
        this.calculator = new CalculatorOne();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println(" Viens tests ir beidzies!");
    }
    @AfterTest
    public void afterTest(){
        System.out.println(" Kalkulatora tests noslēdzies veiksmīgi.");
    }
}
