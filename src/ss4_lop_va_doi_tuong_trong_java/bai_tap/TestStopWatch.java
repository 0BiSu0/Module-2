package ss4_lop_va_doi_tuong_trong_java.bai_tap;
import java.util.Arrays;
public class TestStopWatch {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000000);
        }
        StopWatch sw = new StopWatch();
        sw.start();
        Arrays.sort(arr);
        sw.stop();
        System.out.println("Elapsedtime " + sw.getElapsedTime() + " ms");
    }
}

