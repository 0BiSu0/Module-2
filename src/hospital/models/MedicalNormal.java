package hospital.models;

import hospital.utils.HandleData;

import java.util.List;

public class MedicalNormal extends MedicalRecord{
    public int payment;

    public MedicalNormal(int number,List<String> list) {
        super(number, list.get(0), list.get(1), list.get(2), HandleData.converterStringToLocalDate(list.get(3)),
                HandleData.converterStringToLocalDate(list.get(4)), list.get(5));
        this.payment = Integer.parseInt(list.get(6));
    }


    public static String getProps(){
        return "idMedicalRecord,idPatient,name,dateIn,dateOut,reason,payment";
    }

    @Override
    public String getData() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,empty,empty,%d",position,idMedicalRecord,idPatient,name,
                HandleData.converterLocalDateToString(dateIn),
                HandleData.converterLocalDateToString(dateOut),reason,payment);
    }

    @Override
    public String toString() {
        return "MedicalNormal{" +
                "position='" + getPosition() + '\'' +
                ", idMedicalRecord='" + idMedicalRecord + '\'' +
                ", idPatient='" + idPatient + '\'' +
                ", name='" + name + '\'' +
                ", dateIn=" + HandleData.converterLocalDateToString(dateIn) + '\'' +
                ", dateOut=" + HandleData.converterLocalDateToString(dateOut) + '\'' +
                ", reason='" + reason + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
