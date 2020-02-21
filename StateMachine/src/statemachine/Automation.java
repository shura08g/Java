// for example
package statemachine;

/**
 *
 * @author AKravchuk
 */
public class Automation implements IAutomationInterface {
    
    private Automation() {}
    
    public static IAutomationInterface createAutomation() {
        return new Automation();
    }
}
