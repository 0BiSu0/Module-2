package ss16_test_file.bai_tap.copy_file;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadWriteFile rf = new ReadWriteFile();
        List<String> read = rf.readfile("src\\ss16_file\\bai_tap\\copy_file\\Main.txt");
        for (String o : read) {
            rf.WriteFile("src\\ss16_file\\bai_tap\\copy_file\\CopyFile.txt",o);
        }

    }
}
