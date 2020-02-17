/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author AKravchuk
 */
public class Parser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(">>> 123 = " + ParserEval.eval("123"));                        //123
        System.out.println(">>> 2*3 = " + ParserEval.eval("2*3"));                        //6
        System.out.println(">>> 2*(1+3) = " + ParserEval.eval("2*(1+3)"));                //8
        System.out.println(">>> 1+(5-2*(13/6)) = " + ParserEval.eval("1+(5-2*(13/6))"));  //2
        
    }
    
}

class ParserEval {
    public static int eval(String expr) {
        if (expr.startsWith("(") && expr.endsWith(")")) {
            return eval(expr.substring(1, expr.length() - 1));
        } else if (expr.startsWith("(") && !expr.endsWith(")")) {
            throw new RuntimeException("If expr start with '(' than MUST end with ')'");
        } else {
            int pos = 0;
            while (pos < expr.length() - 1) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(0, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr.substring(pos + 1));
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                        default:
                            throw new RuntimeException("Unknoen operation'");
                    }
                }
            }
        }
        return Integer.valueOf(expr);
    }
}
