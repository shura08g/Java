//: strings/JGrep.java
//!!! {Args: thinkinginjavach13.java "\\b[Ssct]\\w+"}
// {Args: src\thinkinginjavach13\thinkinginjavach13.java "\b[Ssct]\w+"}
package thinkinginjavach13;

import java.util.Scanner;
import java.util.regex.*;
import net.mindview.util.TextFile;

/**
 *
 * @author shura
 */
public class thinkinginjavach13 {
    static String threatData = "58.27.82.161@02/10/2019\n" +
                               "204.45.234.40@02/11/2019\n" +
                               "58.27.82.161@02/11/2019\n" + 
                               "58.27.82.161@02/12/2019\n" + 
                               "58.27.82.161@02/01/2020\n" + 
                               "[Next log sections with different data format]";
    
    public static void main(String[] args) throws Exception {
        /*if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }*/
        String[] args2 = {"src\\thinkinginjavach13\\thinkinginjavach13.java", "\\b[Ssct]\\w+"};
        
        Pattern p = Pattern.compile(args2[1]);
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(args2[0])) {
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
        
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + 
                         "(\\d{2}/\\d{2}/\\d{4})";
        
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }  
    }
}
