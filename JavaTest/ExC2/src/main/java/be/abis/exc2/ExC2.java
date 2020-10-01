package be.abis.exc2;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Address;
import be.abis.exc2.model.Company;
import be.abis.exc2.model.Person;
import be.abis.exc2.service.AbisPaymentService;
import be.abis.exc2.service.PaymentService;

import java.time.LocalDate;

public class ExC2 {
    public static void main(String[] args) {
        PaymentService paymentService=new AbisPaymentService();
        Company company = new Company("ABIS",new Address("Diestsevest 32","","3000","leuven","belgium","BE"));
        Person person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10), company,20000);

        try {
            paymentService.paySalary(person);
        } catch (SalaryTooLowException e) {
            e.printStackTrace();
        }
    }
}
