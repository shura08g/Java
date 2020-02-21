/**
 * IEventSink — интерфейс уведомления о событии
 */
package statemachine;

/**
 *
 * @author AKravchuk
 */
public interface IEventSink {
    public void castEvent(Event event);
}
