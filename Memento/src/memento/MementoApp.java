/*
 * Хранитель (англ. Memento) — поведенческий шаблон проектирования, позволяющий,
 * не нарушая инкапсуляцию, зафиксировать и сохранить внутреннее состояние
 * объекта так, чтобы позднее восстановить его в это состояние.
 */
package memento;

/**
 *
 * @author AKravchuk
 */
public class MementoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.set("LVL_1", 30000);
        System.out.println(game);
        
        File file = new File();
        file.setSave(game.save());
        game.set("LVL_2", 60000);
        System.out.println(game);
        
        System.out.println("Loading game...");
        game.load(file.getSave());
        System.out.println(game);
        
    }
    
}

class Game {
    private String level;
    private int ms;
    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    
    public void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }
    
    public Save save() {
        return new Save(level, ms);
    }
    
    @Override
    public String toString(){
        return "Game [level=" + level + ", ms=" + ms + "]";
    }
}

class Save {
    private final String level;
    private final int ms;
    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }    
}

class File {
    Save save;
    
    public Save getSave() {
        return save;
    }
    
    public void setSave(Save save) {
        this.save = save;
    }
}