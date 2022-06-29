package Luyen_tap.bai_tap_1;
import java.util.LinkedList;
public class ProductManager {
    public LinkedList<Product> productList;

    public ProductManager() {
        this.productList = new LinkedList<>();
    }

    public void add(Product product) {
        productList.add(product);
    }
    public void remove(int id) {
        if (productList.size() == 0) {
            System.out.println("EMPTY LIST!!!");
            return;
        }
        productList.remove(searchProductById(id));
    }
    public Product searchProductById(int id) {
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
