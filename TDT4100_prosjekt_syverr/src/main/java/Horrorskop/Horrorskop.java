package Horrorskop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Horrorskop {

    private ArrayList<String> allHorrorskop;

	public IFilbehandling fil;

    public Horrorskop() {																			// Konstruktør som anvender interfacet IFilbehandling med Filbehandling-klassen
		try {
			this.fil = new Filbehandling("src/main/resources/Horrorskop/horrorskopfil.txt");
			//System.out.println(System.getProperty("user.dir"));
			this.allHorrorskop = this.fil.readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAllHorrorskop(){													// getter for å hente ut alle horrorskopene.
		return this.allHorrorskop;
	}

	public void setNewHorrorskop(String newtext){													// Metode for å legge til et nytt horrorskop
		if (isValidHorrorskop(newtext)){
			this.fil.writeNewHorrorskopToFile(newtext);
			this.allHorrorskop.add(newtext);
		}
		else {
			throw new IllegalArgumentException("Horrorskopet må være nytt, og lenger enn 10 tegn.");
		}
	}

	private boolean isValidHorrorskop(String newtext){												// Metode for å sjekke om et nytt horrorskop er gyldig.
		if (this.allHorrorskop.contains(newtext) || newtext.length()<10){
			return false;
		}
		else {
			return true;
		}
	}

	public void delete(String removethis) throws IOException{										// Hjelpemetode for å slette et horrorskop.
		try{
			this.fil.deleteHorrorskop(removethis);
			this.allHorrorskop.remove(removethis);
		} catch (IOException e){
			throw new IllegalStateException("Kunne ikke slette horroskop.");
		}
	}

	public int calculateNumberOfFutures(){															// Metode som returnerer antall horrorskop i appen.
        return allHorrorskop.size();
    }

	public static void main(String[] args) {
		// Horrorskop h = new Horrorskop();
		// System.out.println(h);
		// System.out.println(h.allHorrorskop);
		// h.setNewHorrorskop("testtesttesttesttttt");
		// System.out.println(h.allHorrorskop);
	}

}
