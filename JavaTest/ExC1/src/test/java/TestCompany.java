import be.abis.exc1.model.Address;
import be.abis.exc1.model.Company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCompany {

    private Company company;

    @Before
    public void setUp(){
        company = new Company("ABIS",new Address("Diestsevest 32","","3000","leuven","belgium","BE"));
    }
    @Test
    public void taxForBelgianCompanyShouldBe51(){

        double expectedTax = 51.0;
        double result = company.calculateTaxToPay();

        assertEquals(expectedTax,result,0);

    }
}
