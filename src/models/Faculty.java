package models;

import java.time.LocalDate;
import java.util.Date;

public class Faculty extends MemberRecord {
    public Faculty(String memberID, LocalDate dateOfMembership, String name, String address, String email, Reader reader) {
        super(memberID, "Faculty", dateOfMembership, name, address, email,reader);
        this.maxBookLimit = 10;
    }

    @Override
    public void payBill(double deposit, double fine) {
        if(fine>deposit){
            System.out.println("Bill paid by Faculty member " + this.name);
        }else {
            System.out.println(this.name +"got a refund.");
        }
    }

    public void teach() {
        System.out.println(this.name + " is teaching using library books.");
    }
}
