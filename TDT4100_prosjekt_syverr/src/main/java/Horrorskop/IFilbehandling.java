package Horrorskop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IFilbehandling {
    
    public ArrayList<String> readFile() throws FileNotFoundException;

    public void writeNewHorrorskopToFile(String newtext);

    public void deleteHorrorskop(String removethis) throws IOException;

}
