package thinkinginjavach18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("lockFile.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MICROSECONDS.sleep(100);
            System.out.println("Released Lock");
        }
        fos.close();
     }
}
