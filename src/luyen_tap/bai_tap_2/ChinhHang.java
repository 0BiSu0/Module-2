package luyen_tap.bai_tap_2;

public class ChinhHang extends Phone {
    private int time;
    private String code;

    public ChinhHang(int time, String code) {
        this.time = time;
        this.code = code;
    }

    public ChinhHang(int id, String name, int price, String producer, int time, String code) {
        super(id, name, price, producer);
        this.time = time;
        this.code = code;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
