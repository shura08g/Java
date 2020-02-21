/**
 * Event — класс события. Используется для уведомления контекста из классов состояний.
 */
package statemachine;

/**
 *
 * @author AKravchuk
 */
public final class Event {
    private final String name;
    
    public Event(String name) {
        if (name == null) throw new NullPointerException();
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
