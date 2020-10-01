import be.abis.exc2.exception.PersonShouldBeAdultException;
import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Company;
import be.abis.exc2.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

    private Person person;

    @Mock
    private Company company;

    @Before
    public void setup(){
        person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10),4000);
    }


    @Test
    public void ageOfPersonShouldBe42() throws PersonShouldBeAdultException {

        int age = person.calculateAge();

        assertEquals(42,age);
    }

    @Test
    public void ageOfPersonShouldBe42HamCrest() throws PersonShouldBeAdultException {

        int age = person.calculateAge();

        assertThat( 42, comparesEqualTo(age));
    }

    @Test
    public void toStringSentenceStartsWithPerson(){

        String result = person.toString();

        assertThat(result,startsWith("Person"));
    }

    @Test(expected  = PersonShouldBeAdultException.class)
    public void personWithMinorAgeThrowsException() throws PersonShouldBeAdultException {

        person.setBirthDay(LocalDate.of(2020, 8, 10));
        int age = person.calculateAge();
    }

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() throws SalaryTooLowException {
        double tax = 51.0;
        double netSalary = 0;
        double expectedSalary=person.getGrossSalary() * ((100 -tax) / 100);

        person.setCompany(company);
        when(company.calculateTaxToPay()).thenReturn(tax);

        netSalary = person.calculateNetSalary();

        System.out.println(netSalary);
        System.out.println(expectedSalary);

        assertEquals(netSalary,expectedSalary,0);

        verify(company).calculateTaxToPay();
    }

    @Test(expected = SalaryTooLowException.class)
    public void salaryUnder1500ShouldThrowException() throws SalaryTooLowException {

        person.setCompany(company);
        person.setGrossSalary(1000.0);
        when(company.calculateTaxToPay()).thenReturn(51.0);

        person.calculateNetSalary();

        verify(company).calculateTaxToPay();
    }
}
