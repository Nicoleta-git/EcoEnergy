package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import md.ceiti.ecoenergie.model.ConsumZi;
import md.ceiti.ecoenergie.service.ConsumService;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
 * Screen 07 - Rapoarte și grafice
 * Figma: page "Macheta", screen "Rapoarte și grafice"
 * DONE (Faina)
 *
 * TODO:
 * - Top right: ComboBox "Ultimele 7 / 30 de zile" and button "Export CSV" (FileChooser, write a .csv).
 * - 4 KPI cards like on Panou principal: TOTAL PERIOADA, MEDIA ZILNICA, COST TOTAL, FATA DE PERIOADA DINAINTE.
 * - LineChart "Consum pe zile (kWh)" with 2 series: consumption and the limit (sum of all prag).
 *     Add styleClass "grafic-prag" to the chart, the limit becomes a dashed line.
 * - BarChart "Pe sali, fata de perioada trecuta (kWh)": series 1 = before (gray), series 2 = now (green).
 * - TableView "Clasament": Sala, kWh, Lei, Delta %. Sorted, biggest first.
 * - Data: ConsumService.ultimeleZile(30), ConsumService.comparatie(30), ConsumService.exportCsv(...).
 *
 * Charts - what you need (nothing to install by hand):
 * - LineChart, BarChart, AreaChart come with JavaFX (javafx-controls), it is already in pom.xml.
 *   In IntelliJ open the Maven tab on the right and press Reload once, it downloads everything.
 * - FXML: <?import javafx.scene.chart.LineChart?>, CategoryAxis, NumberAxis.
 *   dashboard.fxml has an AreaChart, copy it from there.
 * - Code:
 *     XYChart.Series<String, Number> serie = new XYChart.Series<>();
 *     serie.setName("Consum");
 *     serie.getData().add(new XYChart.Data<>("15.10", 110.0));
 *     grafic.getData().add(serie);
 * - The colors are already in app.css (green line, gray bars, dashed limit with "grafic-prag").
 * - Optional: TilesFX (donut, gauge) is in pom.xml too: eu.hansolo.tilesfx.TileBuilder.
 * - Optional: Scene Builder (gluonhq.com/products/scene-builder) to drag the charts into the FXML.
 *
 * Styles: use the classes listed at the top of css/app.css, no colors in the code.
 * Look at DashboardController + dashboard.fxml for an example.
 */


public class RapoarteController {
    @FXML private ComboBox<String> comboPerioada;
    @FXML private LineChart<String, Number> graficZile;
    @FXML private BarChart<String, Number> graficSali;
    @FXML private TableView<?> tabelClasament; // Înlocuiește cu tipul corect dacă ai model

    @FXML
    private void initialize() {
        comboPerioada.getItems().addAll("Ultimele 7 zile", "Ultimele 30 de zile");
        comboPerioada.getSelectionModel().select(1);
        comboPerioada.valueProperty().addListener((obs, vechi, nou) -> reincarcaDate());

        reincarcaDate();
    }

    private void reincarcaDate() {
        int zile = comboPerioada.getSelectionModel().getSelectedIndex() == 0 ? 7 : 30;
        graficZile.getData().clear();

        // 1. Grafic pe zile
        XYChart.Series<String, Number> serieConsum = new XYChart.Series<>();
        serieConsum.setName("Consum");
        List<ConsumZi> zileList = ConsumService.ultimeleZile(zile);
        for (ConsumZi z : zileList) {
            serieConsum.getData().add(new XYChart.Data<>(z.data().format(DateTimeFormatter.ofPattern("dd.MM")), z.kwh()));
        }
        graficZile.getData().add(serieConsum);

        // 2. Grafic pe săli (acum vs înainte)
        graficSali.getData().clear();
        XYChart.Series<String, Number> serieAcum = new XYChart.Series<>();
        serieAcum.setName("Acum");
        XYChart.Series<String, Number> serieInainte = new XYChart.Series<>();
        serieInainte.setName("Înainte");

        for (ConsumService.Comparatie c : ConsumService.comparatie(zile)) {
            serieAcum.getData().add(new XYChart.Data<>(c.sala().cod(), c.acum()));
            serieInainte.getData().add(new XYChart.Data<>(c.sala().cod(), c.inainte()));
        }
        graficSali.getData().addAll(serieAcum, serieInainte);
    }

    @FXML
    private void exportCsv() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Salvează raportul CSV");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fc.showSaveDialog(null);
        if (file != null) {
            int zile = comboPerioada.getSelectionModel().getSelectedIndex() == 0 ? 7 : 30;
            ConsumService.exportCsv(file, zile);
        }
    }
}