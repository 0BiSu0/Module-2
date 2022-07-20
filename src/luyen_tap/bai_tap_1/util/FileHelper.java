package luyen_tap.bai_tap_1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper <T> {
    public List<String> read(String path) {
        List<String> result = new ArrayList<String>();

        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void write(String path, List<T> ts, boolean isAppend) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (T p : ts) {
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
