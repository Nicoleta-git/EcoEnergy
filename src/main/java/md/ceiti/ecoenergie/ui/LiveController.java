package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 04 - Monitorizare live
 * Figma: page "Macheta", screen "Monitorizare live"
 * Assigned to: Sofia
 *
 * This is the "Arduino simulation" page. Ion builds the real board (Arduino + INA219 + bulb,
 * hardware/arduino_ina219). Until it is ready use SimulatorSursa, the page works the same.
 *
 * TODO:
 * - Left card: the gauge with the power in W. Use a TilesFX Tile (TileBuilder, SkinType.GAUGE),
 *     0 - 300 W, green bar, threshold 250.
 * - Middle card (styleClass "panou"): the big number in W, then U, I and P = U * I,
 *     and "De la pornire: x Wh = y lei".
 * - Right card "Placa Arduino": ComboBox with the COM ports, refresh button, "Conecteaza placa",
 *     "Simulator" button, a switch "Aparat pornit (simulator)" (ToggleSwitch from AtlantaFX).
 * - Bottom: LineChart "Puterea in ultimele 60 de secunde (W)", keep only the last 60 points.
 * - The values come from service/Monitor: Monitor.asculta(...) when the page opens.
 * - implements Ecran: in laIesire() call Monitor.nuMaiAsculta(...).
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */
public class LiveController {

    @FXML
    private void initialize() {
    }
}
