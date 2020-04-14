package Model;

import java.util.Date;

public abstract class  Bill {
public enum BillType{
    Hydro,Internet,Mobile
}
    String billID;
    Date billDate;
    BillType billType;
    double billAmount;

    public Bill(String billID, Date billDate, BillType billType) {
        this.billID = billID;
        this.billDate = billDate;
        this.billType = billType;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract Double calculateBill();
}
