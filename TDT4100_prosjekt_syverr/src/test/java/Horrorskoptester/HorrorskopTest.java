package Horrorskoptester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import Horrorskop.Horrorskop;

public class HorrorskopTest {

    @Test
    public void testConstructor() {                                                         // Test for å sjekke at konstruktøren lager en liste et antall horrorskop som i det minste inneholder de forhåndsskrevne horrorskopene.
        Horrorskop h1 = new Horrorskop();;                                                  // Dette er altså en implisitt test av readFile()-metoden i Filbehandling-implementasjonen av grensesnittet, i tillegg til konstruktøren.
        assertTrue(h1.getAllHorrorskop().size()>71);
    }

    @Test
    void testAddNewHorrorskop() throws IOException {                                        // Test for å sjekke at det som blir skrevet til fil via ett Horrorskop-objekt, blir lagret og kan hentes ut fra fil av et annet. Dvs en test av writeNewHorrorskopToFile-metoden i Filbehandling-implementasjonen av grensesnittet.
        Horrorskop horror1 = new Horrorskop();                                              // Et horrorskop-objekt lages
        horror1.setNewHorrorskop("Tester om dette blir skrevet til fil");            // En linje legges til i objektets horrorskop, og skrives til fil.
        Horrorskop horror2 = new Horrorskop();                                              // Et nytt horrorskop-objekt lages fra fil.
        assertEquals(horror1.getAllHorrorskop(), horror2.getAllHorrorskop());               // Sjekker at linjen som ble lagt til i første horrorskop, også finnes i det nye.
        horror1.fil.deleteHorrorskop("Tester om dette blir skrevet til fil");     // Linjen slettes igjen. 
    }

    @Test
    void testAddNumbers() throws IOException {                                              // Test for å sjekke at tall er valid input.
        Horrorskop horror1 = new Horrorskop();                                              
        horror1.setNewHorrorskop("Dette er telefonnummeret mitt: 0123456789");
        Horrorskop horror2 = new Horrorskop();                                             
        assertEquals(horror1.getAllHorrorskop(), horror2.getAllHorrorskop());               // Sjekker at linjen som ble lagt til i første horrorskop, også finnes i det nye.
        horror1.fil.deleteHorrorskop("Dette er telefonnummeret mitt: 0123456789");// Linjen slettes igjen.
    }

    @Test
    void testAddSpecialCharacters() throws IOException {                                    // Test for å sjekke at spesialtegn lar seg skrive til fil.
        Horrorskop horror1 = new Horrorskop();                                             
        horror1.setNewHorrorskop("ÆØÅ+?=&%$#!§é@");           
        Horrorskop horror2 = new Horrorskop();                                              
        assertEquals(horror1.getAllHorrorskop(), horror2.getAllHorrorskop());               // Sjekker at linjen som ble lagt til i første horrorskop, også finnes i det nye.
        horror1.fil.deleteHorrorskop("ÆØÅ+?=&%$#!§é@");                           // Linjen slettes igjen.
    }

    @Test
    void testAddSuperlongHorrorskop() throws IOException {                                  // Test for å sjekke at lange horrorskop også lar seg skrive til fil.
        Horrorskop horror1 = new Horrorskop();                                              
        horror1.setNewHorrorskop("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");         
        Horrorskop horror2 = new Horrorskop();                                          
        assertEquals(horror1.getAllHorrorskop(), horror2.getAllHorrorskop());               // Sjekker at linjen som ble lagt til i første horrorskop, også finnes i det nye.
        horror1.fil.deleteHorrorskop("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");     // Linjen slettes igjen.
    }

    @Test
    void testValidateNewHorrorskopLength() {                                                // Test for å sjekke at hva som blir skrevet til fil blir validert.
        Horrorskop shorthorror = new Horrorskop();
        assertThrows(IllegalArgumentException.class, () -> {
            shorthorror.setNewHorrorskop("For kort");
        });
    }

    @Test
    void testValidateNewHorrorskopIsNew() throws IOException {                              // Test for å sjekke at hva som blir skrevet til fil er et nytt horrorskop.
        Horrorskop uniquehorror = new Horrorskop();
        uniquehorror.setNewHorrorskop("Et unikt horrorskop");                       // En linje legges til.
        assertThrows(IllegalArgumentException.class, () -> {
            uniquehorror.setNewHorrorskop("Et unikt horrorskop");                   // Samme linje blir forsøkt lagt til igjen, noe som bør utløse et unntak.
    }); 
        uniquehorror.fil.deleteHorrorskop("Et unikt horrorskop");                 // Linjen slettes igjen.
    }

    @Test
    void testCalculateNumberOfFutures() throws IOException {
        Horrorskop initialHorror = new Horrorskop();
        int first = initialHorror.calculateNumberOfFutures();
        initialHorror.setNewHorrorskop("Et nytt horrorskop");
        int second = initialHorror.calculateNumberOfFutures();
        assertNotEquals(first, second);                                                    // Tester at antall horrorskop i listen blir oppdatert. 
        initialHorror.fil.deleteHorrorskop("Et nytt horrorskop");                // Linjen slettes igjen.
    }
}
