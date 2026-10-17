package md.ceiti.ecoenergie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import md.ceiti.ecoenergie.ui.MainController;
import md.ceiti.ecoenergie.ui.Ui;

/*
 * Main window. Loads the font, the theme and app.css, then shows a screen.
 *
 * For now the app opens straight on the main menu, so everyone can test
 * their page without logging in.
 * TODO (Nicoleta): when splash.fxml and login.fxml are ready, start with
 * arataSplash() instead of arataMeniul() in start().
 */
public class App extends Application {
    private static Stage fereastra;
    private static Scene scena;
    private static MainController meniu;

    @Override
    public void start(Stage stage) {
        for (String stil : new String[]{"Regular", "Medium", "SemiBold", "Bold", "BoldItalic", "ExtraBoldItalic"}) {
            Font.loadFont(App.class.getResourceAsStream("/md/ceiti/ecoenergie/fonts/Poppins-" + stil + ".ttf"), 13);
        }
        Ui.aplicaTema(true);

        fereastra = stage;
        scena = new Scene(new Pane(), 1280, 800);
        scena.getStylesheets().add(App.class.getResource("/md/ceiti/ecoenergie/css/app.css").toExternalForm());
        stage.setScene(scena);
        stage.setTitle("EcoEnergie CEITI");
        stage.setMinWidth(1100);
        stage.setMinHeight(700);

        arataMeniul();
        stage.show();
    }

    public static void arataSplash() {
        schimbaEcranul(Ui.incarca("splash").getRoot());
    }

    public static void arataLogin() {
        meniu = null;
        schimbaEcranul(Ui.incarca("login").getRoot());
    }

    public static void arataMeniul() {
        FXMLLoader loader = Ui.incarca("main");
        meniu = loader.getController();
        schimbaEcranul(loader.getRoot());
    }

    private static void schimbaEcranul(Parent ecran) {
        Ui.marcheazaTema(ecran);
        scena.setRoot(ecran);
    }

    public static MainController meniu() {
        return meniu;
    }

    public static Stage fereastra() {
        return fereastra;
    }
}
