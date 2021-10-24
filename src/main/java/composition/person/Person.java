package composition.person;

public class Person {

    private String name;
    private String identificationCard;
    private Address address;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String personToString() {
        return name + " (" + identificationCard + ")";
    }

    public void moveTo(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void correctData(String country, String city, String streetAndNumber, String zipCode) {
        address = new Address(country, city, streetAndNumber, zipCode);
    }

}
