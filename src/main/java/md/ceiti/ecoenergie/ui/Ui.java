package md.ceiti.ecoenergie.ui;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Locale;

/*
 * Small helpers everyone can use. Please don't rename them.
 *
 *   Ui.incarca("citiri")      loads fxml/citiri.fxml
 *   Ui.nr(1234.5, 1)          "1.234,5"  (numbers the Romanian way)
 *   Ui.numar(text, "Ora")     reads a number from a TextField, throws an error with a message if it's wrong
 *   Ui.pill("Normal", "ok")   small colored label (ok / atentie / depasit / info / neutru)
 *   Ui.aplicaTema(true)       dark theme, false = light theme
 */
public class Ui {
    public static final Locale RO = Locale.forLanguageTag("ro-RO");

    private static boolean temaNeagra = true;

    public static FXMLLoader incarca(String nume) {
        FXMLLoader loader = new FXMLLoader(Ui.class.getResource("/md/ceiti/ecoenergie/fxml/" + nume + ".fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Nu pot încărca " + nume + ".fxml", e);
        }
        return loader;
    }

    public static String nr(double valoare, int zecimale) {
        return String.format(RO, "%,." + zecimale + "f", valoare);
    }

    public static double numar(String text, String numeCamp) {
        String t = text.strip().replace(" ", "").replace(",", ".");
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Completează câmpul „" + numeCamp + "”.");
        }
        try {
            return Double.parseDouble(t);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("„" + numeCamp + "” trebuie să fie un număr, de exemplu 12,5.");
        }
    }

    public static Label pill(String text, String clasa) {
        Label l = new Label(text);
        l.getStyleClass().addAll("pill", clasa);
        l.setMinWidth(Region.USE_PREF_SIZE);
        return l;
    }

    public static boolean esteNeagra() {
        return temaNeagra;
    }

    public static void aplicaTema(boolean neagra) {
        temaNeagra = neagra;
        if (neagra) {
            Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        } else {
            Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        }
        for (Window w : Window.getWindows()) {
            if (w.getScene() != null) {
                marcheazaTema(w.getScene().getRoot());
            }
        }
    }

    public static void marcheazaTema(Parent radacina) {
        radacina.getStyleClass().remove("tema-neagra");
        if (temaNeagra) {
            radacina.getStyleClass().add("tema-neagra");
        }
    }
}
