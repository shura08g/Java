package thinkinginjavach16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la; // Warning
        ls[0] = new ArrayList<String>();
        ls[1] = new ArrayList<String>(Arrays.asList("String"));
        //! ls[2] = new ArrayList<Integer>(); // error
        System.out.println(Arrays.toString(ls));
        
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>(Arrays.asList(100));
        objects[2] = new ArrayList<Integer>();
        
        System.out.println(Arrays.toString(objects));
        
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }
}
