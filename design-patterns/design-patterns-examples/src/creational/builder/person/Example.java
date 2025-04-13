package creational.builder.person;

public class Example {
    public static void main(String[] args) {
        Person p = Person.PersonBuilder.aPerson().withFirst("Fred").withSecond("Bloggs").withAge(12).build();
        System.out.println(p);
    }
}

class Person {
    private String first;
    private String second;
    private int age;
    private String address;

    private Person() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
            "first='" + first + '\'' +
            ", second='" + second + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            '}';
    }

    public static final class PersonBuilder {
        private String first;
        private String second;
        private int age;
        private String address;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder withFirst(String first) {
            this.first = first;
            return this;
        }

        public PersonBuilder withSecond(String second) {
            this.second = second;
            return this;
        }

        public PersonBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setFirst(first);
            person.setSecond(second);
            person.setAge(age);
            person.setAddress(address);
            return person;
        }
    }
}


