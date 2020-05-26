/*
 * {Args: thinkinginjavach14.ShowMethods}
 */
package thinkinginjavach14;

import java.lang.reflect.*;
import java.util.regex.*;

public class ShowMethods {
    private static String usage = "usage:\n" +
                                  "ShowMethods qualified.classs.name\n" +
                                  "To show all methods in class or:\n" +
                                  "ShowMethods qualified.classs.name word\n" +
                                  "To search for mrthods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");
    static String[] args = {"thinkinginjavach14.ShowMethods"};
    
    public static void main(String[] args2) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c.toString());
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor ctor : ctors) {
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            } 
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}

/*
Output:

public static void main(String[])
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
*/