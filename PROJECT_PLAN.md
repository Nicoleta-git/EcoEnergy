# EcoEnergie CEITI – project plan

Project no. 1 for Advanced Programming Technologies, 4th year: an app that shows how much each room of the college uses.

Mockup: https://www.figma.com/design/Bkr6FzsNb0wzooRl5pZgqT/EcoEnergie
Documentation by stage: [docs/README.md](docs/README.md)

## Team

| Person | Role | What they do | What they present |
| --- | --- | --- | --- |
| **Titei Nicoleta** | Project coordinator | Wireframe and general design in Figma (with Faina); Design the classroom (the simulator), the login and loading pages, the Dashboard with the side menu, the side panel with the AI assistant; the analysis stages (1, 3, 4, 5, 13) | The problem, the target group and the architecture (2 min) |
| **Ababii Faina** | UI/UX designer | Wireframe and general design in Figma (with Nicoleta, at the same time); Settings, Reports and charts, the Bills page | The mockup, screen by screen (2 min) |
| **Goncear Sofia** | JavaFX pages | Eco tips, STEM calculators, the room page with the QR code, the Arduino simulation page, Meter readings | Concept + STEAM (1 min) |
| **Ghinda Ion** | Hardware | Arduino board + INA219 + 12 V bulb | Demo with the bulb (1 min) |

We thought the architecture through all together.

## How we worked

We started with the problem analysis and the paper sketches. From them we made the wireframe, then the color mockup in Figma (Nicoleta and Faina, at the same time). After the mockup we started the JavaFX app, everyone with their own pages.

## What we use

- Figma for the wireframe and the mockup
- Mermaid for the architecture and navigation diagrams (they show up directly on GitHub)
- IntelliJ IDEA, Java 21, JavaFX 21, Maven, Scene Builder
- AtlantaFX (theme), Ikonli (icons), TilesFX (live gauge), ZXing (QR codes), jSerialComm (Arduino)
- Arduino Uno + INA219 sensor + a 12 V bulb
- GitHub for the code and the documents

## What the app does

- shows every room in green, yellow or red, depending on its usage compared to its limit
- cost in lei and CO₂, not just kWh
- the college building in 3D, with colored rooms
- a page for every room, with a 14-day chart and a QR code for the door
- live measurement from the Arduino (or from a simulator when we don't have the board)
- entering meter readings, with error and confirmation messages
- monthly bills
- reports with charts, a ranking of the rooms and CSV export
- STEM calculators with the formulas shown
- eco tips with the savings over a year
- Design the classroom: drag devices into a classroom and see how much it costs
- an AI assistant in the right panel and a light / dark theme

The tariff of 3.10 lei/kWh and the CO₂ factor of 0.45 kg/kWh are examples for now; we need to put the ones from the college's bill.

## Stages from the material

| No. | Stage | Who | Where |
| --- | --- | --- | --- |
| 1 | Problem analysis | Nicoleta | [01](docs/01_problem_analysis.md) |
| 2 | Research | everyone | [02](docs/02_research.md) |
| 3 | Users | Nicoleta | [03](docs/03_users.md) |
| 4 | Requirements | Nicoleta | [04](docs/04_requirements.md) |
| 5 | Concept and STEAM | Nicoleta | [05](docs/05_concept_steam.md) |
| 6 | Architecture | the whole team | [06](docs/06_architecture.md) |
| 7 | Paper sketches | everyone | on paper |
| 8 | Wireframe | Nicoleta, Faina | Figma, page "Wireframe" |
| 9 | Mockup | Nicoleta, Faina | [09](docs/09_digital_mockup.md) |
| 10 | Navigation | Nicoleta, Faina | [10](docs/10_navigation.md) |
| 11 | Roles | Nicoleta | [11](docs/11_roles.md) |
| 12 | Mockup check | Nicoleta, Faina | [12](docs/12_mockup_check.md) |
| 13 | Feedback | Nicoleta | [13](docs/13_feedback.md) |
| 14 | Improvements | Faina | [14](docs/14_improvements.md) |
| 15 | Presentation | the whole team | |

Still to fill in: the research sheets, the paper sketches, the feedback from another team, the journal and the individual reports.

## Presentation (5–7 minutes)

| Part | Who |
| --- | --- |
| The problem and who the app is for | Nicoleta |
| The concept and the STEAM connection | Sofia |
| The architecture | Nicoleta |
| The mockup, screen by screen | Faina |
| Demo with the bulb and the simulator | Ion |
