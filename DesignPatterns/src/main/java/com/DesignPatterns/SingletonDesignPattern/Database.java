package main.java.com.DesignPatterns.SingletonDesignPattern;


public class Database {
    private String username;
    private String password;
    private String url;
    private static Database instance = null;

    public Database(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public static Database getInstance() {
        return instance;
    }

    public Database() {

    }

    public static Database createConnection() {
        if(instance == null) {
            instance = new Database("admin", "password", "myUrl");
        }
        return instance;
    }

}
