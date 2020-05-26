/*
 * Collections
 */
package thinkinginjavach11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author AKravchuk
 */
public class thinkinginjavach11 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            //((Apple)apples.get(i)).id();  //ClassCastException
        }
        
        ArrayList<Apple> apples2 = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples2.add(new Apple());
        }
        // apples2.add(new Orange());
        for (int i = 0; i < apples2.size(); i++) {
            System.out.println(apples2.get(i).id());  
        }
        
        Collection<Integer> collection = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        
        // работает быстрее
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        
        collection.forEach((i) -> {
            System.out.print(i + " ");  // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 6 7 8 9 10 
        });
        
        System.out.println();
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        list.forEach((i) -> {
            System.out.print(i+ " "); // 16 99 18 19 20
        });
        //list.add(55);  // UnsupportedOperationException
        
        System.out.println();
        Stack<String> stack = new Stack();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        
        while (!stack.empty()) {
            System.out.print(stack.pop() + " "); // fleas has dog My
        }
        
        System.out.println();
        Random rand = new Random();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
    
}

class Stack<T> {
    private LinkedList<T> storage = new LinkedList();
    
    public void push(T v) {
        storage.addFirst(v);
    }
    
    public T peek() {
        return storage.getFirst();
    }
    
    public T pop() {
        return storage.removeFirst();
    }
    
    public boolean empty() {
        return storage.isEmpty();
    }
    
    @Override
    public String toString() {
        return storage.toString();
    }
}

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() {
        return id;
    }
}

class Orange {}