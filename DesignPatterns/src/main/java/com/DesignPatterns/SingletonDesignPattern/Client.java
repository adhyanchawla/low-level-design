package main.java.com.DesignPatterns.SingletonDesignPattern;

public class Client {
    public static void main(String[] args) {
        Database db1 = Database.createConnection();
        Database db2 = Database.createConnection();
        System.out.println("Are the two databases same? " + (db1 == db2));
        System.out.println("Password " + db1.getPassword());
        System.out.println("Username " + db1.getUsername());
        System.out.println("Url " + db1.getUrl());
    }
}
