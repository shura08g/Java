
package thinkinginjavach10;

/**
 *
 * @author AKravchuk
 */
class WithInner {
    class Inner {}
}

public class InheritInner extends WithInner.Inner {
    //! InheritInner() {} // Не компилируется
    public InheritInner(WithInner wi) {
        wi.super();
    }
    
    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
