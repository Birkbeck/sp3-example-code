package demo.one;

import demo.interfaces.DatabaseConfig;

public class Demo {
    public static void main(String... args){
        //DatabaseConfig dbconfig = new DatabaseConfigImpl();
        DatabaseConfig dbconfig = DatabaseConfigImpl.getInstance();

        DatabaseConfig dbconfig2 = DatabaseConfigImpl.getInstance();

    }
}

