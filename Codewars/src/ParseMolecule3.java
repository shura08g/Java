import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParseMolecule3 {

     public static void main(String[] args) {
           Map<String, Integer> resultMap = getAtoms("As2{Be4C5[BCo3(CO2)3]2}4Cu5");
           for (Map.Entry<String, Integer> pair : resultMap.entrySet()) {
                System.out.println("Key: " +pair.getKey()+ " Value: " + pair.getValue() );
           }
     }

     public static Map<String, Integer> parseMoleculeHelper( String name, int times) {
           Map<String, Integer> resultMap = new HashMap<>();
//         if (name.charAt(0) == '[' ||name.charAt(0) == '(' ||name.charAt(0) == '{' ) {
           System.out.println("-----------------------");
           if (name.matches("^\\[.*\\]$|^\\{.*\\}$|^\\(.*\\)$") ) {
                System.out.println("matches {, [ or ( ");
                System.out.println(name);
                System.out.println(times);
                String sunstring = name.substring(1, name.length() - 1);
                Map<String, Integer> tempMap = parseMoleculeHelper(resultMap, sunstring);
                for (Map.Entry<String, Integer> pair : tempMap.entrySet()) {
                     String elementkey = pair.getKey();
                     resultMap.put(elementkey, pair.getValue() * times);
                }
           } else if (name.matches("^[A-Z][a-z]*$")){
                System.out.println(name);
                System.out.println(times);
                     resultMap.put(name, times);
           }else {
                throw new IllegalArgumentException();
           }
           return resultMap;
     }
        public static boolean balancedParenthensies(String s) {
             Stack<Character> stack  = new Stack<Character>();
             for(int i = 0; i < s.length(); i++) {
                 char c = s.charAt(i);
                 if(c == '[' || c == '(' || c == '{' ) {     
                     stack.push(c);
                 } else if(c == ']') {
                     if(stack.isEmpty() || stack.pop() != '[') {
                         return false;
                     }
                 } else if(c == ')') {
                     if(stack.isEmpty() || stack.pop() != '(') {
                         return false;
                     }           
                 } else if(c == '}') {
                     if(stack.isEmpty() || stack.pop() != '{') {
                         return false;
                     }
                 }

             }
             return stack.isEmpty();
         }
     public static Map<String, Integer> parseMoleculeHelper(Map<String, Integer> resultMap, String name) {
           Pattern pattern = Pattern.compile("([A-Z][a-z]*|\\([^\\)]*\\)|\\[[^\\]]*\\]|\\{[^\\}]*\\})([0-9]*)");
           Matcher matcher = pattern.matcher(name);
           while (matcher.find()) {
                System.out.println("-----------------------");
                System.out.println(matcher.group(0));

                String sunstring = matcher.group(1);
                System.out.println(sunstring);
                String atomAmount = matcher.group(2);
                int atomAmountInt = 1;
                if ((atomAmount != null) && (!atomAmount.isEmpty())) {
                     atomAmountInt = Integer.valueOf(atomAmount);
                }
                System.out.println(atomAmountInt);

                Map<String, Integer> tempMap = parseMoleculeHelper(sunstring, atomAmountInt);
                for (Map.Entry<String, Integer> pair : tempMap.entrySet()) {
                     String elementkey = pair.getKey();
                     Integer temp = resultMap.get(pair.getKey());
                     if (temp != null) {
                           resultMap.put(elementkey, temp + pair.getValue());
                     } else {
                           resultMap.put(elementkey, pair.getValue());
                     }
                }
           }
           return resultMap;
     }
     public static Map<String, Integer> getAtoms(String name) {
           if(!balancedParenthensies(name)) {
                throw new IllegalArgumentException();
           };
           if(name.matches("^[a-z].*$")) {
                throw new IllegalArgumentException();
           };
           Map<String, Integer> tempMap = new HashMap<>();
           return parseMoleculeHelper(tempMap, name);
     }

}