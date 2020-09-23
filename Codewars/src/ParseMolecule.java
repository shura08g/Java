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
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class ParseMolecule {
    
    public static Map<String,Integer> getAtoms(String formula) {
        if (!Character.isUpperCase(formula.charAt(0))) throw new IllegalArgumentException();
        Map<String,Integer> result = new HashMap<String,Integer>();
        int multiply = 1;
        boolean round_brekets = false;
        boolean square_brekets = false;
        boolean curly_brekets = false;
        for (int i = 0; i < formula.length(); i++) {
            char sym = formula.charAt(i);
            char nextSym = ' ';
            if (i != formula.length() - 1) {
                nextSym = formula.charAt(i + 1);
            }
            if (sym == '(') {
                int pos = formula.indexOf(")", i);
                if (pos == -1) throw new IllegalArgumentException();
                int square_pos = formula.indexOf("]");
                int curly_pos = formula.indexOf("}");
                if (!square_brekets && square_pos > pos) throw new IllegalArgumentException();
                if (!curly_brekets && curly_pos > pos) throw new IllegalArgumentException();
                if (pos < formula.length() - 1 && Character.isDigit(formula.charAt(pos + 1))) {
                    multiply *= Integer.parseInt("" + formula.charAt(pos + 1));
                } else {multiply = 1;}
                round_brekets = true;
            }
            if (sym == '[') {
                int pos = formula.indexOf("]", i);
                if (pos == -1) throw new IllegalArgumentException();
                int round_pos = formula.indexOf(")");
                int curly_pos = formula.indexOf("}");
                if (!round_brekets && round_pos > pos) throw new IllegalArgumentException();
                if (!curly_brekets && curly_pos > pos) throw new IllegalArgumentException();
                if (pos < formula.length() - 1 && Character.isDigit(formula.charAt(pos + 1))) {
                    multiply *= Integer.parseInt("" + formula.charAt(pos + 1));
                } else {multiply = 1;}
                square_brekets = true;
            }
            if (sym == '{') {
                int pos = formula.indexOf("}", i);
                if (pos == -1) throw new IllegalArgumentException();
                int square_pos = formula.indexOf("]");
                int round_pos = formula.indexOf(")");
                if (!square_brekets && square_pos > pos) throw new IllegalArgumentException();
                if (!round_brekets && round_pos > pos) throw new IllegalArgumentException();
                if (pos < formula.length() - 1 && Character.isDigit(formula.charAt(pos + 1))) {
                    multiply *= Integer.parseInt("" + formula.charAt(pos + 1));
                } else {multiply = 1;}
                curly_brekets = true;
            }
            if (sym == ')' && !round_brekets) throw new IllegalArgumentException();
            if (sym == ']' && !square_brekets) throw new IllegalArgumentException();
            if (sym == '}' && !curly_brekets) throw new IllegalArgumentException();
            

            
            if (Character.isUpperCase(sym)) {
                if (Character.isUpperCase(nextSym) || nextSym == ' ' || nextSym == ')' || nextSym == ']' || nextSym == '}' || nextSym == ' ' || nextSym == '(' || nextSym == '[' || nextSym == '{') {
                    result.put("" + sym, 1 * multiply);
                }
                if (Character.isDigit(nextSym)) {
                    int digit = Integer.parseInt("" + nextSym);
                    if (i < formula.length() - 2 && Character.isDigit(formula.charAt(i + 2))) {
                        digit = Integer.parseInt("" + nextSym + formula.charAt(i + 2));
                        i++;
                    }
                    if (!result.containsKey("" + sym)) {
                        result.put("" + sym, 0 * multiply);
                    }
                    result.put("" + sym, result.get("" + sym) + digit * multiply);
                }
                if (Character.isLowerCase(nextSym)) {
                    int digit = 1;
                    if (i < formula.length() - 2 && Character.isDigit(formula.charAt(i + 2))) {
                        digit = Integer.parseInt("" + formula.charAt(i + 2));
                        i++;
                    }
                    result.put("" + sym + nextSym , 1 * multiply * digit );
                    i++;
                }
            }
            System.out.println(result + " " + sym + " " + nextSym + " " + multiply);
        }
        return result;
    }
    
    static void parse(Map<String,Integer> map, String str) {
        //String[] splitStr = str.split("(?=[A-Z])");
        String[] splitStr = str.split("(?=[A-Z][a-z]*)([0-9]*)");
        System.out.println(Arrays.asList(splitStr));
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
        System.out.println("As2{Be4C5[BCo3(CO2)3]2}4Cu5  {As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}");
        System.out.println(ParseMolecule.getAtoms("As2{Be4C5[BCo3(CO2)3]2}4Cu5"));  // {As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}
        System.out.println("C2H2(COOH)2");
        System.out.println(ParseMolecule.getAtoms("C2H2(COOH)2")); // {C=4, H=4, O=4}
//        System.out.println(ParseMolecule.getAtoms("pie"));
//        System.out.println("Au5(C2H5[OH)3Li]3");
//        System.out.println(ParseMolecule.getAtoms("Au5(C2H5[OH)3Li]3"));
    }
}
