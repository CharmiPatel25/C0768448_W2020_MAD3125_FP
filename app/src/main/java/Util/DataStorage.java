package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Model.Bill;
import Model.Customer;
import Model.Hydro;

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

    public void loadData() throws ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");

        Customer c1 = new Customer("C001","Charmi","Patel","charmi@gmail.com","Female","25/11/1993");
        Customer c2 = new Customer("C002","Avani","Patel","avani@gmail.com","Female","5/01/1996");
        Customer c3 = new Customer("C003","Jyothi","Thomas","jyothi@gmail.com","Female","24/10/1991");
        Customer c4 = new Customer("C004","Jon","Snow","jon@gmail.com","Male","10/03/1989");
        Customer c5 = new Customer("C005","Bran","Stark","bran@gmail.com","Male","19/02/1998");

       customers.put(c1.getCustId(),c1);
        customers.put(c2.getCustId(),c2);
        customers.put(c3.getCustId(),c3);
        customers.put(c4.getCustId(),c4);
        customers.put(c5.getCustId(),c5);
        Hydro h1 = new Hydro("HD001",formatter1.parse("12/03/2019"), Bill.BillType.Hydro,"Tata",45);
        Hydro h2 = new Hydro("HD002",formatter1.parse("25/02/2019"), Bill.BillType.Hydro,"Reliance",20);


    }
}
