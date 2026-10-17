package md.ceiti.ecoenergie.date;

import java.util.HashMap;
import java.util.Map;

/*
 * Settings kept while the app is open. DONE.
 * Setari.tarif(), Setari.factorCo2(), Setari.text("sala_monitorizata", "204"), Setari.seteaza(cheie, valoare)
 * TODO (Faina): put the real tariff from the college bill.
 */
public class Setari {
    private static final Map<String, String> setari = new HashMap<>();

    static {
        setari.put("tarif_lei_kwh", "3.10");
        setari.put("co2_kg_kwh", "0.45");
        setari.put("tema", "Primer Dark");
        setari.put("sursa_date", "SIMULATOR");
        setari.put("port_com", "");
        setari.put("sala_monitorizata", "204");
    }

    public static String text(String cheie, String implicit) {
        return setari.getOrDefault(cheie, implicit);
    }

    public static void seteaza(String cheie, String valoare) {
        setari.put(cheie, valoare);
    }

    public static double tarif() {
        return Double.parseDouble(text("tarif_lei_kwh", "3.10"));
    }

    public static double factorCo2() {
        return Double.parseDouble(text("co2_kg_kwh", "0.45"));
    }


    public static boolean temaIntunecata() {
        return !text("tema", "Primer Dark").contains("Light");
    }
}
