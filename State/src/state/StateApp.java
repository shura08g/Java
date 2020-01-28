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
package state;

/**
 *
 * @author AKravchuk
 */
public class StateApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        radio.play();
        radio.nextStation();
        radio.play();
        radio.nextStation();
        radio.play();
        radio.nextStation();
        radio.play();
        radio.setStation(new VestiFM());
        radio.play();
        
        for (int i = 0; i < 4; ++i) {
            radio.nextStation();
            radio.play();
        }
    }
    
}

//State
interface Station {
    void play();
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Radio 7....");
    }
}

class RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("Radio DFM....");
    }
}

class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("Vesti FM....");
    }
}

//Context
class Radio {
    Station station;
    
    void setStation(Station st) {
        this.station = st;
    }
    
    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        }
        else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        }
        else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }
    
    void play() {
        station.play();
    }
}