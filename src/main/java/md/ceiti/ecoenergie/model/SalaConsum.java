package md.ceiti.ecoenergie.model;

/*
 * A room + how much it used (today or in a period). DONE.
 * procent() -> 0.56 means 56% of the limit, nivel() -> VERDE / GALBEN / ROSU.
 */
public record SalaConsum(Sala sala, double kwh) {
    public double procent() {
        return kwh / sala.prag();
    }

    public Nivel nivel() {
        return Nivel.din(procent());
    }
}
