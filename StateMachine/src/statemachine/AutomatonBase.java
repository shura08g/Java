/*
 * AutomatonBase — базовый класс для всех автоматов. Он предоставляет
 * возможность наследнику регистрировать переходы, используя метод addEdge.
 * Дополнительно класс AutomatonBase реализует интерфейс уведомления о событии.
 */
package statemachine;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 *
 * @author AKravchuk
 * @param <AI>
 */
public abstract class AutomatonBase<AI> implements IEventSink {
    protected AI state;
    private final Map<AI, Map<Event, AI>> edges = new HashMap();
    
    protected void addEdge(AI source, Event event, AI target) {
        Map<Event, AI> row = edges.get(source);
        if (null == row) {
            row = new IdentityHashMap();
            edges.put(source, row);
        }
        row.put(event, target);
    }
    
    @Override
    public void castEvent(Event event) {
        try {
            state = edges.get(state).get(event);
        } catch (NullPointerException e) {
            throw new IllegalStateException("Edge is not defined");
        }
    }
}
