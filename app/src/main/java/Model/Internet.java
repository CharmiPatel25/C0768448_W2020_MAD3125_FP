package Model;

import java.util.Date;

public class Internet extends  Bill {
    private String internetProviderName;
    private Double internetGbUsed;

    public Internet(String billID, Date billDate, BillType billType, String internetProviderName, Double internetGBUsed) {
        super(billID, billDate, billType);
        this.internetProviderName = internetProviderName;
        this.internetGbUsed = internetGBUsed;
        this.billAmount = calculateBill();
    }

    public String getInternetProviderName() {
        return internetProviderName;
    }

    public void setInternetProviderName(String internetProviderName) {
        this.internetProviderName = internetProviderName;
    }

    public Double getInternetGBUsed() {
        return internetGbUsed;
    }

    public void setInternetGBUsed(Double internetGBUsed) {
        this.internetGbUsed = internetGBUsed;
    }

    @Override
    public Double calculateBill() {
        this.billAmount = internetGbUsed * 5;
        return this.billAmount;
    }
}
