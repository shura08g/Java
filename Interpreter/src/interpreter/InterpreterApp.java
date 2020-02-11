/*
 * Интерпретатор (англ. Interpreter) — поведенческий шаблон проектирования,
 * решающий часто встречающуюся, но подверженную изменениям, задачу. Также
 * известен как Little (Small) Language
 */
package interpreter;

/**
 *
 * @author AKravchuk
 */
public class InterpreterApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "1 - 2 + 3"
        // терминальное выражение - это конечное выражение
        // нетерминальное - это последовательность выражений
        Context cont = new Context();
        Expression expr = cont.evaluate("1-2+3");
        System.out.println(expr.interpret());
        expr = cont.evaluate("- 1-2 +3   + 5  +   10  -1");
        System.out.println(expr.interpret());
        
    }
}

interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    int number;
    
    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class MinusExpression implements Expression {
    Expression left;
    Expression right;
    
    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class PlusExpression implements Expression {
    Expression left;
    Expression right;
    
    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Context (контекст хранит глобальное состояние обьекта)
class Context {
    public Expression evaluate(String s) {
        s = s.replaceAll(" ", "");
        int pos = s.length() - 1;
        while (pos > 0) {
            if (Character.isDigit(s.charAt(pos))) {
                pos--;
            } else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(Integer.valueOf(s.substring(pos + 1, s.length())));
                char operator = s.charAt(pos);
                // System.out.println(left.interpret() + " " + right.interpret());
                switch (operator) {
                    case '-':
                        return new MinusExpression(left, right);
                    case '+':
                        return new PlusExpression(left, right);
                }
            }
        }
        int result = Integer.valueOf(s);
        return new NumberExpression(result);
    }
}