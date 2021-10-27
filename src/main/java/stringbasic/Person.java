package stringbasic;

public class Person {

    private String name;
    private String email;
    private String tajNumber;
    private String bankAccountNumber;
    private String phone;

    public Person(String name, String email, String tajNumber, String bankAccountNumber, String phone) {
        this.name = name;
        this.email = email;
        this.tajNumber = tajNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.phone = phone;
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

    public String getTajNumber() {
        return tajNumber;
    }

    public void setTajNumber(String tajNumber) {
        this.tajNumber = tajNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
