package md.ceiti.ecoenergie.model;

/*
 * One room of the college. DONE.
 * id, cod ("204"), nume, etaj, prag = daily limit in kWh.
 */
public record Sala(int id, String cod, String nume, int etaj, double prag) {
    @Override
    public String toString() {
        return nume;
    }
}
