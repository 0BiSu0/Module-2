package EmployeeManager.Service;
import EmployeeManager.Model.Danhsach;
import EmployeeManager.Exception.NotFoundException;
import EmployeeManager.util.FileHelper;
import java.util.ArrayList;
import java.util.List;
public class DanhsachService {
    private List<Danhsach> danhsaches = new ArrayList<>();
    private FileHelper fileHelper = new FileHelper();
    private static final String PATH = "src/EmployeeManager/data/Danhsach.csv";
    public Danhsach searchProductById(int id) {
        return danhsaches.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
    
    public Danhsach searchProductByName(String name) {
        return danhsaches.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }



    public void create(Danhsach danhsach) {
        int lastId = 0;
        if(danhsaches.size() > 0){
            lastId = danhsaches.get(danhsaches.size() - 1).getId();
        }
        danhsach.setId(lastId + 1);
        danhsaches.add(danhsach);
        fileHelper.write(PATH, danhsaches, false);
    }
    public List<Danhsach> findAll(){
        return danhsaches;

    } public List<Danhsach> search(String name){
        List<Danhsach> result = new ArrayList<Danhsach>();

        for (int i = 0; i < danhsaches.size(); i++) {
            if(danhsaches.get(i).getName().contains(name)){
                result.add(danhsaches.get(i));
            }
        }
        return result;
    }




    public void delete(int id) throws EmployeeManager.Exception.NotFoundException {
        for (int i = 0; i < danhsaches.size(); i++) {
            if(danhsaches.get(i).getId() ==  id){
                danhsaches.remove(i);
                fileHelper.write(PATH, danhsaches, false);
                return;
            }
        }
        throw new NotFoundException(id + " is not exists");
    }
    private List<Danhsach> mapToPhones() {
        List<Danhsach> result = new ArrayList<>();
        List<String> lines = fileHelper.read(PATH);
        for (int i = 0; i < lines.size(); i++) {
            String[] tmp =  lines.get(i).split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            Double age = Double.parseDouble(tmp[2]);
            String sex = tmp[3];
            String address = tmp[4];
            String email = tmp[5];

        }
        return result;
    }
}