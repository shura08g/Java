package thinkinginjavach18;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
    private int n;
    
    public Data(int n) {
        this.n = n;
    }
    
    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class SerializeTest implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {new Data(rand.nextInt(10)),
                        new Data(rand.nextInt(10)),
                        new Data(rand.nextInt(10))};
    private SerializeTest next;
    private char c;
    
    // значение i равно количеству сегментов
    public SerializeTest(int i, char x) {
        System.out.println("SerializeTest constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new SerializeTest(i, (char)(x + 1));
        }
    }
    
    public SerializeTest() {
        System.out.println("Default constructor");
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d) {
            result.append(dat);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String filename = "test_serialize.out";
        SerializeTest st = new SerializeTest(6, 'a');
        System.out.println("st = " + st);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject("SerializeTest storage\n");
        out.writeObject(st);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        String s = (String)in.readObject();
        SerializeTest st2 = (SerializeTest)in.readObject();
        System.out.println(s + "st2 = "+ st2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("SerializeTest storage\n");
        out2.writeObject(st);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        SerializeTest st3 = (SerializeTest)in2.readObject();
        System.out.println(s + "st3 = "+ st3);

    }
}
