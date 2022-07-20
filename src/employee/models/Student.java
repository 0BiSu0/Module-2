package employee.models;

import employee.utils.ConverterDateTimeAndString;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {
    private int point;
    private String classes;
    private LocalDate day_join;

    public static String getProps = "idPerson,fullName,birthday,address,phone,Number_point,classes,day_join";

    public Student(List<String> list) {
        super(list.get(0), list.get(1), ConverterDateTimeAndString.converterStringToLocalDate(list.get(2)), list.get(3), list.get(4));
        this.point = Integer.parseInt(list.get(5));
        this.classes = (list.get(6));
        this.day_join = ConverterDateTimeAndString.converterStringToLocalDate(list.get(7));
    }

    @Override
    public String toString() {
        return "Student{" +
                "idPerson='" + getIdPerson() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", birthday=" + ConverterDateTimeAndString.converterLocalDateToString(getBirthday()) +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", point='" + point + '\'' +
                ", classes='" + classes + '\'' +
                ", day_join='" + ConverterDateTimeAndString.converterLocalDateToString(day_join) + '\'' +
                '}';
    }

    @Override
    public String getData() {
        return String.format("%s,%s,%s,%s,%s,empty,empty,empty,%d,%s,%s",
                getIdPerson(), getFullName(), ConverterDateTimeAndString.converterLocalDateToString(getBirthday()),
                getAddress(), getPhone(), point, classes, ConverterDateTimeAndString.converterLocalDateToString(day_join));
    }
}
