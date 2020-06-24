// 23 Многопоточность
package thinkinginjavach21;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    
    @Override
    public int next() {
        ++currentEvenValue; // Опасная точка
        ++currentEvenValue;
        return currentEvenValue;
    }
    
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
    
}
/*
Press Control+C to exit
165 not even!
175 not even!
173 not even!
171 not even!
169 not even!
167 not even!
*/