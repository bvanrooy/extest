import be.abis.exa4.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;


public class TestPersonHamcrest {

    @Test
    public void ageOfPersonShouldBe42HamCrest(){
        Person person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10));

        int age = person.calculateAge();

        assertThat( 42, comparesEqualTo(age));
    }
}
