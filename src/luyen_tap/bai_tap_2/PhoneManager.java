package luyen_tap.bai_tap_2;

import java.util.LinkedList;
public class PhoneManager {
    public LinkedList<Phone> phoneList = new LinkedList<>();

    public void add(Phone phone) {
        phoneList.add(phone);
    }
    
    public void remove(int id) {
//        if (phoneList.size() == 0) {
//            System.out.println("NotFoundException!!!");
//            return;
//        }
//        phoneList.remove(id);

        phoneList.removeIf(e -> e.getId()==id);
    }
    
    public Phone searchProductById(int id) {
        return phoneList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
    
    public Phone searchProductByName(String name) {
        return phoneList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    
    public void setNewValue(int id, String name, int price) {
        this.searchProductById(id).setName(name);
        this.searchProductById(id).setPrice(price);
    }
    
    public void showAllList() {
        if (phoneList.size() == 0) System.out.println("List is Empty. Input please !!!");
        phoneList.forEach(x -> System.out.println(x.toString()));
    }
}
