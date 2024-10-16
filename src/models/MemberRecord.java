package models;

import java.time.LocalDate;
import java.util.Date;

public class MemberRecord {
    protected String memberID;
    protected String type;
    protected LocalDate dateOfMembership;
    protected int noBooksIssued;
    protected int maxBookLimit;
    protected String name;
    protected String address;
    protected String email;
    protected Reader reader;

    public MemberRecord(String memberID, String type, LocalDate dateOfMembership, String name, String address, String email, Reader reader) {
        this.memberID = memberID;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0;
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.email = email;
        this.reader = reader;
    }

    public Reader getReader() {
        return reader;
    }

    public boolean incBookIssued() {
        if (noBooksIssued < maxBookLimit) {
            noBooksIssued++;
            return true;
        } else {
            System.out.println("Book limit reached.");
            return false;
        }
    }

    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }

    public String getMemberName() {
        return this.name;
    }

    public void payBill(double deposit,double fine) {
        if(fine>deposit){
            System.out.println("Bill paid by: " + this.name);
        }else {
            System.out.println(this.name +"got a refund.");
        }

    }

}
