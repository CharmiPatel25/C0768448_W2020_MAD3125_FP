package Util;

public class DataStorage {
    private static DataStorage dataObj = new DataStorage();
    public static DataStorage getInstance() {
        return dataObj;
    }
    private DataStorage() { }
}
