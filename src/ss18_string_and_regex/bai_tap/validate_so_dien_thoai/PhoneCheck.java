package ss18_string_and_regex.bai_tap.validate_so_dien_thoai;
public class PhoneCheck {
    public void checkPhone (String str) throws PhoneException{
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean kt = str.matches(reg);
           if (kt == false){
               throw new PhoneException("Lỗi: Không đúng định dạng!!!");
           }else {
               System.out.println("Đúng định dạng số điện thoại!!!");
           }
    }
}
