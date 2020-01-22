/*
 * Chain of responsibility
 */
package bankomat;

/**
 *
 * @author AKravchuk
 */
public class BankomatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoteModule note1000 = new NoteModule1000();
        NoteModule note500 = new NoteModule500();
        NoteModule note200 = new NoteModule200();
        NoteModule note100 = new NoteModule100();
        NoteModule note50 = new NoteModule50();
        
        note1000.setNextMoneyModule(note500);
        note500.setNextMoneyModule(note200);
        note200.setNextMoneyModule(note100);
        note100.setNextMoneyModule(note50);
        
        note1000.takeMoney(new Money(49950));
        System.out.println("--------------");
        note1000.takeMoney(new Money(24600));
        System.out.println("--------------");
        //note1000.takeMoney(new Money(60000));
        note1000.takeMoney(new Money(12750));
    }
    
}

class Note {
    public static final int GR50 = 50;
    public static final int GR100 = 100;
    public static final int GR200 = 200;
    public static final int GR500 = 500;
    public static final int GR1000 = 1000;  
}

final class Money {
    private int amount;
    
    public Money(int amt) {
        setAmount(amt);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amt) {
        if (amt > 0 && amt <= 50000 && amt % Note.GR50 == 0) {
            this.amount = amt;
        }
        else {
            throw new RuntimeException("Сумма денег должна быть меньше 50000 и кратной 50");
        }
    }
}

abstract class NoteModule {
    protected NoteModule next;
    
    abstract void takeMoney(Money money);
    
    void setNextMoneyModule(NoteModule module) {
        this.next = module;
    }
}

class NoteModule1000 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.GR1000;
        int remind = money.getAmount() % Note.GR1000;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.GR1000);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    } 
}

class NoteModule500 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.GR500;
        int remind = money.getAmount() % Note.GR500;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.GR500);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    } 
}

class NoteModule200 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.GR200;
        int remind = money.getAmount() % Note.GR200;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.GR200);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    } 
}

class NoteModule100 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.GR100;
        int remind = money.getAmount() % Note.GR100;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.GR100);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    } 
}

class NoteModule50 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.GR50;
        int remind = money.getAmount() % Note.GR50;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.GR50);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    } 
}