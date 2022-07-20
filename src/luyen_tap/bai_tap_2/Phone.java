package luyen_tap.bai_tap_2;
public class Phone {
    private int id;
    private int price;
    private String name;
    private String producer;

    public Phone() {
    }

    public Phone(int id, String name, int price, String producer){
        this.id = id;
        this. name = name;
        this. price = price;
        this. producer = producer;
    }

    public int getId() {

        return id;
    }
    public int getPrice() {

        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getProducer() {

        return producer;
    }
    public void setProducer(
            String producer) {
        this.producer = producer;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name +
                ", producer='"+ producer +'\'' +
                '}';
    }
    public String toData(){
        return String.format("%s,%s,%s,%s", id, name, price, producer);
    }
}
