package Horrorskop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DagensHorrorskop {
    
    private List<String> todays;

    public DagensHorrorskop() {                                                       // Konstruktør.
        this.todays = setTodaysHorrorskop();
    }

    public List<String> getTodays(){                                                  // getter for å hente ut dagens 12 horroskop
        return this.todays;
    }

    public List<String> setTodaysHorrorskop(){                                        // Metode for å sette dagens horrorskop i konstruktøren.
        ArrayList<String> possibleHorrorskop = getAllPossibleHorrorskop();
        Collections.shuffle(possibleHorrorskop);                                      // Randomiserer listen med mulige horrorskop, slik at ikke samme blir valgt hver gang.
        List<String> todays12 = possibleHorrorskop.subList(0,12);    // Lagrer de 12 første horrorskopene fra den randomiserte listen i en ny liste.
        return todays12;
    }

    public ArrayList<String> getAllPossibleHorrorskop(){                              // Metode for å returnere alle horrorskopene.
        Horrorskop newhorrorskop = new Horrorskop();
        ArrayList<String> possibleHorrorskop = newhorrorskop.getAllHorrorskop();
        return possibleHorrorskop;
    }

    public void changeSingleHorrorskop(int index){                                    // Metode for å bytte ut et horrorskop, denne med index som input.
        if (index<(this.todays.size())){
            this.todays.set(index,fetchANewHorrorskop(this.todays));
        }
        else{
            throw new IllegalArgumentException("Gal indeks");
        }
    }

    public void changeSingleHorrorskop(String old){                                   // Metode for å bytte ut et horrorskop, denne med tekststreng som input.
        if (this.todays.indexOf(old)<this.todays.size()){
            this.todays.set(this.todays.indexOf(old),fetchANewHorrorskop(this.todays));
        }
        else{
            throw new IllegalArgumentException("Gal indeks: gammel streng finnes ikke.");
        }
    }

    private String fetchANewHorrorskop(List<String> usedHorrorskop) {
        ArrayList<String> possibleHorrorskop = getAllPossibleHorrorskop();            // Henter ut listen med mulige horroskop.
        Collections.shuffle(possibleHorrorskop);                                      // Randomiserer listen, slik at ikke samme blir valgt hver gang.
        for (int index = 0; index < possibleHorrorskop.size(); index++) {
            if (notIn(possibleHorrorskop.get(index), usedHorrorskop)){
                return possibleHorrorskop.get(index);
            }
        }
        throw new IllegalAccessError("Det er ikke nok nye horrorskop.");
    }

    private Boolean notIn(String text, List<String> usedTexts){                        // Hjelpevalideringsmetode for å sjekke at det potensielt nye horrorskopet ikke allerede er brukt.
        if (usedTexts.contains(text)){
            return false;
        }
        else {
            return true;
        }
    }

    public String getNumber(int number){                                              // getter for å finne horrorskopet på en gitt indeks.
        return this.todays.get(number);
    }

    public static void main(String[] args) {
        // Horrorskop h = new Horrorskop();
        // System.out.println(h.getAllHorrorskop());
        // DagensHorrorskop dh = new DagensHorrorskop();
        // System.out.println(dh.todays);
        // System.out.println((dh.todays).size());
        // dh.changeSingleHorrorskop(11);
        // System.out.println(dh.todays);
        // System.out.println((dh.todays).size());
        // DagensHorrorskop dh2 = new DagensHorrorskop();
        // System.out.println(dh2.todays);
    }
}
