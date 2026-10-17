package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 08 - Calculatoare STEM
 * Figma: page "Macheta", screen "Calculatoare STEM"
 * Assigned to: Sofia
 *
 * TODO:
 * - 6 cards in a GridPane with 2 columns. Every card: title + pill (FIZICA / ECOLOGIE / MATEMATICA),
 *     TextFields with the values, and a Label "calcul" with the formula and the result.
 *     1. Energia unui aparat: E = n * P * t * zile / 1000, cost, CO2
 *     2. Legea lui Ohm: P = U * I, R = U / I, E = P * t
 *     3. Cat costa standby-ul: E = n * P * ore * zile / 1000
 *     4. Merita becurile LED?: economie pe an + in cate luni se amortizeaza
 *     5. Statistica consumului real: media, cea mai mica zi, cea mai mare zi (ConsumService.ultimeleZile + Statistica)
 *     6. Prognoza facturii: (kWh pana azi / zile trecute) * zile in luna * tarif
 * - The result changes while typing: textProperty().addListener(...) on every field.
 * - Put the formulas in service/FormuleEnergie.java, not in the controller.
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */
public class CalculatoareController {

    @FXML
    private void initialize() {
    }
}
