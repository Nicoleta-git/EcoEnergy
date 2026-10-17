package md.ceiti.ecoenergie.date;

import md.ceiti.ecoenergie.model.Sala;

import java.util.ArrayList;
import java.util.List;

/*
 * The 12 monitored rooms. DONE.
 * Everybody uses this list, so all pages show the same rooms.
 * toate(), dupaCod("204"), dupaId(7), schimbaPrag(id, prag)
 */
public class Sali {
    private static final List<Sala> sali = new ArrayList<>();

    static {
        sali.add(new Sala(1, "101", "Biblioteca 101", 1, 10));
        sali.add(new Sala(2, "102", "Sala de curs 102", 1, 10));
        sali.add(new Sala(3, "108", "Cabinet 108", 1, 9));
        sali.add(new Sala(4, "112", "Laborator electronică 112", 1, 22));
        sali.add(new Sala(5, "123", "Cabinet 123", 1, 9));
        sali.add(new Sala(6, "201", "Sala de festivități 201", 2, 15));
        sali.add(new Sala(7, "204", "Cabinet informatică 204", 2, 12));
        sali.add(new Sala(8, "210", "Laborator IT 210 (Orange)", 2, 38));
        sali.add(new Sala(9, "214", "Laborator 214", 2, 20));
        sali.add(new Sala(10, "301", "Sala de curs 301", 3, 9));
        sali.add(new Sala(11, "305", "Sala de curs 305", 3, 9));
        sali.add(new Sala(12, "313", "Cabinet 313", 3, 8));
    }

    public static List<Sala> toate() {
        return sali;
    }

    public static Sala dupaCod(String cod) {
        for (Sala s : sali) {
            if (s.cod().equals(cod)) return s;
        }
        return null;
    }

    public static Sala dupaId(int id) {
        for (Sala s : sali) {
            if (s.id() == id) return s;
        }
        return null;
    }

    public static void schimbaPrag(int id, double prag) {
        for (int i = 0; i < sali.size(); i++) {
            Sala s = sali.get(i);
            if (s.id() == id) {
                sali.set(i, new Sala(s.id(), s.cod(), s.nume(), s.etaj(), prag));
            }
        }
    }
}
