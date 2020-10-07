import java.util.Map;
import java.util.HashMap;

class ParseMolecule5 {
    
public static int eveluateElm(char ch, char[] strc, int index, Map<String, Integer> m){
    String elm = String.valueOf(ch);
    int value = 1;
    int lastIndex = index;
    for(int i = index+1; i<strc.length; i++){
      if(Character.isLetter(strc[i]) && Character.isLowerCase(strc[i])){
        elm += strc[i];
      }
      else if(Character.isDigit(strc[i])){
        String sstt = new String(strc);
        value = getIntValues(sstt.substring(i));
        lastIndex += String.valueOf(value).length();
        break;
      }
      else{
        break;
      }
      lastIndex = i;
    }
    
    if(m.containsKey(elm)){
      m.put(elm, value+m.get(elm));
    }
    else{
      m.put(elm, value);
    }
    return lastIndex;
  }
  
  

  
  public static int getIntValues(String tstr){
    int acumulate = 0;
    char[] ca = tstr.toCharArray();
    String vk = "0";
    for(int i = 0; i<ca.length; i++){
      if(Character.isDigit(ca[i])){
        vk += ca[i];
        acumulate = Integer.valueOf(vk);
      }
      else{
        if(Integer.valueOf(vk) == 0){
          acumulate = 1;
        }
        break;
      }
    }
    return acumulate;
  }
  
  public static int[] eveluateElmV(String ch, char[] strc, int index){

    String elm = String.valueOf(ch);
    int value = 1;
    int lastIndex = index;
    
    for(int i = index+1; i<strc.length; i++){
      
      if(Character.isLetter(strc[i]) && Character.isLowerCase(strc[i])){
        elm += strc[i];
      }
      else if(Character.isDigit(strc[i])){
        String sstt = new String(strc);
        value = getIntValues(sstt.substring(i));
        lastIndex += String.valueOf(value).length();
        break;
      }
      else{
        break;
      }
      lastIndex = i;

    }

    return new int[]{lastIndex,value};
  }
  
  
  public static int getAllValues(String c, String cs, int level){

    char[] ca = cs.toCharArray();

    int lastlvlin = 0;
    int lastlvl = 0;
    int counter = 0;
    boolean onlevel = true;
    
    for(int i = 0; i<ca.length; i++){
      int co = 0;
      if((c.length()==1 && c.charAt(0) == ca[i] && ((ca.length-1 == i) || !Character.isLowerCase(ca[i+1]))) || (ca.length-1 > i && c.length()>1 && c.equals(String.valueOf(ca[i])+String.valueOf(ca[i+1])))){
        if(lastlvl == 0){
            int[] v = eveluateElmV(c, ca, i);
            i = v[0];
            counter += v[1];
        }
          continue;
      }
      else if (ca[i] == '[' || ca[i] == '(' || ca[i] == '{'){
        if(onlevel){
          lastlvlin = i;
          onlevel = false;
        }
        lastlvl += 1;
        continue;
      }
      else if((ca[i] == ']' || ca[i] == ')' || ca[i] == '}')){
        lastlvl -= 1;
        if(lastlvl == 0){
          if((cs.charAt(lastlvlin) == '{' && ca[i] != '}') || (cs.charAt(lastlvlin) == '[' && ca[i] != ']') || (cs.charAt(lastlvlin) == '(' && ca[i] != ')'))
            throw new IllegalArgumentException();
          onlevel = true;
          co += getAllValues(c,cs.substring(lastlvlin+1,i),level+1);
          int vi = 1;
          if(i<ca.length-1 && Character.isDigit(ca[i+1])){
            vi = getIntValues(cs.substring(i+1));
            i += String.valueOf(vi).length();
          }
          
          if(counter == 1 && level == 0 && co > 0){
            counter = 0;
          }

          counter += (co*vi);
          
        }
      }
    }
    
    if(lastlvl!=0)
      throw new IllegalArgumentException();
    
    return counter;
  }
  
  
  
  public static Map<String,Integer> getAtoms(String formula) {
    Map<String,Integer> m = new HashMap();
    char [] ca = formula.toCharArray();
    for(int i = 0; i<ca.length; i++){
      if(Character.isLetter(ca[i]) && Character.isUpperCase(ca[i])){
        i = eveluateElm(ca[i], ca, i,m);
        continue;
      }
      else if(Character.isLetter(ca[i]) && Character.isLowerCase(ca[i])){
        throw new IllegalArgumentException();
      }
    }
    
    m.forEach((k,v) -> {
      if(k.length() > 2 || !Character.isLetter(k.charAt(0)) || !Character.isUpperCase(k.charAt(0))){
        throw new IllegalArgumentException();
      }
      m.put(k,getAllValues(k,formula,0));
    });
    
    
    return m;
    
    
  }

}