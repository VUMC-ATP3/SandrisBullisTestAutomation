import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void testSum(){
        System.out.println("Saskaitišanas tests");
        int actualResult = calculator.sum(5,3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertEquals(calculator.sum(5,3),8);
        Assert.assertEquals(calculator.sum(-5,-3),-8);
        Assert.assertEquals(calculator.sum(5,3),8);
        Assert.assertEquals(calculator.sum(-5,3),-2);
        Assert.assertEquals(calculator.sum(-5,-3),-8);
        Assert.assertEquals(calculator.sum(0,-3),-3);
        Assert.assertEquals(calculator.sum(2,0),2);
        Assert.assertEquals(calculator.sum(0,0),0);


        System.out.println("This is my first test ever!");
    }

    @Test
    public void testDiv(){
        System.out.println("Dalīšanas tests");
        Assert.assertEquals(calculator.div(8.2,2.0),4.1);
    }

    @Test
    public void izteiksmesTests(){
        System.out.println("Izteiksmes tests");
        Assert.assertEquals(calculator.div(8.2,2.0) + calculator.sum(1,2),7.1);
    }

    @BeforeClass
    public void beforeClass(){
        this.calculator = new Calculator();
    }

    @BeforeMethod
    public void izpildasPirmsKatraTesta(){
        System.out.println("Izpildas before class");
    }


}
