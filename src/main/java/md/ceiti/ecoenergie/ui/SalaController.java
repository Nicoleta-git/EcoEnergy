package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import md.ceiti.ecoenergie.model.SalaConsum;

/*
 * Screen 03 - Pagina salii (one room)
 * Figma: page "Macheta", screens "Pagina sălii", "Cod QR pe telefon"
 * Assigned to: Sofia
 *
 * It opens when you click a room on Panou principal: MainController calls arata(salaConsum).
 *
 * TODO:
 * - header: back arrow (App.meniu().panou()), room name + pill with the level, "Etajul 2 · prag zilnic 12 kWh"
 * - 4 KPI cards: CONSUM AZI, DIN PRAGUL ZILNIC (%), COST AZI, CO2 AZI
 * - LineChart "Consumul salii in ultimele 14 zile (kWh)" with the limit as a dashed line (styleClass "grafic-prag")
 * - card "Aparatele din sala": icon + name + "15 x 120 W", and "Totul pornit: 3156 W"
 * - 14 days: Consumuri.sala(sala.id(), 14)
 * - card with the QR code of the room (CodQr.java, ZXing) and button "Deschide pe telefon"
 *   -> TelefonQr.arata(salaConsum), a small window shaped like a phone (screen 03b)
 *   How to make the QR image is explained step by step at the top of CodQr.java.
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 */
public class SalaController {
    @FXML
    private Label titlu, subtitlu;

    public void arata(SalaConsum sc) {
        titlu.setText(sc.sala().nume());
        subtitlu.setText("Etajul " + sc.sala().etaj() + " · prag zilnic " + Ui.nr(sc.sala().prag(), 0) + " kWh");
    }
}
