package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 11 - Setări
 * Figma: page "Macheta", screen "Setări"
 * Assigned to: Faina
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

    @FXML
    private void initialize() {
    }
}
