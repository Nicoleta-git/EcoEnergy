# Stage 4. Functional and non-functional requirements

**Done by:** Nicoleta

Functional requirements say what the app does. Non-functional ones say how it has to behave.

## Functional requirements

| Code | Requirement | Screen |
| --- | --- | --- |
| FR1 | The user logs in with a name and password; wrong data shows an error message | Login |
| FR2 | The app shows today's usage for every room, the cost and how many rooms are over the limit | Dashboard |
| FR3 | Every room has a color by usage: green under 75% of the limit, yellow between 75% and 100%, red over the limit | Dashboard, Room page |
| FR4 | The room manager writes the meter reading (room, date, hour, value); the app checks the data | Meter readings |
| FR5 | The usage is the difference between the new reading and the previous one | Meter readings |
| FR6 | The app shows the power in real time, from the sensor or from the simulator | Live monitoring |
| FR7 | The reports show the usage per day, compare the rooms and can be saved as CSV | Reports and charts |
| FR8 | The monthly bill is entered and compared with last month | Bills |
| FR9 | The administrator changes the limits, the tariff and the data source | Settings |
| FR10 | Every room has a QR code that shows its data on a phone | Room page |
| FR11 | Students calculate how much devices use and design a low-cost classroom | STEM calculators, Design the classroom |

## Non-functional requirements

| Code | Requirement |
| --- | --- |
| NFR1 | The interface is in Romanian and has the same menu, colors and fonts on every screen |
| NFR2 | Any screen opens from the menu with one click |
| NFR3 | The text has good contrast; there is a dark and a light theme |
| NFR4 | Wrong data is not accepted; the message says what to fix |
| NFR5 | The live page updates once per second |
| NFR6 | The app works on Windows, without internet, with Java 21 |
| NFR7 | Only the administrator can change the settings |
