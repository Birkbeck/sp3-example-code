package structural.facade.database;

import java.sql.Connection;

class MySqlHelper {
    static Connection getMySqlDBConnection() {
        //get MySql DB connection using connection parameters
        return null;
    }

    void generateMySqlPDFReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }

    void generateMySqlHTMLReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }
}
