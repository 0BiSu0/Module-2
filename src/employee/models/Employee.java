package employee.models;

import employee.utils.ConverterDateTimeAndString;

import java.util.List;

public class Employee extends Person {
    private int salary;
    private String local;
    private String position;

    public static String getProps = "idPerson,fullName,birthday,address,phone,Number_salary,position,local";

    public Employee(List<String> list) {
        super(list.get(0), list.get(1), ConverterDateTimeAndString.converterStringToLocalDate(list.get(2)), list.get(3), list.get(4));
        this.salary = Integer.parseInt(list.get(5));
        this.local = (list.get(6));
        this.position = (list.get(7));
    }


    @Override
    public String toString() {
        return "Employee{" +
                "idPerson='" + getIdPerson() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", birthday=" + ConverterDateTimeAndString.converterLocalDateToString(getBirthday()) +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", salary='" + salary + '\'' +
                ", local='" + local + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public String getData() {
        return String.format("%s,%s,%s,%s,%s,%d,%s,%s,empty,empty,empty",
                getIdPerson(), getFullName(), ConverterDateTimeAndString.converterLocalDateToString(getBirthday()),
                getAddress(), getPhone(), salary, local, position);
    }
}
