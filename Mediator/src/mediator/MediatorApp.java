/*
 * Посредник (англ. Mediator) — поведенческий шаблон проектирования,
 * обеспечивающий взаимодействие множества объектов, формируя при этом слабую
 * связанность и избавляя объекты от необходимости явно ссылаться друг на друга.
 */
package mediator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AKravchuk
 */
public class MediatorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User admin = new Admin(chat, "ADMIN");
        User user1 = new SimpleUser(chat, "User1");
        User user2 = new SimpleUser(chat, "User2");
        User user3 = new SimpleUser(chat, "User3");
        User user4 = new SimpleUser(chat, "User3");
        user2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);
        //chat.addUser(user4);  // User with name User3 already exists
        
        user1.sendMessage("Hello evrybody!!!");
        admin.sendMessage("Admin connected to chat");
    }
    
}


/*interface User {
    void sendMessage(String message);
    void getMessage(String message);
}*/

abstract class User {
    Chat chat;
    String name;
    boolean isEnable = true;
    
    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }
    
    public boolean isEnable() {
        return isEnable;
    }
    
    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }
    
    public String getName() {
        return name;
    }
    
    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    
    abstract void getMessage(String message);
    
    @Override
    public String toString(){
        return "User [name=" + name + "]";
    }
}

class Admin extends User {
    /*Chat chat;
    String name;*/
    
    public Admin(Chat chat, String name) {
        /*this.chat = chat;
        this.name = name;*/
        super(chat, name);
    }
    
    /*@Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }*/

    @Override
    public void getMessage(String message) {
        //System.out.println(name + " получает сообщение '" + message + "'");
        System.out.println(getName() + " администратор получает сообщение '" + message + "'");
    }
}

class SimpleUser extends User {
    /*Chat chat;
    String name;*/
    
    public SimpleUser(Chat chat, String name) {
        /*this.chat = chat;
        this.name = name;*/
        super(chat, name);
    }
    
    /*@Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }*/

    @Override
    public void getMessage(String message) {
        //System.out.println(name + " получает сообщение '" + message + "'");
        System.out.println(getName() + " получает сообщение '" + message + "'");
    }
}

interface Chat {
    void sendMessage(String message, User user);
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList();
    
    public void setAdmin(User admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        }
        else {
            throw new RuntimeException("Access denied");
        }
    }
    
    public void addUser(User user) {
        if (admin == null) {
            throw new RuntimeException("Admin don't assigned");
        }
        if (users.contains(user)) {
            throw new RuntimeException("User already exists");
        }
        for (User u : users) {
            if (user.getName().equals(u.getName())) {
                throw new RuntimeException("User with name " + user.getName() + " already exists");
            }
        }
        if (user instanceof SimpleUser) {
            users.add(user);
        }
        else {
            throw new RuntimeException("Админ не может входить в другой чат!");
        }
        
    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            users.forEach((u) -> {
                u.getMessage(user.getName() + ": " + message);
            });
        }
        if (user instanceof SimpleUser) {
            users.forEach((u) -> {
                if (u != user && u.isEnable()) {
                    u.getMessage(user.getName() + ": " + message);
                }
            });
            if (admin.isEnable()) {
                admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
    
}