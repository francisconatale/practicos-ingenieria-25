package mutation.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPatternIndex {

    @Test
    void testQueNoEsPatronNiCoincidenEnElPrimerCaracter() {
        String subject = "abracadabra";
        String pattern = "ba";
        int result = PatternIndex.patternIndex(subject, pattern);
        assertEquals(-1, result);
    }
    @Test
    void testQueEsPatronYCoincidenEnElPrimerCaracter() {
        String subject = "abracadabra";
        String pattern = "abra";
        int result = PatternIndex.patternIndex(subject, pattern);
        assertEquals(0, result);
    }

    @Test
    void testQueEsUnPatronPeroNoEjecutaElFor(){
        String subject = "a";
        String pattern = "a";
        int result = PatternIndex.patternIndex(subject, pattern);
        assertEquals(0, result);
    }

    @Test
    void testQueEsUnPatronPeroNoEmpiezaEnElPrimerCaracter() {
        String subject = "patapin";
        String pattern = "atapin";
        int result = PatternIndex.patternIndex(subject, pattern);
        assertEquals(1, result);
    }

    @Test
    void testQueNoEsUnPatronNiSeConsultaUnPatron(){
        String subject = "";
        String pattern = "a";
        int result = PatternIndex.patternIndex(subject, pattern);
        assertEquals(-1, result);

    }

    @Test
    void testConstructor(){
        PatternIndex patternIndex = new PatternIndex();
    }
}
