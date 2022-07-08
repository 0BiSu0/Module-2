package ss16_test_file.bai_tap.copy_file;


import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ReadWriteFile {
public List<String> readfile(String path) {
    List<String> stringList = new ArrayList<>();
    int count = 0;
    try {
        File file = new File(path);
        if (!file.exists())  {
        throw new FileNotFoundException();
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String Line;
        while ((Line = br.readLine())!= null){
            if (Line.trim().isEmpty()){
                continue;
            }
                    count += Line.length();
                    stringList.add(Line);
        }

        br.close();



    } catch (IOException ex) {
        System.out.println("File Not Found!!!");
    }
    System.out.println("So dong cua ban la: " + count);
    return stringList;
}
public void WriteFile(String Path, String str){
    try {
        FileWriter wr = new FileWriter(Path, true);
    BufferedWriter br = new BufferedWriter( wr);
    br.write(str);
    br.newLine();
    br.close();
    }catch (IOException ex){
        System.out.println("Khong the ghi File!!!");
    }
}
}
