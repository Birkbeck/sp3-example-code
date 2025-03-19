package misc.dao;

public class Customer {
    private String id;
    private String contactName;
    private String phone;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String cn) {
        this.contactName = cn;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}