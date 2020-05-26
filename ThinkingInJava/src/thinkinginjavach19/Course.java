package thinkinginjavach19;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSET(Food.Dessert.class),
    COFFE(Food.Coffee.class);
    
    private Food[] values;
    
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    
    public Food randomSelection() {
        return Enums.random(values);
    }
            
}
