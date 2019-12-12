/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatort;

/**
 *
 * @author AKravchuk
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public enum Command{
        SUM,
        DIV,
        NEW_COMMAND,
    }
    
    public int calculate(Command command, int argument1, int argument2){
        int argAbs1 = Math.abs(argument1);
        int argAbs2 = Math.abs(argument2);
        switch(command){
            case SUM:
                return sum(argAbs1, argAbs2);
            case DIV:
                return div(argAbs1, argAbs2);
            default:
                throw new UnsupportedOperationException("Unknoen operation = " + command);
        }
    }
    
    private int sum(int argument1, int argument2){
        //return Math.abs(argument1) + Math.abs(argument2);
        return argument1 + argument2;
    }
    
    private int div(int divined, int divisor){ //throws Exception
        if (divisor == 0){
            throw new IllegalArgumentException("Divisior can not be zero");
        }
        return divined / divisor;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
