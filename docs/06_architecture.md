# Stage 6. App architecture

**Done by:** the whole team (we thought it through together)

The app has three layers. The screens only show the data and read what the user types. The services do the calculations and the checks. The data layer keeps the information. This way a calculation changes in one place, without touching the screens.

## 1. The three layers

```mermaid
flowchart TB
    admin(["Administrator"])
    resp(["Room manager"])
    elev(["Student / visitor"])

    prez["<b>1. Presentation layer</b><br/>JavaFX: FXML + controllers<br/><br/>LoginController<br/>MainController<br/>DashboardController<br/>SalaController<br/>CitiriController<br/>FacturiController<br/>RapoarteController<br/>LiveController<br/>CalculatoareController<br/>SfaturiController<br/>ProiectareController<br/>SetariController<br/>ChatController<br/><br/><i>Cladire3D, TelefonQr, CodQr</i>"]

    serv["<b>2. Logic layer</b><br/>services<br/><br/>Sesiune<br/>ConsumService<br/>FacturaService<br/>FormuleEnergie<br/>Statistica<br/>Monitor"]

    date["<b>3. Data layer</b><br/>model<br/><br/>Sala, Citire, ConsumZi<br/>SalaConsum, Factura<br/>Utilizator, Nivel<br/><br/>Sali, Consumuri, Citiri<br/>Facturi, Setari<br/><br/><i>later: a database</i>"]

    surse["<b>Measurement sources</b><br/><br/>SursaDate<br/>SimulatorSursa<br/>ArduinoSursa<br/><br/><i>INA219 + Arduino</i>"]

    admin --> prez
    resp --> prez
    elev -. "QR code" .-> prez
    prez -- "calls methods" --> serv
    serv -- "results" --> prez
    serv -- "reads / writes" --> date
    surse -- "one measurement per second" --> serv
```

| Layer | Package in the code | What it contains |
| --- | --- | --- |
| Presentation | `ui` + the `fxml` and `css` files | the screens and their controllers, the 3D model (`Cladire3D`), the QR code (`CodQr`, `TelefonQr`) |
| Logic | `service` | the calculations, data checks, live measurement |
| Data | `model` + `date` | the data classes and the lists they are kept in |
| Sources | `sursa` | where the measurements come from: simulator or Arduino |

The class and package names are in Romanian, like the app (for example `Sala` = room, `Citire` = reading, `Factura` = bill, `Consum` = usage).

## 2. The path of a meter reading

```mermaid
sequenceDiagram
    actor R as Room manager
    participant E as CitiriController
    participant S as ConsumService
    participant D as Citiri and Consumuri

    R->>E: picks the room, date, hour and types the value
    E->>E: checks the hour (HH:MM) and the number
    alt wrong data
        E-->>R: error message under the form
    else correct data
        E->>S: adaugaCitire(room, date, value)
        S->>D: gets the room's last reading
        S->>S: usage = new reading − old reading
        S->>D: saves the reading and the usage
        S-->>E: the calculated usage
        E-->>R: confirmation message
    end
```

For now the data is sample data; saving to a database comes in the next stage.

## 3. The path of a sensor measurement

```mermaid
flowchart LR
    a["INA219 sensor<br/><i>measures U and I</i>"] --> b["Arduino<br/><i>sends over USB</i>"]
    b --> c["ArduinoSursa<br/><i>P = U · I</i>"]
    c --> d["Monitor<br/><i>one measurement per second</i>"]
    d --> e["LiveController<br/><i>gauge + 60 s chart</i>"]
    d --> f["Consumuri<br/><i>adds the Wh to the room</i>"]
    f --> g["Dashboard<br/><i>green / yellow / red bars</i>"]
```

Without the board, `SimulatorSursa` gives values like a projector of about 240 W, and the rest of the path stays the same.

## 4. The data classes

```mermaid
classDiagram
    class Sala {
        +int id
        +String cod
        +String nume
        +int etaj
        +double prag
    }
    class Citire {
        +int salaId
        +String sala
        +LocalDateTime data
        +double valoare
        +String utilizator
        +String observatii
    }
    class SalaConsum {
        +Sala sala
        +double kwh
        +procent() double
        +nivel() Nivel
    }
    class Nivel {
        <<enumeration>>
        VERDE
        GALBEN
        ROSU
    }
    class ConsumZi {
        +LocalDate data
        +double kwh
    }
    class Factura {
        +int id
        +String numar
        +String luna
        +double kwh
        +double totalLei
        +String sursa
        +tarif() double
    }
    class Utilizator {
        +String username
        +String nume
        +String rol
        +esteAdmin() boolean
    }
    class SursaDate {
        <<interface>>
        +nume() String
        +porneste()
        +opreste()
    }
    Citire --> Sala : belongs to a room
    SalaConsum --> Sala : contains
    SalaConsum --> Nivel : calculates
    SursaDate <|.. SimulatorSursa
    SursaDate <|.. ArduinoSursa
```

## Libraries

| Library | What we use it for |
| --- | --- |
| JavaFX 21 | the interface, the charts, the 3D model |
| AtlantaFX | the theme (base colors of the controls) |
| Ikonli | the icons |
| TilesFX | the gauge on the live page |
| ZXing | the QR codes |
| jSerialComm | reading the Arduino data over USB |
