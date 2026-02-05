package demo.one;

import demo.interfaces.DatabaseConfig;


// Probably? thread safe
public class DatabaseConfigImplAlt implements DatabaseConfig {
   
    private DatabaseConfigImplAlt(){
        System.out.println("Loading an alternate Configuration...");
    } 

    public static DatabaseConfig getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final DatabaseConfig INSTANCE = new DatabaseConfigImplAlt();

    }

    public static DatabaseConfig getInstance(){
        return DatabaseConfigImplAlt.getInstance();
    }  
}