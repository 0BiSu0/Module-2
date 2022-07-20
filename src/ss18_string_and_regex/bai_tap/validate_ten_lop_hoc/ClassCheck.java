package ss18_string_and_regex.bai_tap.validate_ten_lop_hoc;
public class ClassCheck {
    public void checkClass (String str) throws ClassException {
        String reg = "^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$";
        boolean kt = str.matches(reg);
        if (kt == false){
            throw new ClassException("Lỗi: Không đúng định dạng!!!");
        }else {
            System.out.println("Đúng định dạng tên lớp!!!");
        }
    }
}
