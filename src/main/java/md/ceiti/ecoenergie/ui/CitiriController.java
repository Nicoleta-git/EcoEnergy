package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 05 - Introducere citiri
 * Figma: page "Macheta", screens "Introducere citiri", "Introducere citiri (cu eroare)", "Introducere citiri (cu confirmare)"
 * Assigned to: Sofia
 *
 * TODO:
 * - Form in a "panou": Sala (ComboBox with Sali.toate()), Data (DatePicker, today),
 *     Ora (TextField, HH:MM), Valoare contor (kWh) (TextField), Observatii (optional).
 * - Under the form: "Ultima citire: ... kWh, pe ..." for the selected room.
 * - Button "Salveaza citirea" (styleClass "accent"):
 *     - wrong hour -> Label with styleClass "mesaj eroare": "Ora se scrie HH:MM, de exemplu 08:00."
 *     - wrong number -> use Ui.numar(text, "Valoare contor"), it throws the error message for you
 *     - all good -> ConsumService.adaugaCitire(...) and show "mesaj succes" with the consumption it returns
 * - Second card "Ultimele citiri": TableView with Sala, Data si ora, Contor (kWh), Introdus de, Observatii.
 * - Make model/Citire.java and date/Citiri.java first.
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */
public class CitiriController {

    @FXML
    private void initialize() {
    }
}
