package md.ceiti.ecoenergie.service;

/*
 * All the physics and math formulas, used by Calculatoare STEM and other pages.
 * Assigned to: Sofia
 *
 * cost() is done as an example. TODO, the same way:
 * - energie(n, putereW, ore, zile)          E = n * P * t * zile / 1000 (kWh)
 * - putere(u, i)                            P = U * I
 * - rezistenta(u, i)                        R = U / I
 * - co2(kwh)                                kwh * Setari.factorCo2()
 * - amortizareLuni(investitie, economieAn)  investitie / economieAn * 12
 * - prognozaLuna(kwhPanaAzi, zileTrecute, zileLuna)
 * - deltaProcent(acum, inainte)             (acum - inainte) / inainte * 100
 * - tarif(totalLei, kwh)                     totalLei / kwh
 */
public class FormuleEnergie {

    public static double cost(double kwh, double tarif) {
        return kwh * tarif;
    }
}
