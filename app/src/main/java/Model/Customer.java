package Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Customer implements Parcelable {

    private String custId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailID;
    private String gender;
    private String dateOfBirth;
    private HashMap<String, Bill> bills = new HashMap<String, Bill>();
    private Double totalBill;

    public Customer(String customerID, String firstName, String lastName, String emailID,String gender,String dob) {
        this.custId = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.gender = gender;
        this.dateOfBirth = dob;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public HashMap<String, Bill> getBills() {
        return bills;
    }

    public void setBills(HashMap<String, Bill> bills) {
        this.bills = bills;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public static Creator<Customer> getCREATOR() {
        return CREATOR;
    }

    protected Customer(Parcel in) {
        this.custId = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.fullName = in.readString();
        this.gender = in.readString();
        this.dateOfBirth = in.readString();
        this.emailID = in.readString();
        this.bills = in.readHashMap(Bill.class.getClassLoader());
        this.totalBill = (Double) in.readValue(Double.class.getClassLoader());

    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.custId);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.fullName);
        dest.writeString(this.emailID);
        dest.writeString(this.gender);
        dest.writeString(this.dateOfBirth);
        dest.writeMap(this.bills);
        dest.writeValue(this.totalBill);
    }
}
