package luyen_tap.bai_tap_2;
import luyen_tap.bai_tap_1.Product;
import java.util.LinkedList;
public class ProductManager {
    public LinkedList<luyen_tap.bai_tap_1.Product> productList;

    public ProductManager() {
        this.productList = new LinkedList<>();
    }





    public void add(luyen_tap.bai_tap_1.Product product) {
        productList.add(product);
    }





    public void remove(int id) {
        if (productList.size() == 0) {
            System.out.println("NotFoundException!!!");
            return;
        }
        productList.remove(id);
    }



    public luyen_tap.bai_tap_1.Product searchProductById(int id) {
        return productList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }




    public Product searchProductByName(String name) {
        return productList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }




    public void setNewValue(int id, String name, int price) {
        this.searchProductById(id).setName(name);
        this.searchProductById(id).setPrice(price);
    }




    public void showAllList() {
        if (productList.size() == 0) System.out.println("List is Empty. Input please !!!");
        productList.forEach(x -> System.out.println(x.toString()));
    }
}
