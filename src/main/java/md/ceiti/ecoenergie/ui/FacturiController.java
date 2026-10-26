package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import md.ceiti.ecoenergie.date.Facturi;
import md.ceiti.ecoenergie.model.Factura;
import md.ceiti.ecoenergie.model.FacturaCitita;
import md.ceiti.ecoenergie.service.FacturaService;
/*
 * Screen 06 - Facturi (OCR + AI)
 * Figma: page "Macheta", screens "Facturi", "Facturi (cu factura aleasă)"
 * DONE (Faina)
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
    @FXML private TextField txtNumar, txtLuna, txtPerioada, txtScadenta, txtKwh, txtTotal;
    @FXML private Label lblTarif, lblMesaj, lblAnaliza;
    @FXML private TableView<Factura> tabelFacturi;
    @FXML private TableColumn<Factura, String> colLuna, colSursa;
    @FXML private TableColumn<Factura, Double> colKwh, colLei, colTarif;

    @FXML
    private void initialize() {
        // Setare coloane tabel
        colLuna.setCellValueFactory(new PropertyValueFactory<>("luna"));
        colKwh.setCellValueFactory(new PropertyValueFactory<>("kwh"));
        colLei.setCellValueFactory(new PropertyValueFactory<>("totalLei"));
        colSursa.setCellValueFactory(new PropertyValueFactory<>("sursa"));

        // Coloana calculată (Lei/kWh)
        colTarif.setCellValueFactory(cellData -> new javafx.beans.property.SimpleDoubleProperty(cellData.getValue().tarif()).asObject());

        tabelFacturi.getItems().setAll(Facturi.toate());

        // Listener pentru a calcula tariful în timp real
        txtKwh.textProperty().addListener((obs, vechi, nou) -> calculeazaTarif());
        txtTotal.textProperty().addListener((obs, vechi, nou) -> calculeazaTarif());
    }

    private void calculeazaTarif() {
        try {
            double kwh = Ui.numar(txtKwh.getText(), "Consum (kWh)");
            double total = Ui.numar(txtTotal.getText(), "Total de plată (lei)");
            if (kwh > 0) {
                lblTarif.setText("tarif = total / consum = " + Ui.nr(total / kwh, 2) + " lei/kWh");
            }
        } catch (Exception e) {
            lblTarif.setText("tarif = total / consum = ...");
        }
    }

    @FXML
    private void folosesteExemplu() {
        FacturaCitita ex = FacturaService.exemplu();
        txtNumar.setText(ex.numar());
        txtLuna.setText(ex.luna());
        txtPerioada.setText(ex.perioada());
        txtScadenta.setText(ex.scadenta());
        txtKwh.setText(String.valueOf(ex.kwh()));
        txtTotal.setText(String.valueOf(ex.totalLei()));
        lblMesaj.setText("Factura de exemplu a fost încărcată.");
        lblMesaj.getStyleClass().setAll("mesaj", "succes");
    }

    @FXML
    private void salveaza() {
        try {
            Factura f = FacturaService.salveaza(
                    txtNumar.getText(), txtLuna.getText(),
                    Ui.numar(txtKwh.getText(), "Consum"),
                    Ui.numar(txtTotal.getText(), "Total"),
                    "MANUAL"
            );
            lblMesaj.setText("Factura " + f.numar() + " a fost salvată.");
            lblMesaj.getStyleClass().setAll("mesaj", "succes");

            lblAnaliza.setText(FacturaService.analizeaza(f));

            // Refresh tabel
            tabelFacturi.getItems().setAll(Facturi.toate());
        } catch (Exception e) {
            lblMesaj.setText(e.getMessage());
            lblMesaj.getStyleClass().setAll("mesaj", "eroare");
        }
    }
}