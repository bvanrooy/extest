import be.abis.exa5.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestAddress {

    @Test
    public void belgianZipCodeShouldBeNumeric(){

        Address addres = new Address("street","nr","3000","leuven","belgium","BE");

        boolean result = addres.checkBelgianZipCode();

        assertTrue(result);
    }
}
