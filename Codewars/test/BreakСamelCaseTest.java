
import org.junit.Test;
import static org.junit.Assert.assertEquals;
//import org.junit.runners.JUnit4;

public class BreakСamelCaseTest {

    @Test
    public void tests() {
        assertEquals("Incorrect", "camel Casing", BreakСamelCase.camelCase("camelCasing"));
        assertEquals("Incorrect", "camel Casing Test", BreakСamelCase.camelCase("camelCasingTest"));
        assertEquals("Incorrect", "camelcasingtest", BreakСamelCase.camelCase("camelcasingtest"));
    }
}
