package employee.models;

import java.time.LocalDate;

public abstract class Person {
    public static String getAllProps= "idPerson,fullName,birthday,address,phone,salary,local,position,point,classes,day_join";
    private String idPerson;
    private String fullName;
    private LocalDate birthday;
    private String address;
    private String phone;

    public Person(String idPerson, String fullName, LocalDate birthday, String address, String phone) {
        this.idPerson = idPerson;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    public abstract String toString();

    public abstract String getData();

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
