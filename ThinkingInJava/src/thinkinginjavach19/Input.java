/*
Конечный автомат
 */
package thinkinginjavach19;

import java.util.Random;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        public int amount() { // Запрещено
            throw new RuntimeException("ARORT.amount()");
        }
    },
    STOP { // Это должен быть последний экземпляр
        @Override
        public int amount() { // Запрещено
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    
    int value; // в центах
    
    Input(int value) {
        this.value = value;
    }
    
    Input() {}
    
    int amount() {
        return value;
    }
    
    static Random rand = new Random(47);
    
    public static Input randomSelection() {
        // Не включая STOP
        return values()[rand.nextInt(values().length - 1)];
    }
}
