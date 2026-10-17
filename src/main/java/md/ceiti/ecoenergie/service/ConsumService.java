package md.ceiti.ecoenergie.service;

import md.ceiti.ecoenergie.date.Consumuri;
import md.ceiti.ecoenergie.date.Sali;
import md.ceiti.ecoenergie.model.ConsumZi;
import md.ceiti.ecoenergie.model.Sala;
import md.ceiti.ecoenergie.model.SalaConsum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
