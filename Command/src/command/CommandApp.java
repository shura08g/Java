/*
 * Команда (англ. Command) — поведенческий шаблон проектирования, используемый
 * при объектно-ориентированном программировании, представляющий действие.
 * Объект команды заключает в себе само действие и его параметры.
 */
package command;


/**
 *
 * @author AKravchuk
 */
public class CommandApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
        
        user.startComputer();
        user.resetComputer();
        user.stopComputer();
    }
    
}

interface Command {
    void execute();
}


//Reciver
class Comp {
    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }
    void reset() {
        System.out.println("Reset");
    }
}

//ConcreteCommand
class StartCommand implements Command {
    Comp computer;
    
    public StartCommand(Comp comp) {
        this.computer = comp;
    }

    @Override
    public void execute() {
        computer.start();
    }   
}

class StopCommand implements Command {
    Comp computer;
    
    public StopCommand(Comp comp) {
        this.computer = comp;
    }

    @Override
    public void execute() {
        computer.stop();
    }   
}

class ResetCommand implements Command {
    Comp computer;
    
    public ResetCommand(Comp comp) {
        this.computer = comp;
    }

    @Override
    public void execute() {
        computer.reset();
    }   
}

//Invoker
class User {
    Command start;
    Command stop;
    Command reset;
    
    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    
    void startComputer() {
        start.execute();
    }
    
    void stopComputer() {
        stop.execute();
    }
    
    void resetComputer() {
        reset.execute();
    }
}