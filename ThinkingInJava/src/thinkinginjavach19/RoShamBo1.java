// Двойная диспетчеризация
package thinkinginjavach19;

import java.util.Random;
import static thinkinginjavach19.Outcome.*;

interface Item {
    Outcome complete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissors s);
    Outcome eval(Rock r);
}

class Paper implements Item {

    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors s) {
        return WIN;
    }
    
    @Override
    public Outcome eval(Rock r) {
        return LOSE;
    }
    
    @Override
    public String toString() {
        return "Papper";
    }
    
}

class Scissors implements Item {

    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return LOSE;
    }

    @Override
    public Outcome eval(Scissors s) {
        return DRAW;
    }
    
    @Override
    public Outcome eval(Rock r) {
        return WIN;
    }
    
    @Override
    public String toString() {
        return "Scissors";
    }
    
}

class Rock implements Item {

    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return WIN;
    }

    @Override
    public Outcome eval(Scissors s) {
        return LOSE;
    }
    
    @Override
    public Outcome eval(Rock r) {
        return DRAW;
    }
    
    @Override
    public String toString() {
        return "Rock";
    }
    
}

public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);
    
    public static Item newItem() {
        switch(rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }
    
    public static void match(Item a, Item b) { // Двойная диспетчеризация
        System.out.println(a + " vs. " + b + ": " + a.complete(b));
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
/*
Rock vs. Rock: DRAW
Papper vs. Rock: WIN
Papper vs. Rock: WIN
Papper vs. Rock: WIN
Scissors vs. Papper: WIN
Scissors vs. Scissors: DRAW
Scissors vs. Papper: WIN
Rock vs. Papper: LOSE
Papper vs. Papper: DRAW
Rock vs. Papper: LOSE
Papper vs. Scissors: LOSE
Papper vs. Scissors: LOSE
Rock vs. Scissors: WIN
Rock vs. Papper: LOSE
Papper vs. Rock: WIN
Scissors vs. Papper: WIN
Papper vs. Scissors: LOSE
Papper vs. Scissors: LOSE
Papper vs. Scissors: LOSE
Papper vs. Scissors: LOSE
*/