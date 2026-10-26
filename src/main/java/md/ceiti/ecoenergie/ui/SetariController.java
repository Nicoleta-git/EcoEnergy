package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import md.ceiti.ecoenergie.date.Sali;
import md.ceiti.ecoenergie.date.Setari;
import md.ceiti.ecoenergie.model.Sala;

import java.util.HashMap;
import java.util.Map;
/*
 * Screen 11 - Setări
 * Figma: page "Macheta", screen "Setări"
 * DONE (Faina)
 *
 * TODO:
 * - Button "Salveaza setarile" top right (styleClass "accent").
 * - Card "Prag zilnic pe sala (kWh)": one row per room (Sali.toate()) with the name and a TextField, save with Sali.schimbaPrag(id, prag).
 * - Card "Cost": Tarif (lei/kWh) and Factor CO2 (kg/kWh), then the text "Valorile de pe factura."
 *     On save: Setari.seteaza("tarif_lei_kwh", ...) and Setari.seteaza("co2_kg_kwh", ...) (check with Ui.numar).
 * - Card "Sursa datelor": RadioButtons Simulator / Arduino + INA219 prin USB, ComboBox with COM ports,
 *     ComboBox "Sala in care e montat senzorul".
 * - Card "Asistent AI": "Nu e conectat inca." + CheckBox "Tema intunecata" (Ui.aplicaTema(...)).
 * - After saving show a "mesaj succes".
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */


public class SetariController {
    @FXML private VBox listaPraguri;
    @FXML private TextField txtTarif, txtCo2;
    @FXML private CheckBox chkTema;
    @FXML private Label lblMesaj;

    private final Map<Integer, TextField> campuriPrag = new HashMap<>();

    @FXML
    private void initialize() {
        txtTarif.setText(String.valueOf(Setari.tarif()));
        txtCo2.setText(String.valueOf(Setari.factorCo2()));
        chkTema.setSelected(Setari.temaIntunecata());

        // Generăm dinamic câmpurile pentru praguri
        for (Sala s : Sali.toate()) {
            javafx.scene.layout.HBox row = new javafx.scene.layout.HBox(10);
            Label lbl = new Label(s.nume());
            lbl.setPrefWidth(250);
            TextField tf = new TextField(String.valueOf(s.prag()));
            campuriPrag.put(s.id(), tf);
            row.getChildren().addAll(lbl, tf);
            listaPraguri.getChildren().add(row);
        }
    }

    @FXML
    private void salveaza() {
        try {
            double tarif = Ui.numar(txtTarif.getText(), "Tarif");
            double co2 = Ui.numar(txtCo2.getText(), "Factor CO2");

            Setari.seteaza("tarif_lei_kwh", String.valueOf(tarif));
            Setari.seteaza("co2_kg_kwh", String.valueOf(co2));

            for (Sala s : Sali.toate()) {
                TextField tf = campuriPrag.get(s.id());
                if (tf != null) {
                    double prag = Ui.numar(tf.getText(), "Prag " + s.nume());
                    Sali.schimbaPrag(s.id(), prag);
                }
            }

            Ui.aplicaTema(chkTema.isSelected());

            lblMesaj.setText("Setările au fost salvate cu succes.");
            lblMesaj.getStyleClass().setAll("mesaj", "succes");
        } catch (Exception e) {
            lblMesaj.setText(e.getMessage());
            lblMesaj.getStyleClass().setAll("mesaj", "eroare");
        }
    }
}