package be.abis.exc1;

import be.abis.exc1.model.Address;
import be.abis.exc1.model.Company;
import be.abis.exc1.model.Person;

import java.time.LocalDate;

public class ExC1 {

    public static void main(String[] args) {


        Company company = new Company("ABIS",new Address("Diestsevest 32","","3000","leuven","belgium","BE"));
        Person person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10), company,1000);


        System.out.println(person.calculateNetSalary());

    }
}
