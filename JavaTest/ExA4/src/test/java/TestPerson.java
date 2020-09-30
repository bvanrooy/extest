import be.abis.exa4.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPerson {

    @Test
    public void ageOfPersonShouldBe42(){
        Person person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10));

        int age = person.calculateAge();

        assertEquals(42,age);
    }
}
