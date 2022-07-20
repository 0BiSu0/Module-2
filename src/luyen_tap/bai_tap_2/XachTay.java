package luyen_tap.bai_tap_2;

import java.util.ArrayList;
import java.util.List;

public class XachTay extends Phone {
    private String country;
    private String status;


    public XachTay(String country, String status) {
        this.country = country;
        this.status = status;
    }

    public XachTay(int id, String name, int price, String producer, String country, String status) {
        super(id, name, price, producer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
