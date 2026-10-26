package md.ceiti.ecoenergie.service;

import md.ceiti.ecoenergie.date.Facturi;
import md.ceiti.ecoenergie.model.Factura;
import md.ceiti.ecoenergie.model.FacturaCitita;

/*
 * Saving and checking the bills.
 * DONE (Faina)
 *
 * TODO:
 * - salveaza(numar, luna, kwh, totalLei, sursa): check the values, add to date/Facturi, return the Factura
 * - analizeaza(factura): a short text for the green card (can be a fixed text, the AI is not connected)
 * - exemplu(): a FacturaCitita with the example bill (FE-2026-09, 1846 kWh, 5722,60 lei)
 */
public class FacturaService {

    public static Factura salveaza(String numar, String luna, double kwh, double totalLei, String sursa) {
        if (numar == null || numar.isBlank()) {
            throw new IllegalArgumentException("Numărul facturii este obligatoriu.");
        }
        if (kwh <= 0 || totalLei <= 0) {
            throw new IllegalArgumentException("Consumul și totalul trebuie să fie pozitive.");
        }

        Factura f = new Factura(numar, luna, kwh, totalLei, sursa);
        Facturi.adauga(f);
        return f;
    }

    public static String analizeaza(Factura factura) {
        // Analiză simulată (fără AI real)
        double tarif = factura.tarif();
        if (tarif > 3.5) {
            return "Tariful este peste medie. Verificați dacă există pierderi sau echipamente mari consumatoare.";
        }
        return "Tariful este în limite normale. Continuați monitorizarea consumului.";
    }

    public static FacturaCitita exemplu() {
        return new FacturaCitita("FE-2026-09", "2026-09", "01.09.2026 - 30.09.2026", 1846, 5722.60, "15.10.2026");
    }
}