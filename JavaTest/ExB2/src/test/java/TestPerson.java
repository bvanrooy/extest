import be.abis.exb2.exception.PersonShouldBeAdultException;
import be.abis.exb2.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestPerson {

    private Person person;

    @BeforeEach
    public void setup(){

        person = new Person(2,"John","Doe", LocalDate.of(1978, 8, 10));
    }


    @Test
    @DisplayName("Person should be 42")
    @Tag("age")
    public void ageOfPersonShouldBe42() throws PersonShouldBeAdultException {

        int age = person.calculateAge();

        assertEquals(42,age);
    }

    @Test
    @DisplayName("Person should be 42 (hamcrest version)")
    @Tag("age")
    public void ageOfPersonShouldBe42HamCrest() throws PersonShouldBeAdultException {

        int age = person.calculateAge();

        assertThat( 42, comparesEqualTo(age));
    }

    @Test
    @DisplayName("The tostring should start with the word Person")
    public void toStringSentenceStartsWithPerson(){

        String result = person.toString();

        assertThat(result,startsWith("Person"));
    }

    @Test
    @DisplayName("Test if the person is an adult")
    @Tag("age")
    public void personWithMinorAgeThrowsException() throws PersonShouldBeAdultException {

        person.setBirthDay(LocalDate.of(2020, 8, 10));
        assertThrows(PersonShouldBeAdultException.class,() ->person.calculateAge());
    }
}
