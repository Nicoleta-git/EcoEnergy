package md.ceiti.ecoenergie.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
 * Consumption of one day. DONE.
 * weekend() is true on Saturday and Sunday.
 */
public record ConsumZi(LocalDate data, double kwh) {
    public boolean weekend() {
        return data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
