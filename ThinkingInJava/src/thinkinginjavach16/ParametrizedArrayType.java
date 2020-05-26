package thinkinginjavach16;

import java.util.Arrays;

class ClassParametr<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParametr {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class ParametrizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParametr<Integer>().f(ints);
        Double[] doubles2 = new ClassParametr<Double>().f(doubles);
        
        System.out.println(Arrays.toString(ints)); //[1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(doubles)); //[1.1, 2.2, 3.3, 4.4, 5.5]
        System.out.println(Arrays.toString(ints2)); //[1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(doubles2)); //[1.1, 2.2, 3.3, 4.4, 5.5]
        
        Integer[] ints3 = MethodParametr.f(ints);
        Double[] doubles3 = MethodParametr.f(doubles);
        System.out.println(Arrays.toString(ints3)); //[1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(doubles3)); //[1.1, 2.2, 3.3, 4.4, 5.5]
    }
}
