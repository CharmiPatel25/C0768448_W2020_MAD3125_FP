package Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Customer implements Parcelable {

    private String custId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private HashMap<String, Bill> bills = new HashMap<String, Bill>();
    private Double totalBill;



    protected Customer(Parcel in) {
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
    }
}
