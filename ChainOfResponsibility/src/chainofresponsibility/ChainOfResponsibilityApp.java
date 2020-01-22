/*
 * Цепочка обязанностей (англ. Chain of responsibility) — поведенческий шаблон
 * проектирования, предназначенный для организации в системе уровней ответственности.
 * 
 * Применение:
 * Шаблон рекомендован для использования в условиях:
 * - в разрабатываемой системе имеется группа объектов, которые могут обрабатывать
 *   сообщения определенного типа;
 * - все сообщения должны быть обработаны хотя бы одним объектом системы;
 * - сообщения в системе обрабатываются по схеме «обработай сам либо перешли
 *   другому», то есть одни сообщения обрабатываются на том уровне, где они
 *   получены, а другие пересылаются объектам иного уровня.
 */
package chainofresponsibility;

/**
 *
 * @author AKravchuk
 */
public class ChainOfResponsibilityApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*SMSLogger loger = new SMSLogger(Level.ERROR);
        FileLogger fLogger = new FileLogger(Level.DEBUG);
        EmailLogger eLogger = new EmailLogger(Level.INFO);*/
        Logger loger = new SMSLogger(Level.ERROR);
        Logger fLogger = new FileLogger(Level.DEBUG);
        Logger eLogger = new EmailLogger(Level.INFO);
        loger.setNext(fLogger);
        fLogger.setNext(eLogger);
        
        loger.writeMessage("All good", Level.INFO);
        loger.writeMessage("Debug mode", Level.DEBUG);
        loger.writeMessage("System shutdown", Level.ERROR);
    }
    
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

/*interface Logger {
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger {
    int priority;
    
    public SMSLogger(int priority) {
        this.priority = priority;
    }
    
    private Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
    
    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("SMS: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class FileLogger implements Logger {
    int priority;
    
    public FileLogger(int priority) {
        this.priority = priority;
    }
    
    private Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
    
    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Write to file: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class EmailLogger implements Logger {
    int priority;
    
    public EmailLogger(int priority) {
        this.priority = priority;
    }
    
    private Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
    
    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Write to email: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}*/

abstract class Logger {
    int priority;
    private Logger next;
    
    public Logger(int priority) {
        this.priority = priority;
    }
    
    public void setNext(Logger next) {
        this.next = next;
    }
    
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
    
    abstract void write(String message);
}

class SMSLogger extends Logger {
   
    public SMSLogger(int priority) {
        super(priority);
    } 
    
    @Override
    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger {
    
    public FileLogger(int priority) {
        super(priority);
    }
    
    @Override
    public void write(String message) {
        System.out.println("Write to file: " + message);
    }
}

class EmailLogger extends Logger {
    
    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Write to email: " + message);
    }
}