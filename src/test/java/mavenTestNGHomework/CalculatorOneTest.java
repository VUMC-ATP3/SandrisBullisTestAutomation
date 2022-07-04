package mavenTestNGHomework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class CalculatorOneTest {
    public CalculatorOne calculator;






    @BeforeMethod
    public void beforeMethod(){
        System.out.println(" Tests ir sācies! ");
    }
    @BeforeClass
    public void beforeClass(){
        this.calculator = new CalculatorOne();
    }
}
