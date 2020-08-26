/*
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and 
carries the "instructions" for the development and functioning of living organisms.

If you want to know more http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
You have function with one side of the DNA (string, except for Haskell); you need 
to get the other complementary side. DNA strand is never empty or there is no DNA 
at all (again, except for Haskell).

More similar exercise are found here http://rosalind.info/problems/list-view/ (source)

DnaStrand.makeComplement("ATTGC") // return "TAACG"

DnaStrand.makeComplement("GTAT") // return "CATA"

 */

public class DnaStrand {

    public static String makeComplement(String dna) {
        StringBuilder result = new StringBuilder();
        char[] chars = dna.toCharArray();
        for (char ch : chars) {
            if (ch == 'A')
                result.append('T');
            if (ch == 'T')
                result.append('A');
            if (ch == 'C')
                result.append('G');
            if (ch == 'G')
                result.append('C');
        }
        return result.toString();
    }
    
    public static String makeComplement2(String dna) {
        StringBuilder result = new StringBuilder();
        char[] chars = dna.toCharArray();
        for (char ch : chars) {
            switch(ch) {
                case 'A' : {result.append('T'); break;}
                case 'C' : {result.append('G'); break;}
                case 'G' : {result.append('C'); break;}
                case 'T' : {result.append('A'); break;}
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(DnaStrand.makeComplement("AAAA"));
        System.out.println(DnaStrand.makeComplement("ATTGC"));
        System.out.println(DnaStrand.makeComplement("GTAT"));
        
        System.out.println(DnaStrand.makeComplement2("AAAA"));
        System.out.println(DnaStrand.makeComplement2("ATTGC"));
        System.out.println(DnaStrand.makeComplement2("GTAT"));
    }
}
