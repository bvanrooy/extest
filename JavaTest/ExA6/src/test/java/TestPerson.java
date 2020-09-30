import be.abis.exa6.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;

public class TestPerson {

    private Person person;

    @Before
    public void Setup(){
        person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10));
    }
    @Test
    public void ageOfPersonShouldBe42(){

        int age = person.calculateAge();

        assertEquals(42,age);
    }

    @Test
    public void ageOfPersonShouldBe42HamCrest(){

        int age = person.calculateAge();

        assertThat( 42, comparesEqualTo(age));
    }

    @Test
    public void toStringSentenceStartsWithPerson(){

        String result = person.toString();

        assertThat(result,startsWith("Person"));
    }
}
