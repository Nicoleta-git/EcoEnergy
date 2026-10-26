package md.ceiti.ecoenergie.model;

/*
 * What was read from a bill picture, before saving (fills the form on the Facturi page).
 * DONE (Faina)
 *
 * TODO: record with numar, luna, perioada, kwh, totalLei, scadenta.
 */
public record FacturaCitita(String numar, String luna, String perioada, double kwh, double totalLei, String scadenta) {
}