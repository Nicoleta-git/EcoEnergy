package md.ceiti.ecoenergie.ui;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import md.ceiti.ecoenergie.App;
import md.ceiti.ecoenergie.date.Setari;
import md.ceiti.ecoenergie.model.ConsumZi;
import md.ceiti.ecoenergie.model.Nivel;
import md.ceiti.ecoenergie.model.SalaConsum;
import md.ceiti.ecoenergie.service.ConsumService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
 * Screen 02 - Panou principal. DONE (Nicoleta).
 * Figma: page "Macheta", screen "Panou principal"
 *
 * Shows the numbers of the day, every room with a green/yellow/red bar,
 * and the chart for the last 14 days. Click on a room opens the room page.
 *
 * TODO (Nicoleta): put the 3D building (Cladire3D) in zona3d.
 * TODO (Sofia): when ConsumService.prognozaLunaKwh() is ready, add the card "ESTIMARE LUNA ACEASTA".
 * TODO (Sofia): when Monitor is ready, add the card "PUTERE ACUM" (Monitor.asculta) and the phone
 *   button next to every room (TelefonQr.arata).
 */
public class DashboardController {
    @FXML
    private Label subtitlu, lblConsum, lblCost, lblPestePrag, lblCo2;
    @FXML
    private VBox listaSali;
    @FXML
    private StackPane zona3d;
    @FXML
    private AreaChart<String, Number> graficZile;

    @FXML
    private void initialize() {
        subtitlu.setText("Azi, " + LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", Ui.RO)));

        List<SalaConsum> azi = ConsumService.consumAzi();
        double total = 0;
        int pestePrag = 0;
        for (SalaConsum sc : azi) {
            total += sc.kwh();
            if (sc.nivel() == Nivel.ROSU) pestePrag++;
            listaSali.getChildren().add(randSala(sc));
        }
        lblConsum.setText(Ui.nr(total, 1) + " kWh");
        lblCost.setText(Ui.nr(total * Setari.tarif(), 2) + " lei");
        lblCo2.setText(Ui.nr(total * Setari.factorCo2(), 1) + " kg");
        lblPestePrag.setText(pestePrag + " din " + azi.size());
        lblPestePrag.getStyleClass().add(pestePrag > 0 ? "depasit" : "ok");

        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        for (ConsumZi z : ConsumService.ultimeleZile(14)) {
            serie.getData().add(new XYChart.Data<>(z.data().format(DateTimeFormatter.ofPattern("dd.MM")), z.kwh()));
        }
        graficZile.getData().add(serie);
    }

    private VBox randSala(SalaConsum sc) {
        Label nume = new Label(sc.sala().nume());
        nume.getStyleClass().add("text-bold");
        Label valoare = new Label(Ui.nr(sc.kwh(), 1) + " / " + Ui.nr(sc.sala().prag(), 0) + " kWh");
        valoare.getStyleClass().add("formula");
        valoare.setMinWidth(Region.USE_PREF_SIZE);
        Region spatiu = new Region();
        HBox.setHgrow(spatiu, Priority.ALWAYS);

        HBox sus = new HBox(10, nume);
        if (sc.nivel() != Nivel.VERDE) {
            sus.getChildren().add(Ui.pill(sc.nivel().text, sc.nivel().clasaCss));
        }
        sus.getChildren().addAll(spatiu, valoare);
        sus.setAlignment(Pos.CENTER_LEFT);

        ProgressBar bara = new ProgressBar(Math.min(1, sc.procent()));
        bara.getStyleClass().addAll("bara-consum", sc.nivel().clasaCss);

        VBox rand = new VBox(6, sus, bara);
        rand.getStyleClass().add("rand-sala");
        rand.setOnMouseClicked(e -> App.meniu().arataSala(sc));
        return rand;
    }

    @FXML
    private void citireNoua() {
        App.meniu().citiri();
    }
}
