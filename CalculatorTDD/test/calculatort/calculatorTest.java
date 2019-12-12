/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatort;

//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static calculatort.Calculator.Command;

/**
 *
 * @author AKravchuk
 */
public class calculatorTest {
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public static final int ZERO = 0;
    
    private int argument1;
    private int argument2;
    private Calculator calculator;
    private int result;
    
    @Before
    public void setUp(){
        calculator = new Calculator();
    }
    
    @After
    public void tearDown(){
        calculator = null;
    }
    
    @Test
    public void test_sum1(){
//        int result = calculator.sum(2, 2);
//        Assert.assertThat(result, Is.is(4));
        given_arguments(2, 2);
        when_command_is(Command.SUM);
        then_result_is(4);
    }
    
    @Test
    public void test_sum2(){
//        int result = calculator.sum(3, 3);
//        Assert.assertThat(result, Is.is(6));
        given_arguments(3, 3);
        when_command_is(Command.SUM);
        then_result_is(6);
    }
    
    @Test
    public void test_sum_abs(){
//        int result = calculator.sum(5, -3);
//        Assert.assertThat(result, Is.is(8));
        given_arguments(5, -3);
        when_command_is(Command.SUM);
        then_result_is(8);
    }
    
    @Test
    public void test_div(){
//        int result = calculator.div(4, 2);
//        Assert.assertThat(result, Is.is(2));
        given_arguments(4, 2);
        when_command_is(Command.DIV);
        then_result_is(2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_div_on_zero(){
//        int result = calculator.div(100, ZERO);
//        Assert.fail();
        given_arguments(100, ZERO);
        when_command_is(Command.DIV);
        then_result_throws_exception();
    }
    
    @Test
    public void test_div_abs(){
//        int result = calculator.div(10, -2);
//        Assert.assertThat(result, Is.is(5));
        given_arguments(10, -2);
        when_command_is(Command.DIV);
        then_result_is(5);
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void test_new_command(){
        given_arguments(10, 10);
        when_command_is(Command.NEW_COMMAND);
        then_result_throws_exception();
    }
       
    private void given_arguments(int arg1, int arg2){
        this.argument1 = arg1;
        this.argument2 = arg2;
    }
    
    private void when_command_is(Command command){
        this.result = calculator.calculate(command, argument1, argument2);
    }
    
    private void then_result_is(int expectedResult){
        Assert.assertThat(result, Is.is(expectedResult));
    }
    
    private void then_result_throws_exception(){
        Assert.fail();
    }
}
