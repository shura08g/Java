package thinkinginjavach19;

enum Shruberry {
    GROUND,
    CRAWLING,
    HANGIN
}
public class EnumClass {
    public static void main(String[] args) {
        for (Shruberry s : Shruberry.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.print(s.compareTo(Shruberry.CRAWLING) + " ");
            System.out.print(s.equals(Shruberry.CRAWLING) + " ");
            System.out.println(s == Shruberry.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("------------------------");
        }
        
        // Получить значение из перечисления по строковому имени
        for (String s : "HANGIN CRAWLING GROUND".split(" ")) {
            Shruberry shrub = Enum.valueOf(Shruberry.class, s);
            System.out.println(shrub);
        }
    }
}
