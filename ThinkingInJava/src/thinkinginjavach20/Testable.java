// 2
package thinkinginjavach20;

public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }
    
    @Test void testExecute() {
        execute();
    }
}
