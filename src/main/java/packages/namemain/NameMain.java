package packages.namemain;

import packages.firstname.Firstname;
import packages.lastname.LastName;
import packages.prefix.Prefix;

public class NameMain {
    public static void main(String[] args) {
        Prefix prefix = new Prefix("Dr.");
        Firstname firstname = new Firstname("Kovács");
        LastName lastName = new LastName("István");
        System.out.println(prefix.getPre() + " " + firstname.getFirst() + " " + lastName.getLast());
    }
}
