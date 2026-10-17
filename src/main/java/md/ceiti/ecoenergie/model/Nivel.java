package md.ceiti.ecoenergie.model;

/*
 * Consumption level, the green / yellow / red from Figma. DONE.
 * under 75% of the limit -> VERDE, 75-100% -> GALBEN, over 100% -> ROSU
 * Use nivel.text and nivel.clasaCss: Ui.pill(nivel.text, nivel.clasaCss)
 */
public enum Nivel {
    VERDE("Normal", "ok"),
    GALBEN("Aproape de prag", "atentie"),
    ROSU("Peste prag", "depasit");

    public final String text;
    public final String clasaCss;

    Nivel(String text, String clasaCss) {
        this.text = text;
        this.clasaCss = clasaCss;
    }

    public static Nivel din(double procent) {
        if (procent > 1) return ROSU;
        if (procent >= 0.75) return GALBEN;
        return VERDE;
    }
}
