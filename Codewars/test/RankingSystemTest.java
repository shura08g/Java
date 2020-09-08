import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java

public class RankingSystemTest {
    @Test
    public void testSomething() {
        assertEquals("Rank should equals of -8", -8, new User().rank);
        assertEquals("Rank should equals of 0", 0, new User().progress);
    }
}