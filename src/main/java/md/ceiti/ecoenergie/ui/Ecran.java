package md.ceiti.ecoenergie.ui;

/*
 * A page that has to stop something when you leave it (a Timeline, the sensor listener). DONE.
 * Add "implements Ecran" to your controller and write laIesire(). MainController calls it for you.
 */
public interface Ecran {
    void laIesire();
}
