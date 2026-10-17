package md.ceiti.ecoenergie.service;

/*
 * Keeps the live sensor running and sends every measurement to whoever listens.
 * Assigned to: Sofia
 *
 * TODO:
 * - porneste(SursaDate sursa), opreste(), sursa()
 * - pornesteDinSetari(): starts the simulator or the Arduino, from Setari.text("sursa_date", "SIMULATOR")
 * - asculta(Consumer<Masurare>), nuMaiAsculta(...): the Live page and Panou principal listen
 * - ultima(): last measurement, whSesiune(): Wh since start, salaMonitorizata(): Sali.dupaCod(Setari.text("sala_monitorizata", "204"))
 * - every measurement also goes into Consumuri.adauga(...) for that room
 * - App.start() calls pornesteDinSetari(), App.stop() calls opreste()
 */
public class Monitor {
}
