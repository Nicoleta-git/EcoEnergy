package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;
import md.ceiti.ecoenergie.App;

/*
 * Screen 01 - Autentificare
 * Figma: page "Macheta", screens "Autentificare", "Autentificare (cu eroare)"
 * Assigned to: Nicoleta
 *
 * TODO:
 * - left side: big logo (StackPane "logo-mare" + fx:include logo.fxml)
 *   and "Consumul de energie al colegiului, sala cu sala."
 * - right side: dark box with a round green badge with a bolt, "Intra in cont",
 *   "Contul primit de la administratie", Nume utilizator, Parola (PasswordField),
 *   green button "Intra in cont", small text with the demo accounts
 * - accounts: admin / admin123 (Administrator), profesor / prof123 (Responsabil de sala)
 * - empty fields -> "Scrie numele si parola.", wrong -> "Nume sau parola gresita." (styleClass "mesaj eroare")
 * - Enter in the password field = click on the button
 * - check the account with Sesiune.login(nume, parola)
 * - correct -> App.arataMeniul(). Remove the temporary button when you are done.
 */
public class LoginController {

    @FXML
    private void intra() {
        App.arataMeniul();
    }
}
