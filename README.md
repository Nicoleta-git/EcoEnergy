# EcoEnergie CEITI

**English** · [Română](README.ro.md) · [Русский](README.ru.md)

A JavaFX app that shows how much electricity each room of the college uses. Project no. 1 for Advanced Programming Technologies, 4th year.

Team: Titei Nicoleta, Ababii Faina, Goncear Sofia, Ghinda Ion

The mockup and the wireframe are in [Figma](https://www.figma.com/design/Bkr6FzsNb0wzooRl5pZgqT/EcoEnergie).

## Documentation

- Stage 1 – [Problem analysis](docs/01_problem_analysis.md)
- Stage 2 – [Research](docs/02_research.md)
- Stage 3 – [Users](docs/03_users.md)
- Stage 4 – [Requirements](docs/04_requirements.md)
- Stage 5 – [Concept and STEAM](docs/05_concept_steam.md)
- Stage 6 – [Architecture](docs/06_architecture.md)
- Stage 9 – [Mockup](docs/09_digital_mockup.md)
- Stage 10 – [Navigation](docs/10_navigation.md)
- Stage 11 – [Roles](docs/11_roles.md)
- Stage 12 – [Mockup check](docs/12_mockup_check.md)
- Stage 13 – [Feedback](docs/13_feedback.md)
- Stage 14 – [Improvements](docs/14_improvements.md)

Stage 7 (the sketches) is on paper, stage 8 (the wireframe) is in Figma.

Appendices: [project sheet](docs/appendix/project_sheet.md) · [team journal](docs/appendix/team_journal.md) · [individual reports](docs/appendix/individual_reports.md) · [reflection](docs/appendix/reflection.md) · [project plan](PROJECT_PLAN.md)

## Who does what

Nicoleta and Faina made the wireframe and the general design in Figma, at the same time. We thought the architecture through all together.

| Who | Page | Files |
| --- | --- | --- |
| Nicoleta | Start (loading) | `splash.fxml`, `SplashController` |
| Nicoleta | Login | `login.fxml`, `LoginController`, `Sesiune`, `Utilizator` |
| Nicoleta | Dashboard + side menu | done, the 3D building is still missing (`Cladire3D`) |
| Nicoleta | AI assistant (right panel) | `chat.fxml`, `ChatController` |
| Nicoleta | Design the classroom | `proiectare.fxml`, `ProiectareController` |
| Faina | Settings | `setari.fxml`, `SetariController` |
| Faina | Reports and charts | `rapoarte.fxml`, `RapoarteController` |
| Faina | Bills | `facturi.fxml`, `FacturiController`, `Factura`, `Facturi`, `FacturaService` |
| Sofia | Room page + QR code | `sala.fxml`, `SalaController`, `CodQr`, `TelefonQr` |
| Sofia | Arduino simulation | `live.fxml`, `LiveController`, `Monitor`, the `sursa` package |
| Sofia | Meter readings | `citiri.fxml`, `CitiriController`, `Citire`, `Citiri` |
| Sofia | STEM calculators | `calculatoare.fxml`, `CalculatoareController`, `FormuleEnergie`, `Statistica` |
| Sofia | Eco tips | `sfaturi.fxml`, `SfaturiController` |
| Ion | Arduino board and bulb | `hardware/arduino_ina219/arduino_ina219.ino` |

At the top of every file it says what to do there and which Figma screen to copy. The app's screens are in Romanian, so the class and file names are in Romanian too.

## Rules

- The menu, colors and fonts are done. Use the classes from `css/app.css` (the list is at the top of the file), don't write colors in the code.
- The Dashboard (`dashboard.fxml` + `DashboardController`) is the example to follow for the other pages.
- Work only in your own files. We don't change `MainController`, `main.fxml`, `App.java` and `Ui.java` without talking first.
- Take the data from `ConsumService` and the `date` package, so the numbers are the same everywhere.

## How we work

### Once, at the start

1. Install [Git](https://git-scm.com/downloads) (Next on everything) and IntelliJ IDEA with Java 21.
2. Accept the repository invitation from your email.
3. Open Git Bash and type, one by one:

```
git config --global user.name "First Last"
git config --global user.email "your@email.com"
git clone https://github.com/USERNAME/EcoEnergie-CEITI.git
cd EcoEnergie-CEITI
git checkout -b your-name
```

The last line creates your own branch, for example `git checkout -b sofia`. Work only on it.

4. In IntelliJ: File → Open → the `EcoEnergie-CEITI` folder → Open as Project. Wait for the libraries to download.
5. Run `Launcher.java`. The menu opens directly, so you can test your page without logging in.

### Every time

Before you start, get what the others did:

```
git pull origin main
```

When you finish a piece, upload it to GitHub (write your own files instead of the example):

```
git add src/main/java/md/ceiti/ecoenergie/ui/SetariController.java src/main/resources/md/ceiti/ecoenergie/fxml/setari.fxml
git commit -m "Settings: room limits"
git push origin your-name
```

### When your page is done

On GitHub press **Compare & pull request**, write what you did and then **Create pull request**. Nicoleta checks it and merges it into `main`.

### If something goes wrong

- **rejected** on push: `git pull origin main`, then `git push origin your-name` again.
- **conflict**: someone else changed the same file. Don't delete anything, message Nicoleta.
