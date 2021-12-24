package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    String regNumber;
    String name;
    String age;
    String contactNumber;
    String address;
    String email;

    public Student() {
    }

    public Student(String regNumber, String name, String age, String contactNumber, String address, String email) {
        this.regNumber = regNumber;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNumber='" + regNumber + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
