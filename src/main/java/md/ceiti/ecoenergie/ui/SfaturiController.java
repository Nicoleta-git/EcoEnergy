package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 09 - Sfaturi eco
 * Figma: page "Macheta", screen "Sfaturi eco"
 * Assigned to: Sofia
 *
 * TODO:
 * - 4 KPI cards: ECONOMIE PE AN (kWh), BANI ECONOMISITI, CO2 EVITAT, CA SI CUM AM PLANTA (copaci = CO2 / 22).
 * - Card "Obiectivul colegiului: 3 000 kWh mai putin pe an" with a ProgressBar.
 * - An Accordion with 6 TitledPanes, one for every advice (calculatoare in standby, lumina zilei,
 *     becuri LED, proiectorul in pauze, aer conditionat la 24 C, ultimul stinge lumina).
 *     Title: icon + text + pill "-438 kWh pe an". Inside: explanation, the calculation ("calcul"),
 *     and a switch "Aplicam in colegiu". When it is on, the kWh go into the 4 cards on top.
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */
public class SfaturiController {

    @FXML
    private void initialize() {
    }
}
