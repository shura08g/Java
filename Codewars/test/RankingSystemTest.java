
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
    
    @Test
    public void testRank() {
        User user = new User();
        user.rank = -8;
        user.incProgress(-4);
        assertEquals("Rank should equals of -7", -7, user.rank);
    }
    
    @Test
    public void testProgressPlus1() {
        User user = new User();
        user.rank = -5;
        user.progress = 50;
        user.incProgress(-6);
        assertEquals("Progress should equals of 51", 51, user.progress);
    }
    
    @Test
    public void testProgressPlus3() {
        User user = new User();
        user.rank = -5;
        user.progress = 50;
        user.incProgress(-5);
        assertEquals("Progress should equals of 53", 53, user.progress);
    }
    
    @Test
    public void testMaxRank() {
        User user = new User();
        user.rank = 8;
        user.progress = 0;
        user.incProgress(8);
        assertEquals("Progress should equals of 0", 0, user.progress);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testException0() throws IllegalArgumentException {
        User user = new User();
        user.incProgress(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionMinus9() throws IllegalArgumentException {
        User user = new User();
        user.incProgress(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testException9() throws IllegalArgumentException {
        User user = new User();
        user.incProgress(0);
    }
}
