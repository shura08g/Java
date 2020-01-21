/*
 * Декоратор (англ. Decorator) — структурный шаблон проектирования,
 * предназначенный для динамического подключения дополнительного поведения к
 * объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 * подклассов с целью расширения функциональности.
 */
package decorator;

/**
 *
 * @author AKravchuk
 */
public class DecoratorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrinterInterface printer = new Printer("Test string");
        printer.print();
        System.out.println();
        
        printer = new QuotesDecorator(new Printer("String in quotes"));
        printer.print();
        System.out.println();
        
        printer = new LeftBracketDecorator(new RightBracketDecorator(new Printer("String with bracket")));
        printer.print();
        System.out.println();
    }
    
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;
    
    public Printer(String value) {
        this.value = value;
    }
    
    @Override
    public void print() {
        System.out.print(value);
    }  
}

abstract class Decorator implements PrinterInterface {
    PrinterInterface component;
    public Decorator(PrinterInterface component) {
        this.component = component;
    }
    
    @Override
    public void print() {
        component.print();
    }
}

class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends Decorator {
    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}

/*class QuotesDecorator implements PrinterInterface {
    PrinterInterface component;
    
    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator implements PrinterInterface {
    PrinterInterface component;
    
    public LeftBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketDecorator implements PrinterInterface {
    PrinterInterface component;
    
    public RightBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}*/