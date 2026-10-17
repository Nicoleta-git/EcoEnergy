# EcoEnergie CEITI

[English](README.md) · **Română** · [Русский](README.ru.md)

Aplicație în JavaFX care arată cât curent consumă fiecare sală din colegiu. Proiectul nr. 1 la Tehnologii avansate de programare, anul IV.

Echipa: Titei Nicoleta, Ababii Faina, Goncear Sofia, Ghinda Ion

Macheta și wireframe-ul sunt în [Figma](https://www.figma.com/design/Bkr6FzsNb0wzooRl5pZgqT/EcoEnergie).

## Documentația

Documentația e scrisă în engleză.

- Etapa 1 – [Analiza problemei](docs/01_problem_analysis.md)
- Etapa 2 – [Documentarea](docs/02_research.md)
- Etapa 3 – [Utilizatorii](docs/03_users.md)
- Etapa 4 – [Cerințele](docs/04_requirements.md)
- Etapa 5 – [Conceptul și STEAM](docs/05_concept_steam.md)
- Etapa 6 – [Arhitectura](docs/06_architecture.md)
- Etapa 9 – [Macheta](docs/09_digital_mockup.md)
- Etapa 10 – [Navigarea](docs/10_navigation.md)
- Etapa 11 – [Rolurile](docs/11_roles.md)
- Etapa 12 – [Verificarea machetei](docs/12_mockup_check.md)
- Etapa 13 – [Feedbackul](docs/13_feedback.md)
- Etapa 14 – [Îmbunătățirile](docs/14_improvements.md)

Etapa 7 (schițele) e pe hârtie, etapa 8 (wireframe-ul) e în Figma.

Anexe: [fișa proiectului](docs/appendix/project_sheet.md) · [jurnalul echipei](docs/appendix/team_journal.md) · [rapoartele individuale](docs/appendix/individual_reports.md) · [reflecția](docs/appendix/reflection.md) · [planul proiectului](PROJECT_PLAN.md)

## Cine ce face

Wireframe-ul și schema generală în Figma le-au făcut Nicoleta și Faina, în același timp. Arhitectura am gândit-o toți împreună.

| Cine | Pagina | Fișierele |
| --- | --- | --- |
| Nicoleta | Pornire (încărcare) | `splash.fxml`, `SplashController` |
| Nicoleta | Autentificare | `login.fxml`, `LoginController`, `Sesiune`, `Utilizator` |
| Nicoleta | Panou principal + meniul lateral | gata, mai trebuie clădirea 3D (`Cladire3D`) |
| Nicoleta | Asistent AI (panoul din dreapta) | `chat.fxml`, `ChatController` |
| Nicoleta | Proiectează clasa | `proiectare.fxml`, `ProiectareController` |
| Faina | Setări | `setari.fxml`, `SetariController` |
| Faina | Rapoarte și grafice | `rapoarte.fxml`, `RapoarteController` |
| Faina | Facturi | `facturi.fxml`, `FacturiController`, `Factura`, `Facturi`, `FacturaService` |
| Sofia | Pagina cabinetului + codul QR | `sala.fxml`, `SalaController`, `CodQr`, `TelefonQr` |
| Sofia | Simulare Arduino | `live.fxml`, `LiveController`, `Monitor`, pachetul `sursa` |
| Sofia | Introducere citiri | `citiri.fxml`, `CitiriController`, `Citire`, `Citiri` |
| Sofia | Calculatoare STEM | `calculatoare.fxml`, `CalculatoareController`, `FormuleEnergie`, `Statistica` |
| Sofia | Sfaturi eco | `sfaturi.fxml`, `SfaturiController` |
| Ion | Placa Arduino și becul | `hardware/arduino_ina219/arduino_ina219.ino` |

Sus în fiecare fișier scrie ce trebuie făcut acolo și ce ecran din Figma copiați.

## Reguli

- Meniul, culorile și fonturile sunt gata. Folosiți clasele din `css/app.css` (lista e sus în fișier), nu scrieți culori în cod.
- Panou principal (`dashboard.fxml` + `DashboardController`) e exemplul după care faceți paginile.
- Lucrați doar în fișierele voastre. `MainController`, `main.fxml`, `App.java` și `Ui.java` nu le schimbăm fără să vorbim.
- Datele le luați din `ConsumService` și din pachetul `date`, ca să fie aceleași cifre peste tot.

## Cum lucrăm

### O singură dată, la început

1. Instalați [Git](https://git-scm.com/downloads) (Next la tot) și IntelliJ IDEA cu Java 21.
2. Acceptați invitația la repository din email.
3. Deschideți Git Bash și scrieți, pe rând:

```
git config --global user.name "Prenume Nume"
git config --global user.email "emailul@vostru.com"
git clone https://github.com/USERNAME/EcoEnergie-CEITI.git
cd EcoEnergie-CEITI
git checkout -b numele-vostru
```

Ultima linie vă face branch-ul vostru, de exemplu `git checkout -b sofia`. Lucrați doar pe el.

4. În IntelliJ: File → Open → folderul `EcoEnergie-CEITI` → Open as Project. Așteptați să se descarce bibliotecile.
5. Porniți `Launcher.java`. Se deschide direct meniul, ca să vă puteți testa pagina fără logare.

### De fiecare dată

Înainte să începeți, luați ce au făcut ceilalți:

```
git pull origin main
```

După ce ați terminat o bucată, o urcați pe GitHub (scrieți fișierele voastre în loc de exemplu):

```
git add src/main/java/md/ceiti/ecoenergie/ui/SetariController.java src/main/resources/md/ceiti/ecoenergie/fxml/setari.fxml
git commit -m "Setări: pragurile pe săli"
git push origin numele-vostru
```

### Când pagina e gata

Pe GitHub apăsați **Compare & pull request**, scrieți ce ați făcut și apoi **Create pull request**. Nicoleta verifică și o adaugă în `main`.

### Dacă ceva nu merge

- **rejected** la push: `git pull origin main`, apoi din nou `git push origin numele-vostru`.
- **conflict**: altcineva a schimbat același fișier. Nu ștergeți nimic, scrieți-i Nicoletei.
