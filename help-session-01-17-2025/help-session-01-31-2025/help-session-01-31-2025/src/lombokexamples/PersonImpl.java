package lombokexamples;

public class PersonImpl implements Person {
    private String name;
    private String userid;

    public PersonImpl() {
        this("Fred", "xyz123");
    }

    public PersonImpl(String name, String userid) {
        this.name = name;
        this.userid = userid;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getUserid() {
        return this.userid;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonImpl)) return false;
        final PersonImpl other = (PersonImpl) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$userid = this.getUserid();
        final Object other$userid = other.getUserid();
        if (this$userid == null ? other$userid != null : !this$userid.equals(other$userid)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PersonImpl;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $userid = this.getUserid();
        result = result * PRIME + ($userid == null ? 43 : $userid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return this.getClass() + " " + this.getName() + ", userid=" + this.getUserid() + ")";
    }
}