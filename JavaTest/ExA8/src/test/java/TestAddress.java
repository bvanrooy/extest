import be.abis.exa8.model.Address;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TestAddress {

    private Address addres;
    private final String ADDRESSFILENAME = "address.txt";

    @Before
    public void setup(){
        addres = new Address("street","nr","3000","leuven","belgium","BE");
        File addressFile = new File(ADDRESSFILENAME);
        if(!addressFile.canWrite()){
            addressFile.setWritable(true);
        }
    }
    @Test
    public void belgianZipCodeShouldBeNumeric(){

        boolean result = addres.checkBelgianZipCode();

        assertTrue(result);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void addressShouldBeWrittenToFile() throws IOException {

        addres.writeToFile();

    }

    @Test
    public void addressFileShouldHaveOneExtraLine() throws IOException {

        long linesBefore;
        try {
            linesBefore = Files.lines(Paths.get(ADDRESSFILENAME)).count();
        }
        catch (NoSuchFileException ex){
            linesBefore=0;
        }
        addres.writeToFile();
        long linesAfter = Files.lines(Paths.get(ADDRESSFILENAME)).count();

        assertEquals(++linesBefore,linesAfter);
    }

    @Test
    public void addressInFileShouldBeTheSame() throws  IOException{

        String addressFromFile=null;
        String nextLine;
        BufferedReader br = new BufferedReader(new FileReader(new File(ADDRESSFILENAME)));
        while ((nextLine = br.readLine()) != null) {
            addressFromFile = nextLine;
        }

        assertEquals(addressFromFile, addres.toString());
    }

    @Test(expected = IOException.class)
    public void writeToFileShouldThrowExceptionWhenFileIsReadOnly() throws IOException {
        File addressFile = new File(ADDRESSFILENAME);
        if(addressFile.canWrite()){
            addressFile.setWritable(false);
        }
        addres.writeToFile();
    }
}
