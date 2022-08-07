package Horrorskop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Filbehandling implements IFilbehandling {

	private String path;
	
	public Filbehandling (String path){												// Konstruktør som tar inn en streng-url.
		this.path = path;
	}

	public ArrayList<String> readFile() throws FileNotFoundException{				// Metode som leser den spesifiserte filen og returnerer en liste.
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		ArrayList<String> list = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if (line.length() > 2){
				list.add(line);
			}
		}
		scanner.close();
		return list;
	}

	public void writeNewHorrorskopToFile(String newtext) {							// Metode som skriver et nytt horrorskop (tekststreng) til filen.	
		try (BufferedWriter writeOut = new BufferedWriter(new FileWriter(path, true))) {
			writeOut.newLine();
			writeOut.write(newtext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteHorrorskop(String removethis) throws IOException{ 			// Hjelpemetode som sletter siste horrorskop fra filen.
		File file = new File(path);
		java.nio.file.Path p = file.toPath();
    	List<String> itout = Files.lines(p)
        .filter(horrorline -> !horrorline.contains(removethis))
        .collect(Collectors.toList());
    	Files.write(p, itout, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}

}
