package md.ceiti.ecoenergie.ui;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import md.ceiti.ecoenergie.App;
import md.ceiti.ecoenergie.model.SalaConsum;

/*
 * Side menu + the area where pages are shown. DONE (Nicoleta).
 * Figma: every screen from 02 to 11, the menu on the left is the same everywhere.
 *
 * You don't need to change this file to make your page.
 * Your page opens when you click its button in the menu.
 * To open another page from your code: App.meniu().citiri(), App.meniu().arataSala(salaConsum) etc.
 * If your controller "implements Ecran", laIesire() is called when the user leaves the page.
 */
public class MainController {
    @FXML
    private StackPane continut;
    @FXML
    private ToggleButton btnPanou, btnLive, btnCitiri, btnFacturi, btnRapoarte, btnCalculatoare, btnSfaturi, btnProiectare, btnSetari, btnChat;
    @FXML
    private VBox chat;

    private Object controllerCurent;

    @FXML
    private void initialize() {
        panou();
    }

    @FXML
    public void panou() {
        deschide("dashboard", btnPanou);
    }

    @FXML
    public void live() {
        deschide("live", btnLive);
    }

    @FXML
    public void citiri() {
        deschide("citiri", btnCitiri);
    }

    @FXML
    public void facturi() {
        deschide("facturi", btnFacturi);
    }

    @FXML
    public void rapoarte() {
        deschide("rapoarte", btnRapoarte);
    }

    @FXML
    public void calculatoare() {
        deschide("calculatoare", btnCalculatoare);
    }

    @FXML
    public void sfaturi() {
        deschide("sfaturi", btnSfaturi);
    }

    @FXML
    public void proiectare() {
        deschide("proiectare", btnProiectare);
    }

    @FXML
    public void setari() {
        deschide("setari", btnSetari);
    }

    public void arataSala(SalaConsum sala) {
        FXMLLoader loader = Ui.incarca("sala");
        SalaController controller = loader.getController();
        controller.arata(sala);
        arata(loader.getRoot(), controller);
    }

    private void deschide(String pagina, ToggleButton buton) {
        FXMLLoader loader = Ui.incarca(pagina);
        arata(loader.getRoot(), loader.getController());
        buton.setSelected(true);
    }

    private void arata(Parent pagina, Object controller) {
        if (controllerCurent instanceof Ecran) {
            ((Ecran) controllerCurent).laIesire();
        }
        controllerCurent = controller;
        continut.getChildren().setAll(pagina);
        FadeTransition fade = new FadeTransition(Duration.millis(300), pagina);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void comutaChat() {
        boolean vizibil = !chat.isVisible();
        chat.setVisible(vizibil);
        chat.setManaged(vizibil);
        btnChat.setSelected(vizibil);
    }

    @FXML
    private void schimbaTema() {
        Ui.aplicaTema(!Ui.esteNeagra());
    }

    @FXML
    private void iesire() {
        if (controllerCurent instanceof Ecran) {
            ((Ecran) controllerCurent).laIesire();
        }
        App.arataLogin();
    }
}
