package Util;

import com.example.c0768448_w2020_mad3125_fp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Model.Bill;
import Model.Customer;
import Model.Hydro;
import Model.Internet;
import Model.Mobile;

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

    public void loadData()  {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");

        Customer c1 = new Customer("C001","Charmi","Patel","charmi@gmail.com","Female","25/11/1993", R.drawable.dollar);
        Customer c2 = new Customer("C002","Avani","Patel","avani@gmail.com","Female","5/01/1996",R.drawable.dollar);
        Customer c3 = new Customer("C003","Jyothi","Thomas","jyothi@gmail.com","Female","24/10/1991",R.drawable.dollar);
        Customer c4 = new Customer("C004","Jon","Snow","jon@gmail.com","Male","10/03/1989",R.drawable.dollar);
        Customer c5 = new Customer("C005","Bran","Stark","bran@gmail.com","Male","19/02/1998",R.drawable.dollar);

        customers.put(c1.getCustId(),c1);
        customers.put(c2.getCustId(),c2);
        customers.put(c3.getCustId(),c3);
        customers.put(c4.getCustId(),c4);
        customers.put(c5.getCustId(),c5);


       /* Hydro h1 = new Hydro("HD001",formatter1.parse("12/03/2019"), Bill.BillType.Hydro,"Tata",45);
        Hydro h2 = new Hydro("HD002",formatter1.parse("25/02/2019"), Bill.BillType.Hydro,"Reliance",20);

        Internet i1 = new Internet("IN001", formatter1.parse("01/12/2018"), Bill.BillType.Internet,"Lucky",4.0);
        Internet i2 = new Internet("IN002", formatter1.parse("17/11/2017"), Bill.BillType.Internet,"Bell",5.0);

        Mobile m1 = new Mobile("MB001",formatter1.parse("03/05/2018"), Bill.BillType.Mobile,"OnePlus","Unlimited 5G","6573482395",2,60);

        Mobile m2 = new Mobile("MB002",formatter1.parse("20/05/2015"), Bill.BillType.Mobile,"Apple Inc","Unlimited 5G+Talktime","8673492746",4,120); */

       /* c1.addBill(h1,h1.getBillID());
        c1.addBill(i1,i1.getBillID());
        c1.addBill(m1,m1.getBillID());

        c2.addBill(h2,h2.getBillID());
        c2.addBill(m2,m2.getBillID());

        c3.addBill(i2,i2.getBillID());*/
    }


}
