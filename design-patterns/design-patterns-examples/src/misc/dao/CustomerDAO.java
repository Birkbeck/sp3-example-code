package misc.dao;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer c) throws DataAccessException, SQLException;

    Customer getCustomer(String id) throws DataAccessException;

    List getCustomers() throws DataAccessException;

    void removeCustomer(String id) throws DataAccessException;

    void modifyCustomer(Customer c) throws DataAccessException;
}