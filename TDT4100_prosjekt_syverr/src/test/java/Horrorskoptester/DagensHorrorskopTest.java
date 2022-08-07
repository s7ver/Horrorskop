package Horrorskoptester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import Horrorskop.DagensHorrorskop;

public class DagensHorrorskopTest {
    
    @Test
    public void testConstructor() {                             // Test for å sjekke at konstruktøren lager en liste med 12 horrorskop.
        DagensHorrorskop dh = new DagensHorrorskop();
        List<String> first = dh.getTodays();
        assertEquals(first.size(),12);
    }

    @Test
    public void testConstructorShuffles() {                     // Test for å sjekke at konstruktøren randomiserer rekkefølgen av horrorskopene, slik at dagens 12 horrorskop blir tilfeldig utvalgt.
        DagensHorrorskop d1 = new DagensHorrorskop();
        DagensHorrorskop d2 = new DagensHorrorskop();
        String first = d1.getTodays().toString();
        String second = d2.getTodays().toString();
        assertFalse(first.equals(second));                      // Sjekker at strengen av alle de første horrorskopene ikke er identisk med strengen av alle de andre.
    }

    @Test
    void testThatAllAreUnique() {                               // Test for å sjekke at hvert stjernetegn får et unikt horrorskop.
        DagensHorrorskop dagens = new DagensHorrorskop();
        List<String> alle = dagens.getTodays();
        int total = 0;
        for (int i = 0; i < alle.size(); i++) {                 // En for-løkke sjekker hvor mange ganger hver streng forekommer. Hvis én, legges den til en total.
            int freq = Collections.frequency(alle, alle.get(i));
            if (freq == 1){
                total += freq;
            }
        }
        assertEquals(total, alle.size());                       // Sjekk av at totalen stemmer med antall elementer i listen. Dersom et element forekommer flere ganger, vil det ikke regnes med i totalen.
    }

    @Test
    void testChangeHorrorskop() {                               // Test for å sjekke at et horrorskop blir byttet i et nytt horrorskop.
        DagensHorrorskop dagens = new DagensHorrorskop();
        String skalbyttes = dagens.getTodays().get(0);
        dagens.changeSingleHorrorskop(skalbyttes);
        String nytt = dagens.getTodays().get(0);
        assertTrue(!skalbyttes.equals(nytt));                   // Sjekker at det nye horrorskopet ikke er identisk med det gamle.
    }

    @Test
    void testThatChangedAreUnique() {                           // Test for å sjekke at byttede horrorskop forblir unike.
        DagensHorrorskop dagens = new DagensHorrorskop();
        List<String> alle = dagens.getTodays();

        for (String horrorskop : alle) {                        // En for-løkke som bytter ut alle horrorskopene med et nytt.
            dagens.changeSingleHorrorskop(horrorskop);
        }

        int total = 0;
        for (int i = 0; i < alle.size(); i++) {                 // En ny for-løkke som sjekker hvor mange ganger hver streng forekommer ved hjelp av Collections.frequency(). Hvis én, legges den til en total.
            int freq = Collections.frequency(alle, alle.get(i));
            if (freq == 1){
                total += freq;
            }
        }
        assertEquals(total, alle.size());                       // Sjekker at også de innbyttede horrorskopene er unike, dvs at det ikke finnes flere stjernetegn med samme horrorskop.
    }
}
