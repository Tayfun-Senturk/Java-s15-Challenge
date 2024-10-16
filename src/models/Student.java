package models;

import java.time.LocalDate;
import java.util.Date;

public class Student extends MemberRecord {
    public Student(String memberID, LocalDate dateOfMembership, String name, String address, String email, Reader reader) {
        super(memberID, "Student", dateOfMembership, name, address, email,reader);
        this.maxBookLimit = 5;
    }

    @Override
    public void payBill(double deposit, double fine) {
        if(fine>deposit){
            System.out.println("Bill paid by Student: " + this.name);
        }else {
            System.out.println(this.name +"got a refund.");
        }
    }

    public void study() {
        System.out.println(this.name + " is studying with their books.");
    }
}
