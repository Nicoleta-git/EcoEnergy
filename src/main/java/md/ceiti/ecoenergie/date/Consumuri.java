package md.ceiti.ecoenergie.date;

import md.ceiti.ecoenergie.model.ConsumZi;
import md.ceiti.ecoenergie.model.Sala;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * kWh per room per day for the last 120 days, example values (no database yet). DONE.
 * get(salaId, zi), adauga(...), peSali(de, pana), peZile(de, pana), sala(salaId, nrZile), randuri(...) for CSV
 */
public class Consumuri {
    private static final Map<String, Double> kwh = new HashMap<>();
    private static final Random random = new Random();

    static {
        LocalDate azi = LocalDate.now();
        for (Sala s : Sali.toate()) {
            for (int i = 119; i >= 0; i--) {
                LocalDate zi = azi.minusDays(i);
                kwh.put(cheie(s.id(), zi), valoare(s, zi, i));
            }
        }
    }

    private static String cheie(int salaId, LocalDate zi) {
        return salaId + "/" + zi;
    }

    public static double get(int salaId, LocalDate zi) {
        return kwh.getOrDefault(cheie(salaId, zi), 0.0);
    }

    public static void adauga(int salaId, LocalDate zi, double valoare) {
        kwh.put(cheie(salaId, zi), get(salaId, zi) + valoare);
    }

    public static Map<Integer, Double> peSali(LocalDate de, LocalDate pana) {
        Map<Integer, Double> rezultat = new HashMap<>();
        for (Sala s : Sali.toate()) {
            double suma = 0;
            for (LocalDate zi = de; !zi.isAfter(pana); zi = zi.plusDays(1)) {
                suma += get(s.id(), zi);
            }
            rezultat.put(s.id(), suma);
        }
        return rezultat;
    }

    public static List<ConsumZi> peZile(LocalDate de, LocalDate pana) {
        List<ConsumZi> zile = new ArrayList<>();
        for (LocalDate zi = de; !zi.isAfter(pana); zi = zi.plusDays(1)) {
            double suma = 0;
            for (Sala s : Sali.toate()) {
                suma += get(s.id(), zi);
            }
            zile.add(new ConsumZi(zi, suma));
        }
        return zile;
    }

    public static List<ConsumZi> sala(int salaId, int nrZile) {
        List<ConsumZi> zile = new ArrayList<>();
        LocalDate azi = LocalDate.now();
        for (int i = nrZile - 1; i >= 0; i--) {
            LocalDate zi = azi.minusDays(i);
            zile.add(new ConsumZi(zi, get(salaId, zi)));
        }
        return zile;
    }

    public static List<String[]> randuri(LocalDate de, LocalDate pana) {
        List<String[]> lista = new ArrayList<>();
        for (LocalDate zi = de; !zi.isAfter(pana); zi = zi.plusDays(1)) {
            for (Sala s : Sali.toate()) {
                lista.add(new String[]{zi.toString(), s.cod(), s.nume(), String.valueOf(get(s.id(), zi))});
            }
        }
        return lista;
    }

    private static double valoare(Sala s, LocalDate zi, int zileInUrma) {
        double baza = s.prag() * 0.6;
        double v = baza * (0.8 + random.nextDouble() * 0.4);
        boolean weekend = zi.getDayOfWeek() == DayOfWeek.SATURDAY || zi.getDayOfWeek() == DayOfWeek.SUNDAY;
        boolean vara = zi.getMonthValue() == 7 || zi.getMonthValue() == 8;
        if (vara) {
            v = v * 0.08;
        } else if (weekend) {
            v = v * 0.15;
        } else if (s.cod().equals("204") && zileInUrma < 14) {
            v = v * 1.3;
        }
        if (zileInUrma == 0) {
            v = v * Math.max(0.55, Math.min(1, (LocalTime.now().getHour() - 6) / 12.0));
        }
        return Math.round(v * 10) / 10.0;
    }
}
