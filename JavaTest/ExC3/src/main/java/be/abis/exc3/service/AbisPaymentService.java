package be.abis.exc2.service;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;

public class AbisPaymentService implements PaymentService {
    @Override
    public void paySalary(Person person) throws SalaryTooLowException {
        double netSalary = person.calculateNetSalary();
        System.out.printf("Paying %s euro to %s",netSalary,person.getFirstName());
    }
}
