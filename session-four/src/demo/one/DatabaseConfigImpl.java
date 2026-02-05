package demo.one;

import demo.interfaces.DatabaseConfig;

public class DatabaseConfigImpl implements DatabaseConfig {
    private static final DatabaseConfig INSTANCE = new DatabaseConfigImpl();
    
    private DatabaseConfigImpl(){
        System.out.println("Loading Configuration...");
    } 

    public static DatabaseConfig getInstance() {
        return INSTANCE;
    }
    
}