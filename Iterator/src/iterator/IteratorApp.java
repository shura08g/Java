/*
 * Iterator — поведенческий шаблон проектирования. Представляет собой объект, 
 * позволяющий получить последовательный доступ к элементам объекта-агрегата без
 * использования описаний каждого из агрегированных объектов.
 * 
 * Например, такие элементы как дерево, связанный список, хеш-таблица и массив 
 * могут быть пролистаны (и модифицированы) с помощью объекта Итератор.
 *
 * Перебор элементов выполняется объектом итератора, а не самой коллекцией. Это
 * упрощает интерфейс и реализацию коллекции, а также способствует более 
 * логичному разделению обязанностей.
 * 
 * Особенностью полноценно реализованного итератора является то, что код, 
 * использующий итератор, может ничего не знать о типе итерируемого агрегата.
 */
package iterator;

/**
 *
 * @author AKravchuk
 */
public class IteratorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tasks c = new Tasks();
        Iterator it = c.getIterator();

        while (it.hasNext()) {
            System.out.println((String)it.next());
        }
    }
    
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class Tasks implements Container {
    String[] tasks = {"Построить дом", "Родить сына", "Посадить дерево"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }
    
    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
        
    }
}
