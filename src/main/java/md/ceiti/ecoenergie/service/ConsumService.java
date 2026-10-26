package md.ceiti.ecoenergie.service;

import md.ceiti.ecoenergie.date.Consumuri;
import md.ceiti.ecoenergie.date.Setari;
import md.ceiti.ecoenergie.date.Sali;
import md.ceiti.ecoenergie.model.ConsumZi;
import md.ceiti.ecoenergie.model.Sala;
import md.ceiti.ecoenergie.model.SalaConsum;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Everything about consumption, used by many pages.
 * DONE (Nicoleta): consumAzi(), consumAzi(sala), ultimeleZile(n), total(de, pana).
 *
 * TODO (Sofia):
 * - prognozaLunaKwh(): kWh from the 1st of the month until today, then FormuleEnergie.prognozaLuna(...)
 *
 * - adaugaCitire(sala, data, valoare, observatii): check the value (> 0, not in the future,
 *   not smaller than the last reading), save it in Citiri, add the difference to Consumuri, return it
 *
 * TODO (Faina), for the Rapoarte page:
 * - DONE (Faina)
 * - record Comparatie(Sala sala, double acum, double inainte) with deltaProcent()
 * - comparatie(zile): every room, this period vs the period before (Consumuri.peSali)
 * - exportCsv(fisier, zile): columns data;cod_sala;sala;kwh;cost_lei, return how many rows
 */
/*
 * Everything about consumption, used by many pages.
 * DONE (Nicoleta): consumAzi(), consumAzi(sala), ultimeleZile(n), total(de, pana).
 *
 * TODO (Sofia):
 * - prognozaLunaKwh(): kWh from the 1st of the month until today, then FormuleEnergie.prognozaLuna(...)
 *
 * - adaugaCitire(sala, data, valoare, observatii): check the value (> 0, not in the future,
 *   not smaller than the last reading), save it in Citiri, add the difference to Consumuri, return it
 *
 * TODO (Faina), for the Rapoarte page:
 * - record Comparatie(Sala sala, double acum, double inainte) with deltaProcent()
 * - comparatie(zile): every room, this period vs the period before (Consumuri.peSali)
 * - exportCsv(fisier, zile): columns data;cod_sala;sala;kwh;cost_lei, return how many rows
 */
public class ConsumService {

    public static List<SalaConsum> consumAzi() {
        LocalDate azi = LocalDate.now();
        List<SalaConsum> lista = new ArrayList<>();
        for (Sala s : Sali.toate()) {
            lista.add(new SalaConsum(s, Consumuri.get(s.id(), azi)));
        }
        return lista;
    }

    public static SalaConsum consumAzi(Sala sala) {
        return new SalaConsum(sala, Consumuri.get(sala.id(), LocalDate.now()));
    }

    public static List<ConsumZi> ultimeleZile(int n) {
        LocalDate azi = LocalDate.now();
        return Consumuri.peZile(azi.minusDays(n - 1), azi);
    }

    public static double total(LocalDate de, LocalDate pana) {
        double suma = 0;
        for (ConsumZi z : Consumuri.peZile(de, pana)) {
            suma += z.kwh();
        }
        return suma;
    }

//DONE (Faina)

    public record Comparatie(Sala sala, double acum, double inainte) {
        public double deltaProcent() {
            if (inainte == 0) return acum > 0 ? 100 : 0;
            return ((acum - inainte) / inainte) * 100;
        }
    }

    public static List<Comparatie> comparatie(int zile) {
        LocalDate azi = LocalDate.now();
        LocalDate deAcum = azi.minusDays(zile - 1);
        LocalDate panaAcum = azi;
        LocalDate deInainte = deAcum.minusDays(zile);
        LocalDate panaInainte = deAcum.minusDays(1);

        Map<Integer, Double> acumMap = Consumuri.peSali(deAcum, panaAcum);
        Map<Integer, Double> inainteMap = Consumuri.peSali(deInainte, panaInainte);

        List<Comparatie> lista = new ArrayList<>();
        for (Sala s : Sali.toate()) {
            lista.add(new Comparatie(s, acumMap.getOrDefault(s.id(), 0.0), inainteMap.getOrDefault(s.id(), 0.0)));
        }
        return lista;
    }

    public static int exportCsv(File fisier, int zile) {
        LocalDate azi = LocalDate.now();
        List<String[]> randuri = Consumuri.randuri(azi.minusDays(zile - 1), azi);
        try (PrintWriter writer = new PrintWriter(fisier)) {
            writer.println("data;cod_sala;sala;kwh;cost_lei");
            for (String[] r : randuri) {
                double kwh = Double.parseDouble(r[3]);
                double cost = kwh * Setari.tarif();
                writer.printf("%s;%s;%s;%.2f;%.2f%n", r[0], r[1], r[2], kwh, cost);
            }
            return randuri.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}