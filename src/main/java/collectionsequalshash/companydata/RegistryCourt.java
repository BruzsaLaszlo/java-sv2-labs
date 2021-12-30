package collectionsequalshash.companydata;

import java.util.List;

public class RegistryCourt {

    public static void main(String[] args) {

        var companies = List.of(
                new Company("Mészáros & Mészáros", "123456789"),
                new Company("4iG", "987654321"),
                new Company("Cég Kft", "1234")
        );

        System.out.println(companies.contains(
                new Company("4iG", "987654321")
        ));
    }

}
