package structural.facade.database;

import java.sql.Connection;

class HelperFacade {
    static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
        Connection con;
        switch (dbType) {
            case MYSQL -> {
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML -> mySqlHelper.generateMySqlHTMLReport(tableName, con);
                    case PDF -> mySqlHelper.generateMySqlPDFReport(tableName, con);
                }
            }
            case ORACLE -> {
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML -> oracleHelper.generateOracleHTMLReport(tableName, con);
                    case PDF -> oracleHelper.generateOraclePDFReport(tableName, con);
                }
            }
        }
    }

    enum DBTypes {MYSQL, ORACLE}

    enum ReportTypes {HTML, PDF}
}
