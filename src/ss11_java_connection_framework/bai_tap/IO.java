package ss11_java_connection_framework.bai_tap;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class IO {
    public static <T> void WriteToFile(ArrayList<T> arr, String ulr){
        File  file = new File(ulr);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream OOS = new ObjectOutputStream(fos);
            OOS.writeObject(arr);
            fos.close();
            OOS.close();
        }catch (FileNotFoundException ex)   {
            ex.printStackTrace();
            }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
