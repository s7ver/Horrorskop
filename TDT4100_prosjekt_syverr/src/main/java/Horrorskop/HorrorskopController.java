package Horrorskop;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HorrorskopController {

    @FXML private Text outputhorrorskop, savefeedback, futures;
    @FXML private TextField input;

    private DagensHorrorskop dagens = new DagensHorrorskop();
    private Horrorskop allehorrorskop = new Horrorskop();

    @FXML
    private void lagreHorrorskop(){                     // FXML-metode for å lagre et nytt horrorskop.
        try {
            allehorrorskop.setNewHorrorskop(input.getText());
            savefeedback.setText("Takk, Horrorskopet ble lagret!");
            futures.setText("Antall lagrede horrorskop: " + allehorrorskop.calculateNumberOfFutures());
        }
        catch (IllegalArgumentException e) {
            savefeedback.setText("Prøv igjen! Horrorskopet må være unikt og på mer enn 10 tegn");
        }
    }

    @FXML
    private void bytt(){                                // FXML-metode for å bytte ut et av dagens horrorskop.
        String oldtext = outputhorrorskop.getText();
        int oldtextindex = this.dagens.getTodays().indexOf(oldtext);
        dagens.changeSingleHorrorskop(oldtext);
        outputhorrorskop.setText(dagens.getNumber(oldtextindex));
    }

    @FXML                                               // Metoder for å fremvise de ulike stjernetegnenes horrorskop:
    private void onClickVaren() {
        outputhorrorskop.setText(dagens.getNumber(0));
    }
    @FXML
    private void onClickTyren() {
        outputhorrorskop.setText(dagens.getNumber(1)); //Tyren
    }

    @FXML
    private void onClickTvillingene() {
        outputhorrorskop.setText(dagens.getNumber(2)); //Tvillingene
    }

    @FXML
    private void onClickKrepsen() {
        outputhorrorskop.setText(dagens.getNumber(3)); //Krepsen
    }

    @FXML
    private void onClickJomfruen() {
        outputhorrorskop.setText(dagens.getNumber(4)); //Jomfruen
    }

    @FXML
    private void onClickLoven() {
        outputhorrorskop.setText(dagens.getNumber(5)); //Løven
    }

    @FXML
    private void onClickVekten() {
        outputhorrorskop.setText(dagens.getNumber(6)); //Vekten
    }

    @FXML
    private void onClickSkorpionen() {
        outputhorrorskop.setText(dagens.getNumber(7)); //Skorpionen
    }

    @FXML
    private void onClickSteinbukken() {
        outputhorrorskop.setText(dagens.getNumber(8)); //Steinbukken
    }

    @FXML
    private void onClickVannmannen() {
        outputhorrorskop.setText(dagens.getNumber(9)); //Vannmannen
    }

    @FXML
    private void onClickSkytten() {
        outputhorrorskop.setText(dagens.getNumber(10)); //Skytten
    }

    @FXML
    private void onClickFiskene() {
        outputhorrorskop.setText(dagens.getNumber(11)); //Fiskene
    }
}
