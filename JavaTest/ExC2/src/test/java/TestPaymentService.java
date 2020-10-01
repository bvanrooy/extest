import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Company;
import be.abis.exc2.model.Person;
import be.abis.exc2.service.AbisPaymentService;
import be.abis.exc2.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private PaymentService paymentService;

    @Mock
    private Company company;

    @InjectMocks
    private Person person;

    @Before
    public void setup(){

        paymentService = new AbisPaymentService();
        when(company.calculateTaxToPay()).thenReturn(51.0);
    }

    @Test(expected = SalaryTooLowException.class)
    public void payingUnder1500EuroShouldThrowAnException() throws SalaryTooLowException {
        person.setGrossSalary(1500);
        paymentService.paySalary(person);
    }

    @Test
    public void testPaySalary() throws SalaryTooLowException {
        person.setGrossSalary(6000);
        System.setOut(new PrintStream(outContent));
        paymentService.paySalary(person);
        assertThat(outContent.toString(),startsWith("Paying"));
        System.setOut(originalOut);
    }
}
