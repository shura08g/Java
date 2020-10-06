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
import java.util.Map;
import java.util.HashMap;

class ParseMolecule {

    public static Map<String, Integer> getAtoms(String formula) {
        if (!Character.isUpperCase(formula.charAt(0))) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> result = new HashMap<>();
        String[] splitStr = parse(formula);
        int multiply = 1;
        boolean round_brekets = false;
        boolean square_brekets = false;
        boolean curly_brekets = false;
        boolean round_brekets_close = false;
        boolean square_brekets_close = false;
        boolean curly_brekets_close = false;
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
                if (splitStr[i].equals("(")) round_brekets = true;
                if (splitStr[i].equals("[")) square_brekets = true;
                if (splitStr[i].equals("{")) curly_brekets = true;
                int index = findCloseBracket(splitStr, splitStr[i]);
                if (i < splitStr.length && isNumeric(splitStr[index + 1])) {
                    multiply *= Integer.parseInt(splitStr[index + 1]);
                } else multiply = 1;
            }
            if (splitStr[i].equals(")") || splitStr[i].equals("]") || splitStr[i].equals("}")) {
                if (splitStr[i].equals(")")) round_brekets_close = true;
                if (splitStr[i].equals("]")) square_brekets_close = true;
                if (splitStr[i].equals("}")) curly_brekets_close = true;
                if (splitStr[i].equals(")") && !round_brekets) throw new IllegalArgumentException();
                if (splitStr[i].equals("]") && !square_brekets) throw new IllegalArgumentException();
                if (splitStr[i].equals("}") && !curly_brekets) throw new IllegalArgumentException();
                multiply = 1;
            }
        }

        return result;
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

    public static int findCloseBracket(String[] arrStr, String bracket) {
        int start = 0;
        int finish = 0;
        if ("(".equals(bracket)) {
            for (int i = 0; i < arrStr.length; i++) {
                if ("(".equals(arrStr[i])) {
                    start = i;
                }
                if (")".equals(arrStr[i])) {
                    finish = i;
                }
            }
        }
        if ("[".equals(bracket)) {
            for (int i = 0; i < arrStr.length; i++) {
                if ("[".equals(arrStr[i])) {
                    start = i;
                }
                if ("]".equals(arrStr[i])) {
                    finish = i;
                }
            }
        }
        if ("{".equals(bracket)) {
            for (int i = 0; i < arrStr.length; i++) {
                if ("{".equals(arrStr[i])) {
                    start = i;
                }
                if ("}".equals(arrStr[i])) {
                    finish = i;
                }
            }
        }
        if (finish < start) {
            throw new IllegalArgumentException();
        }
        return finish;
    }

    public static void main(String[] args) {
//        System.out.println("H2O");
//        System.out.println(ParseMolecule.getAtoms("H2O"));  // {H=2, O=1}
//        System.out.println("Mg(OH)2");
//        System.out.println(ParseMolecule.getAtoms("Mg(OH)2"));  // {H=2, Mg=1, O=2}
//        System.out.println("K4[ON(SO3)2]2");
//        System.out.println(ParseMolecule.getAtoms("K4[ON(SO3)2]2"));  // {S=4, K=4, N=2, O=14}
//        System.out.println("C6H12O6");
//        System.out.println(ParseMolecule.getAtoms("C6H12O6"));  // {C=6, H=12, O=6}
//        System.out.println("As2{Be4C5[BCo3(CO2)3]2}4Cu5  {As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}");
//        System.out.println(ParseMolecule.getAtoms("As2{Be4C5[BCo3(CO2)3]2}4Cu5"));  // {As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}
//        System.out.println("C2H2(COOH)2");
//        System.out.println(ParseMolecule.getAtoms("C2H2(COOH)2")); // {C=4, H=4, O=4}
//        System.out.println(ParseMolecule.getAtoms("pie")); //IllegalArgumentException
//        System.out.println(ParseMolecule.getAtoms("MgOH)2")); //IllegalArgumentException
        System.out.println("Au5(C2H5[OH)3Li]3");
        System.out.println(ParseMolecule.getAtoms("Au5(C2H5[OH)3Li]3")); // IllegalArgumentException
    }
}
