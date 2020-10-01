package be.abis.exc2.service;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;

public interface PaymentService {
    void paySalary(Person person) throws SalaryTooLowException;
}
