/*
 * Заместитель (англ. Proxy / Surrogate) — структурный шаблон проектирования,
 * предоставляющий объект, который контролирует доступ к другому объекту, 
 * перехватывая все вызовы (выполняет функцию контейнера).
 */
package proxy;

/**
 *
 * @author AKravchuk
 */
public class ProxyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "D:/image.jpg";
        Image image = new RealImage(file);
        //Loading D:/image.jpg
        image.display();
        //View D:/image.jpg
        Image proxy = new ProxyImage(file);
        proxy.display();
        //Loading D:/image.jpg
        //View D:/image.jpg
    }
    
}

interface Image {
    void display();
}

class RealImage implements Image {
    
    String file;
    
    public RealImage(String file) {
        this.file = file;
        load();
    }
    
    void load() {
        System.out.println("Loading " + file);
    }

    @Override
    public void display() {
        System.out.println("View " + file);
    }
}

class ProxyImage implements Image {

    String file;
    RealImage image;
    
    public ProxyImage(String file) {
        this.file = file;
    }
    
    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
    
}