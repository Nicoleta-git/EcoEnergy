package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 06 - Facturi (OCR + AI)
 * Figma: page "Macheta", screens "Facturi", "Facturi (cu factura aleasă)"
 * Assigned to: Faina
 *
 * Only the interface for now: no OCR, no AI, the picture is not really read.
 * The page has to look like in Figma and the buttons show the messages.
 *
 * TODO:
 * - Top right: pill "OCR + AI · neconectat" (Ui.pill(..., "info")). OCR is only interface, no real AI.
 * - Left card: buttons "Alege factura (poza sau PDF)" (FileChooser) and "Foloseste factura de exemplu".
 *     If it is a picture show it in an ImageView.
 *     Fields: Nr. factura, Luna (AAAA-LL), Perioada, Scadenta, Consum (kWh), Total de plata (lei).
 *     Under them: "tarif = total / consum = ..." (styleClass "calcul"), updates while typing.
 *     Button "Salveaza factura" -> FacturaService.salveaza(...) and show a "mesaj".
 * - Right side: green card "Analiza AI dupa salvare" + card "Facturi salvate" with a TableView
 *     (Luna, kWh, Lei, Lei/kWh, Sursa).
 * - Make model/Factura.java and date/Facturi.java first.
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */
public class FacturiController {

    @FXML
    private void initialize() {
    }
}
