/*
 * StateBase — базовый класс для состояний. Для проверки типов во время
 * компиляции применяются параметры типа (generic, template)
 */
package statemachine;

/**
 *
 * @author AKravchuk
 */
public abstract class StateBase<AI> {
    protected final AI automaton;
    protected final IEventSink eventSink;
    
    public StateBase(AI automaton, IEventSink eventSink) {
        if (automaton == null || eventSink == null) {
            throw new NullPointerException();
        }
        this.automaton = automaton;
        this.eventSink = eventSink;
    }
    
    protected void castEvent(Event event) {
        eventSink.castEvent(event);
    }
}
