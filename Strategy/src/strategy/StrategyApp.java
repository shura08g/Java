/*
 * Стратегия (англ. Strategy) — поведенческий шаблон проектирования,
 * предназначенный для определения семейства алгоритмов, инкапсуляции каждого 
 * из них и обеспечения их взаимозаменяемости. Это позволяет выбирать алгоритм 
 * путём определения соответствующего класса. Шаблон Strategy позволяет менять 
 * выбранный алгоритм независимо от объектов-клиентов, которые его используют.
 */
package strategy;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class StrategyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();
        
        int[] arr1 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        int[] arr2 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        int[] arr3 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        
        Sorting strategy = new BubbleSort(); 
        client.setStrategy(strategy);
        client.executeStrategy(arr1);
        
        strategy = new SelectionSort();
        client.setStrategy(strategy);
        client.executeStrategy(arr2);
        
        strategy = new InsertingSort();
        client.setStrategy(strategy);
        client.executeStrategy(arr3);

    }
}

//Context
class StrategyClient {
    Sorting strategy;
    
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting {
    void sort(int[] arr);
}

//Bubble sorting strategy
class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("--Bubble sort--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0; --barier) {
            for (int i = 0; i < barier; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

//Selection sorting strategy
class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("--Selection sort--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length; ++barier) {
            for (int i = barier + 1; i < arr.length; ++i) {
                if (arr[i] < arr[barier]) {
                    int temp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

//Inserting sorting strategy
class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("--Inserting sort--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; ++barier) {
            int index = barier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = temp;
                    --index;
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}