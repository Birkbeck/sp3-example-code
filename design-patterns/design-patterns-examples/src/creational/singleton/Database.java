package creational.singleton;

public final class Database {

    // This will contain the one true instance
    private static final Database sDatabase = new Database();

    // Make the constructor private so no-one can create
    // objects of type Database
    private Database() {
    }

    // A static method that can access the one true instance
    // and give it back to us
    public static Database getInstance() {
        return sDatabase;
    }
}
