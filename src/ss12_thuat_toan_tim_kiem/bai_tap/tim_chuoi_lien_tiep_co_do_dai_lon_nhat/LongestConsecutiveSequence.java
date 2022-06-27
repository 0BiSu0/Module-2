package ss12_thuat_toan_tim_kiem.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;
import java.util.StringTokenizer;
import java.util.Scanner;
public class LongestConsecutiveSequence {
    public static void TimChuoiLienTiep(String strInput) {
        StringTokenizer strToken = new StringTokenizer(strInput, ",\t,\r");
        int Max, i = 1, lengthStr;
        Max = strToken.nextToken().length();
        int viTriMax = i;
        while (strToken.hasMoreTokens()) {
            lengthStr = strToken.nextToken().length();
            i++;
            if (Max < lengthStr) {
                Max = lengthStr;
                viTriMax = i;
            }
        }
        System.out.println("Do dai chuoi lon nhat la: " + Max + " o vi tri " + viTriMax);
    }
        public static void main (String[] args){
            // TODO Auto-generated method stub
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap vao 1 chuoi: ");
            String strInput = input.nextLine();
            TimChuoiLienTiep(strInput);
        }
    }

