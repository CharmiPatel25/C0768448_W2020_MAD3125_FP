package Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Model.Customer;

public class DataStorage {
    private static DataStorage dataObj = new DataStorage();
    public static DataStorage getInstance() {
        return dataObj;
    }
    private DataStorage() { }

    private HashMap<String, Customer> customers = new HashMap<>();

    public HashMap<String, Customer> getAllCustomerHash() {
        return this.customers;
    }

    public ArrayList<Customer> getAllCustomers()
    {
        Collection<Customer> tempCustomerList = customers.values();
        return new ArrayList<>(tempCustomerList);
    }
}
