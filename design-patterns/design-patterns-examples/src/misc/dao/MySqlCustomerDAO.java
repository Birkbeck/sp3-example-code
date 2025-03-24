package misc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySqlCustomerDAO implements CustomerDAO {
    @Override
    public void addCustomer(Customer c) throws DataAccessException, SQLException {
        Connection con = null; // just for illustration purposes. Should never be "null".
        try (PreparedStatement s = con.prepareStatement("INSERT ...")) {
            // ...
            s.executeUpdate();
            // ...
        }
    }

    @Override
    public Customer getCustomer(String id) throws DataAccessException {
        return null;
    }

    @Override
    public List getCustomers() throws DataAccessException {
        return null;
    }

    @Override
    public void removeCustomer(String id) throws DataAccessException {

    }

    @Override
    public void modifyCustomer(Customer c) throws DataAccessException {

    }

    // ...
}