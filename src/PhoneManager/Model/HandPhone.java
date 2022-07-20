package PhoneManager.Model;

public class HandPhone extends Phone {
    private String country;
    private String status;

    public HandPhone(String country, String status) {
        this.country = country;
        this.status = status;
    }

    public HandPhone(int id, String name, Double price, String manufacturer, String country, String status) {
        super(id, name, price, manufacturer);
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

    @Override
    public String toString() {
        return "HandPhone{" +
        "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    public String toData(){
        return String.format("%s,%s,%s,0", super.toData(), country, status);
    }
}
