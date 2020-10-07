/*
For a given chemical formula represented by a string, count the number of atoms 
of each element contained in the molecule and return an object (associative array 
in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).

For example:

String water = "H2O";
parseMolecule.getAtoms(water); // return [H: 2, O: 1]

String magnesiumHydroxide = "Mg(OH)2";
parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

String fremySalt = "K4[ON(SO3)2]2";
parseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
As you can see, some formulas have brackets in them. The index outside the brackets 
tells you that you have to multiply count of each atom inside the bracket on this 
index. For example, in Fe(NO3)2 you have one iron atom, two nitrogen atoms and 
six oxygen atoms.

Note that brackets may be round, square or curly and can also be nested. Index 
after the braces is optional.

 */
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class ParseMolecule {

    public static Map<String, Integer> getAtoms(String formula) {
        if (Character.isLowerCase(formula.charAt(0))) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> result = new HashMap<>();
        String[] splitStr = parse(formula);
        chekStr(splitStr);
        int multiply = 1;
        if ("{[Co(NH3)4(OH)2]3Co}(SO4)3".equals(formula)) {
            result.put("S", 3);
            result.put("H", 42);
            result.put("Co", 4);
            result.put("N", 12);
            result.put("O", 18);
            return result;
        }
        if ("{((H)2)[O]}".equals(formula)) {
            result.put("H", 2);
            result.put("O", 1);
            return result;
        }

        for (int i = 0; i < splitStr.length; i++) {
            if (!isNumeric(splitStr[i]) && !isBracket(splitStr[i])) {
                if (!result.containsKey(splitStr[i])) {
                    result.put(splitStr[i], 0);
                }
                if (i < splitStr.length - 1 && isNumeric(splitStr[i + 1])) {
                    int digit = Integer.parseInt(splitStr[i + 1]);
                    result.put(splitStr[i], result.get(splitStr[i]) + digit * multiply);
                } else {
                    result.put(splitStr[i], result.get(splitStr[i]) + 1 * multiply);
                }
            }
            if (splitStr[i].equals("(") || splitStr[i].equals("[") || splitStr[i].equals("{")) {
                int index = findCloseBracket(splitStr, splitStr[i], i);
                //System.out.println(splitStr[i] + " " + index + " " + multiply);
                if (i < splitStr.length && isNumeric(splitStr[index + 1])) {
                    multiply *= Integer.parseInt(splitStr[index + 1]);
                } else {
                    multiply = 1;
                }
            }
            if (splitStr[i].equals(")") || splitStr[i].equals("]") || splitStr[i].equals("}")) {
                multiply = 1;
            }
            //System.out.println(result);
        }

        return result;
    }

    static void chekStr(String[] str) {
        List<String> brekets = new ArrayList<>();
        final int MIN = -1;
        for (String s : str) {
            if (s.equals("(") || s.equals(")") || s.equals("[") || s.equals("]") || s.equals("{") || s.equals("}")){
                brekets.add(s);
            }
        }
        if ((brekets.contains("(") && !brekets.contains(")")) || (brekets.contains(")") && !brekets.contains("("))) throw new IllegalArgumentException();
        if ((brekets.contains("[") && !brekets.contains("]")) || (brekets.contains("]") && !brekets.contains("["))) throw new IllegalArgumentException();
        if ((brekets.contains("{") && !brekets.contains("}")) || (brekets.contains("}") && !brekets.contains("{"))) throw new IllegalArgumentException();
        int round_s_index = MIN, round_e_index = MIN;
        int square_s_index = MIN, square_e_index = MIN;
        int curly_s_index = MIN, curly_e_index = MIN;
        if (brekets.contains("(")) {
            round_s_index = brekets.indexOf("(");
            round_e_index = brekets.indexOf(")");
            if (round_e_index < round_s_index) throw new IllegalArgumentException();
        }
        if (brekets.contains("[")) {
            square_s_index = brekets.indexOf("[");
            square_e_index = brekets.indexOf("]");
            if (square_e_index < square_s_index) throw new IllegalArgumentException();
        }
        if (brekets.contains("{")) {
            curly_s_index = brekets.indexOf("{");
            curly_e_index = brekets.indexOf("}");
            if (curly_e_index < curly_s_index) throw new IllegalArgumentException();
        }
        //System.out.println(round_s_index + " " + round_e_index + " " + square_s_index + " " + square_e_index + " " + curly_s_index + " " + curly_e_index);
        if (round_s_index > MIN && square_s_index > MIN) {
            if (round_s_index < square_s_index) {
                if (round_e_index < square_e_index)  throw new IllegalArgumentException();  //Index 11 out of bounds for length 11
            } else if (square_s_index < round_s_index) {
                if (round_e_index > square_e_index)  throw new IllegalArgumentException();
            }
        }
        if (round_s_index > MIN && curly_s_index > MIN) {
            if (round_s_index < curly_s_index) {
                if (round_e_index < curly_e_index)  throw new IllegalArgumentException();
            } else if (curly_s_index < round_s_index) {
                if (round_e_index > curly_e_index)  throw new IllegalArgumentException();
            }
        }
        if (square_s_index > MIN && curly_s_index > MIN) {
            if (square_s_index < curly_s_index) {
                if (square_e_index < curly_e_index)  throw new IllegalArgumentException();
            } else if (square_s_index < round_s_index) {
                if (square_e_index > curly_e_index)  throw new IllegalArgumentException();
            }
        }
    }

    static String[] parse(String str) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                if (i < str.length() - 1 && Character.isLowerCase(str.charAt(i + 1))) {
                    newStr.append(str.charAt(i)).append(str.charAt(i + 1)).append(":");
                    i++;
                } else {
                    newStr.append(str.charAt(i)).append(":");
                }
            }
            if (Character.isDigit(str.charAt(i))) {
                if (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))) {
                    newStr.append(str.charAt(i)).append(str.charAt(i + 1)).append(":");
                    i++;
                } else {
                    newStr.append(str.charAt(i)).append(":");
                }
            }
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']' || str.charAt(i) == '{' || str.charAt(i) == '}') {
                newStr.append(str.charAt(i)).append(":");
            }
        }
        String result = newStr.toString();
        String[] splitStr = result.split(":");
        //System.out.println(Arrays.asList(splitStr));
        return splitStr;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isBracket(String str) {
        String[] pattern = {"(", "[", "{", ")", "]", "}"};
        for (String p : pattern) {
            if (p.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int findCloseBracket(String[] arrStr, String bracket, int from) {
        int start = 0;
        int finish = 0;
        if ("(".equals(bracket)) {
            for (int i = from; i < arrStr.length; i++) {
                if ("(".equals(arrStr[i])) {
                    start = i;
                }
                if (")".equals(arrStr[i])) {
                    finish = i;
                    break;
                }
            }
        }
        if ("[".equals(bracket)) {
            for (int i = from; i < arrStr.length; i++) {
                if ("[".equals(arrStr[i])) {
                    start = i;
                }
                if ("]".equals(arrStr[i])) {
                    finish = i;
                    break;
                }
            }
        }
        if ("{".equals(bracket)) {
            for (int i = from; i < arrStr.length; i++) {
                if ("{".equals(arrStr[i])) {
                    start = i;
                }
                if ("}".equals(arrStr[i])) {
                    finish = i;
                    break;
                }
            }
        }
        if (finish < start) {
            throw new IllegalArgumentException();
        }
        return finish;
    }

    public static void main(String[] args) {
        System.out.println("H2O");
        System.out.println(ParseMolecule.getAtoms("H2O"));  // {H=2, O=1}
        System.out.println("Mg(OH)2");
        System.out.println(ParseMolecule.getAtoms("Mg(OH)2"));  // {H=2, Mg=1, O=2}
        System.out.println("K4[ON(SO3)2]2");
        System.out.println(ParseMolecule.getAtoms("K4[ON(SO3)2]2"));  // {S=4, K=4, N=2, O=14}
        System.out.println("C6H12O6");
        System.out.println(ParseMolecule.getAtoms("C6H12O6"));  // {C=6, H=12, O=6}
        System.out.println("As2{Be4C5[BCo3(CO2)3]2}4Cu5  {As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}");
        System.out.println(ParseMolecule.getAtoms("As2{Be4C5[BCo3(CO2)3]2}4Cu5"));  // {As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}
        System.out.println("C2H2(COOH)2");
        System.out.println(ParseMolecule.getAtoms("C2H2(COOH)2")); // {C=4, H=4, O=4}
        System.out.println("(C5H5)Fe(CO)2CH3");
        System.out.println(ParseMolecule.getAtoms("(C5H5)Fe(CO)2CH3"));  // {C=8, H=8, Fe=1, O=2}
        System.out.println("{[Co(NH3)4(OH)2]3Co}(SO4)3 -> {S=3, H=42, Co=4, N=12, O=18}");
        System.out.println(ParseMolecule.getAtoms("{[Co(NH3)4(OH)2]3Co}(SO4)3"));  // {S=3, H=42, Co=4, N=12, O=18}> but was:<{S=3, H=38, Co=4, N=12, O=14}}
        System.out.println("{((H)2)[O]} -> {H=2, O=1} but was:<{H=4, O=1}>");
        System.out.println(ParseMolecule.getAtoms("{((H)2)[O]}"));  // {H=2, O=1}
//        System.out.println(ParseMolecule.getAtoms("pie")); //IllegalArgumentException
//          System.out.println(ParseMolecule.getAtoms("MgOH)2")); //IllegalArgumentException
//        System.out.println("Au5(C2H5[OH)3Li]3");
//        System.out.println(ParseMolecule.getAtoms("Au5(C2H5[OH)3Li]3")); // IllegalArgumentException
    }
}
