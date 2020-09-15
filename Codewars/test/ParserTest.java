import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class ParserTest {
    
    @Test
    public void fixedTests() {
        assertEquals(1 , Parser.parseInt("one"));
        assertEquals(10 , Parser.parseInt("ten"));
        assertEquals(20 , Parser.parseInt("twenty"));
        assertEquals(246 , Parser.parseInt("two hundred forty-six"));
        assertEquals(6683 , Parser.parseInt("six thousand six hundred eighty-three"));
        assertEquals(1337 , Parser.parseInt("one thousand three hundred thirty-seven"));
        assertEquals(2000 , Parser.parseInt("two thousand"));
    }
}

