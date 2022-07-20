package hospital.models;

import hospital.utils.HandleData;

import java.time.LocalDate;
import java.util.List;


public class MedicalVIP extends MedicalRecord {
    public String vip;
    public LocalDate termVip;

    public MedicalVIP(int number, List<String> list) {
        super(number, list.get(0), list.get(1), list.get(2), HandleData.converterStringToLocalDate(list.get(3)),
                HandleData.converterStringToLocalDate(list.get(4)), list.get(5));
        this.vip = list.get(6);
        this.termVip = HandleData.converterStringToLocalDate(list.get(7));
    }

    public static String getProps() {
        return "idMedicalRecord,idPatient,name,dateIn,dateOut,reason,vip,dateTermVip";
    }

    @Override
    public String getData() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,empty", position, idMedicalRecord, idPatient, name,
                HandleData.converterLocalDateToString(dateIn),
                HandleData.converterLocalDateToString(dateOut), reason, vip,HandleData.converterLocalDateToString(termVip));
    }

    @Override
    public String toString() {
        return "MedicalVIP{" +
                "position='" + getPosition() + '\'' +
                ", idMedicalRecord='" + idMedicalRecord + '\'' +
                ", idPatient='" + idPatient + '\'' +
                ", name='" + name + '\'' +
                ", dateIn=" + HandleData.converterLocalDateToString(dateIn) + '\'' +
                ", dateOut=" + HandleData.converterLocalDateToString(dateOut) + '\'' +
                ", reason='" + reason + '\'' +
                ", vip='" + vip + '\'' +
                ", termVip='" + HandleData.converterLocalDateToString(termVip) + '\'' +
                '}';
    }
}
