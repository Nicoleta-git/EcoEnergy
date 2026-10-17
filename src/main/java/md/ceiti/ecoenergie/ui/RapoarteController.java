package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;

/*
 * Screen 07 - Rapoarte și grafice
 * Figma: page "Macheta", screen "Rapoarte și grafice"
 * Assigned to: Faina
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

    @FXML
    private void initialize() {
    }
}
