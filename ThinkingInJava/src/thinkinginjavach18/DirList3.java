/*
{Args: "D.*\\.java"}
*/
package thinkinginjavach18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File path = new File("src\\thinkinginjavach18");
        //File path = new File(".");
        //System.out.println(Arrays.asList(path.list()));
        String[] list;
        if (args.length < 0) list = path.list();
        else {
            list = path.list(new FilenameFilter(){
                //private final Pattern pattern = Pattern.compile(args[0]);
                private final Pattern pattern = Pattern.compile("D.*\\.java");
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
            
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
