import java.util.Map;
import java.util.HashMap;

class ParseMolecule4 {

  public static String getSubstr(String string) {
    HashMap<Character, Character> braces = new HashMap<>();
    char brace=string.charAt(0);
    braces.put('(', ')');
    braces.put('{', '}');
    braces.put('[', ']');
    int i = 1, count = 0;
    String res = "";
    char ch;
    while (i<string.length()) {
      ch = string.charAt(i);
      if (ch == brace) {
        count++;
      }
      if (ch == braces.get(brace)) {
        if (count == 0) return res;
        count--;
      }
      res += ch;
      i++;
    }
    if(i==string.length()) throw new IllegalArgumentException();
    return res;
  }

  public static void recFunction(String f, HashMap<String, Integer> res) {

    int i = 0, mult;
    char ch;
    String substr,multstr;
    while (i < f.length()) {
      substr = "";
      multstr="";
      mult=1;
      ch = f.charAt(i);
      if ((ch == '(') || (ch == '{') || (ch == '[')) {
        substr=getSubstr(f.substring(i));
        i+=substr.length()+1;
      }
      else if (Character.isUpperCase(ch)){
        substr+=ch;
        while ((i+1<f.length()) && (Character.isLowerCase(f.charAt(i+1)))){
          i++;
          substr+=f.charAt(i);
        }
      }
      else throw new IllegalArgumentException();
      if(f.compareTo(substr)==0) {
        {
          if (!res.containsKey(f)) res.put(f, 1);
          else res.put(f, res.get(f) + 1);
          return;
        }
      }

      if((i+1<f.length()) && (Character.isDigit(f.charAt(i+1)))) {
        while ((i + 1 < f.length()) && (Character.isDigit(f.charAt(i + 1)))) {
          i++;
          multstr += f.charAt(i);
        }
        mult = Integer.parseInt(multstr);
      }
      for (int j = 0; j <mult ; j++) {
        recFunction(substr,res);
      }
      i++;
    }
  }

  public static Map<String, Integer> getAtoms(String formula) {
    HashMap<String, Integer> res = new HashMap<>();
    recFunction(formula, res);
    return res;
  }
}