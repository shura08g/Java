package thinkinginjavach18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String com) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(com.split(" ")).start();
            BufferedReader result = new BufferedReader( new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = result.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // Оповещение об ошибках и возврат ненулевого значения
            // вызывающему процессу при возникновении проблем
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            if (!com.startsWith("CMD /C")) {
                command("CMD /C " + com);
            }
            else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OSExecuteException("Errors executing " + com);
        }
    }
}
