package theater;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private short age;
    private char gender;

    public Customer(String name, String email, String phone, short age, char gender) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        if (gender == 'm') {
            return "Male";
        }
        else if(gender == 'f') {
            return "Female";
        }
        return " ";
    }

    public void setGender(char gender) {
        if (gender == 'm' || gender == 'f') {
            this.gender = 'm';
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender=" + getGender() +
                '}';
    }
}
