package md.ceiti.ecoenergie.date;

import md.ceiti.ecoenergie.model.Factura;
import java.util.ArrayList;
import java.util.List;

/*
 * All saved bills, kept in a list (no database yet).
 *  DONE (Faina)
 *
 * TODO:
 * - static List<Factura> with 2 example bills (2026-08: 1648 kWh, 5108,80 lei; 2026-07: 980 kWh, 3038 lei)
 * - toate(), adauga(Factura f)
 */
public class Facturi {
    private static final List<Factura> facturi = new ArrayList<>();

    static {
        // Cele 2 exemple din cerință
        facturi.add(new Factura("FE-2026-08", "2026-08", 1648, 5108.80, "MANUAL"));
        facturi.add(new Factura("FE-2026-07", "2026-07", 980, 3038.00, "MANUAL"));
    }

    public static List<Factura> toate() {
        return facturi;
    }

    public static void adauga(Factura f) {
        facturi.add(0, f); // Adăugăm la început ca să apară prima în tabel
    }
}