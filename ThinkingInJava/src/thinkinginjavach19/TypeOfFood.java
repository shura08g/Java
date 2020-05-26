package thinkinginjavach19;

import static thinkinginjavach19.Food.*;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        System.out.println(food);
        food = MainCourse.LASAGNE;
        System.out.println(food);
        food = Dessert.GELATO;
        System.out.println(food);
        food = Coffee.CAPPUCCINO;
        System.out.println(food);
    }
}
