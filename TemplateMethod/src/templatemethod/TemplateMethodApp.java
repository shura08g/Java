/*
 * Шаблонный метод (англ. Template method) — поведенческий шаблон проектирования,
 * определяющий основу алгоритма и позволяющий наследникам переопределять 
 * некоторые шаги алгоритма, не изменяя его структуру в целом.
 */
package templatemethod;

/**
 *
 * @author AKravchuk
 */
public class TemplateMethodApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        
        a.method();
        b.method();

        C a_temp = new A();
        C b_temp = new B();
        
        a_temp.templateMethod();
        b_temp.templateMethod();
        
    }
    
}

abstract class C {
    void templateMethod() {
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
        System.out.println();
    }
    
    abstract void differ();
    abstract void differ2();
}

class A extends C {
    void method() {
        System.out.print("1");
        System.out.print("2");
        System.out.print("3");
        System.out.print("4");
        System.out.println();
    }
    
    @Override
    void differ() {
        System.out.print("2");
    }
    
    @Override
    void differ2() {
        System.out.print("4");
    }
}

class B extends C {
    void method() {
        System.out.print("1");
        System.out.print("4");
        System.out.print("3");
        System.out.println();
    }
    
    @Override
    void differ() {
        System.out.print("4");
    }
    
    @Override
    void differ2() {}
}
