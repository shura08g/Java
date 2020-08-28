/*
Complete the solution so that the function will break up camel casing, using a 
space between words.

Example
solution("camelCasing")  ==  "camel Casing"
 */

public class BreakСamelCase {

    public static String camelCase(String input) {
        String result = "";
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            if (Character.isUpperCase(ch))
                result += " ";
            result += "" + ch;
        }
        return result;
    }
    
    public static String camelCase2(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }
    
    public static void main(String[] args) {
        System.out.println(BreakСamelCase.camelCase("camelCasing"));
        System.out.println(BreakСamelCase.camelCase("camelCasingTest"));
        System.out.println(BreakСamelCase.camelCase("camelcasingtest"));
        
        System.out.println(BreakСamelCase.camelCase2("camelCasing"));
        System.out.println(BreakСamelCase.camelCase2("camelCasingTest"));
        System.out.println(BreakСamelCase.camelCase2("camelcasingtest"));
    }
}
