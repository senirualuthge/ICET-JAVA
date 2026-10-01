import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Delete {
    public static void main(String[] args) {
        try {
            // File f1 = new File("DTest.txt");
            File f2 = new File("Test.txt");
            FileWriter fw = new FileWriter(f2, true);
            fw.write("Hello java\n");
            // fw.flush();
            fw.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

