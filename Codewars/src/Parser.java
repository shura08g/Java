
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
In this kata we want to convert a string into an integer. The strings simply 
represent the numbers in words.

Examples:

"one" => 1
"twenty" => 20
"two hundred forty-six" => 246
"seven hundred eighty-three thousand nine hundred and nineteen" => 783919
Additional Notes:

The minimum number is "zero" (inclusively)
The maximum number, which must be supported is 1 million (inclusively)
The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's 
present and in others it's not
All tested numbers are valid, you don't need to validate them

 */
public class Parser {
    
    public static int parseInt(String numStr) {
        String[] numArray = numStr.split("[ |-]");
        int number = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);
        
        for (int i = 0; i < numArray.length; i++) {
            for (String key : map.keySet()) {
                if (numArray[i].toLowerCase().equals(key)) {
                    if (map.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (map.get(key));
                    }
                    else if (map.get(key) > 100)
                        number *= (map.get(key));
                    else
                        number += map.get(key);
                      break;
                }
            }
        }
        return number;
    }

    private static final String[] numNames = {"", "one", "two", "three",
        "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
        "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"
    };

    private static final List<String> numList = Arrays.asList(numNames);

    private static final String[] tensNames = {"", "tens", "twenty", "thirty",
        "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final List<String> tensList = Arrays.asList(tensNames);

    public static int parseInt2(String numStr) {
        int result = 0;
        boolean million = false;
        boolean thousand = false;
        String[] arrNums = numStr.split(" |-");
        for (String num : arrNums) {
            int temp = 0;
            switch (num) {
                case "hundred":
                    if (thousand) {
                        temp = result % 1000;
                        result += temp * 100;
                        result -= temp;
                    } else {
                        result *= 100;
                    }
                    break;
                case "thousand":
                    thousand = true;
                    if (million) {
                        temp = result % 1000000;
                        result += temp * 1000;
                        result -= temp;
                    } else {
                        result *= 1000;
                    }
                    break;
                case "million":
                    million = true;
                    result *= 1000000;
                    break;
                default:
                    break;
            }
            if (numList.contains(num)) {
                result += numList.indexOf(num);
            }
            if (tensList.contains(num)) {
                result += tensList.indexOf(num) * 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Parser.parseInt("one"));
        System.out.println(Parser.parseInt("ten"));
        System.out.println(Parser.parseInt("twenty"));
        System.out.println(Parser.parseInt("two hundred forty-six"));
        System.out.println(Parser.parseInt("six thousand six hundred eighty-three"));
        System.out.println(Parser.parseInt("one thousand three hundred thirty-seven"));
        System.out.println(Parser.parseInt("two thousand"));
    }
}
