package md.ceiti.ecoenergie.model;

/*
 * One monthly bill.
 * DONE (Faina)
 *
 * TODO: make it a record with: numar, luna ("2026-09"), kwh, totalLei, sursa ("MANUAL")
 *       and a method tarif() = totalLei / kwh
 */
public record Factura(String numar, String luna, double kwh, double totalLei, String sursa) {
    public double tarif() {
        if (kwh == 0) return 0;
        return totalLei / kwh;
    }
}