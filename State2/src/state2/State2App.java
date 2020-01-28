/*
 * Состояние (англ. State) — поведенческий шаблон проектирования. Используется
 * в тех случаях, когда во время выполнения программы объект должен менять своё
 * поведение в зависимости от своего состояния.
 *
 * Паттерн состоит из 3 блоков:
 *
 * Widget — класс, объекты которого должны менять своё поведение в зависимости
 * от состояния.
 *
 * IState — интерфейс, который должен реализовать каждое из конкретных состояний. Через этот интерфейс объект Widget взаимодействует с состоянием, делегируя ему вызовы методов. Интерфейс должен содержать средства для обратной связи с объектом, поведение которого нужно изменить. Для этого используется событие (паттерн Publisher — Subscriber). Это необходимо для того, чтобы в процессе выполнения программы заменять объект состояния при появлении событий. Возможны случаи, когда сам Widget периодически опрашивает объект состояние на наличие перехода.
 * 
 * StateA … StateZ — классы конкретных состояний. Должны содержать информацию о
 * том, при каких условиях и в какие состояния может переходить объект из 
 * текущего состояния. Например, из StateA объект может переходить в состояние
 * StateB и StateC, а из StateB — обратно в StateA и так далее. Объект одного
 * из них должен содержать Widget при создании.
 */
package state2;

/**
 *
 * @author AKravchuk
 */
public class State2App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; ++i) {
            human.doSomething();
        }

    }
    
}


//Context
class Human {
    private Activity state;
    
    public void setState(Activity st) {
        this.state = st;
    }
    
    public void doSomething() {
        state.doSomething(this);
    }
}

//State
interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    @Override
    public void doSomething(Human context) {
        System.out.println("Working!!!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int count = 0;
    @Override
    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Waiting...(Zz-zz) day " + (count + 1));
            count++;
            //context.setState(this);
        }
        else {
            context.setState(new Work());
        }
    }
}

