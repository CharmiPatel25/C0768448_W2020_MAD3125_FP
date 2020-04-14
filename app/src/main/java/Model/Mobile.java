package Model;

import java.util.Date;

public class Mobile extends  Bill {
    private String mobileNumber;
    private int mobileGbUsed;
    private int minutesUsed;
    private String mobileManufacturerName;
    private String planName;



    public Mobile(String billID, Date billDate, BillType billType, String mobileManufacturerName, String planName, String mobileNumber, int mobileGBUsed, int minutesUsed) {
        super(billID, billDate, billType);
        this.mobileManufacturerName = mobileManufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.mobileGbUsed = mobileGBUsed;
        this.minutesUsed = minutesUsed;
        this.billAmount = calculateBill();
    }

    public String getMobileManufacturerName() {
        return mobileManufacturerName;
    }

    public void setMobileManufacturerName(String mobileManufacturerName) {
        this.mobileManufacturerName = mobileManufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getMobileGBUsed() {
        return mobileGbUsed;
    }

    public void setMobileGBUsed(int mobileGBUsed) {
        this.mobileGbUsed = mobileGBUsed;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public void setMinutesUsed(int minutesUsed) {
        this.minutesUsed = minutesUsed;
    }

    @Override
    public Double calculateBill() {
        this.billAmount = ((double) this.minutesUsed * 2.5) + ((double) this.mobileGbUsed * 2);
        return this.billAmount;
    }
}
