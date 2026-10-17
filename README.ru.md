# EcoEnergie CEITI

[English](README.md) · [Română](README.ro.md) · **Русский**

Приложение на JavaFX, которое показывает, сколько электричества потребляет каждый кабинет колледжа. Проект №1 по предмету «Передовые технологии программирования», 4 курс.

Команда: Титей Николета, Абабий Фаина, Гончар София, Гында Ион

Макет и вайрфрейм находятся в [Figma](https://www.figma.com/design/Bkr6FzsNb0wzooRl5pZgqT/EcoEnergie).

## Документация

Документация написана на английском.

- Этап 1 – [Анализ проблемы](docs/01_problem_analysis.md)
- Этап 2 – [Исследование аналогов](docs/02_research.md)
- Этап 3 – [Пользователи](docs/03_users.md)
- Этап 4 – [Требования](docs/04_requirements.md)
- Этап 5 – [Концепция и STEAM](docs/05_concept_steam.md)
- Этап 6 – [Архитектура](docs/06_architecture.md)
- Этап 9 – [Макет](docs/09_digital_mockup.md)
- Этап 10 – [Навигация](docs/10_navigation.md)
- Этап 11 – [Роли](docs/11_roles.md)
- Этап 12 – [Проверка макета](docs/12_mockup_check.md)
- Этап 13 – [Отзывы](docs/13_feedback.md)
- Этап 14 – [Улучшения](docs/14_improvements.md)

Этап 7 (эскизы) – на бумаге, этап 8 (вайрфрейм) – в Figma.

Приложения: [карточка проекта](docs/appendix/project_sheet.md) · [журнал команды](docs/appendix/team_journal.md) · [индивидуальные отчёты](docs/appendix/individual_reports.md) · [рефлексия](docs/appendix/reflection.md) · [план проекта](PROJECT_PLAN.md)

## Кто что делает

Вайрфрейм и общий дизайн в Figma сделали Николета и Фаина, одновременно. Архитектуру продумали все вместе.

| Кто | Страница | Файлы |
| --- | --- | --- |
| Николета | Загрузка | `splash.fxml`, `SplashController` |
| Николета | Вход | `login.fxml`, `LoginController`, `Sesiune`, `Utilizator` |
| Николета | Главная панель + боковое меню | готово, осталось 3D-здание (`Cladire3D`) |
| Николета | AI-ассистент (правая панель) | `chat.fxml`, `ChatController` |
| Николета | Проектирование класса | `proiectare.fxml`, `ProiectareController` |
| Фаина | Настройки | `setari.fxml`, `SetariController` |
| Фаина | Отчёты и графики | `rapoarte.fxml`, `RapoarteController` |
| Фаина | Счета | `facturi.fxml`, `FacturiController`, `Factura`, `Facturi`, `FacturaService` |
| София | Страница кабинета + QR-код | `sala.fxml`, `SalaController`, `CodQr`, `TelefonQr` |
| София | Симуляция Arduino | `live.fxml`, `LiveController`, `Monitor`, пакет `sursa` |
| София | Ввод показаний | `citiri.fxml`, `CitiriController`, `Citire`, `Citiri` |
| София | STEM-калькуляторы | `calculatoare.fxml`, `CalculatoareController`, `FormuleEnergie`, `Statistica` |
| София | Эко-советы | `sfaturi.fxml`, `SfaturiController` |
| Ион | Плата Arduino и лампочка | `hardware/arduino_ina219/arduino_ina219.ino` |

Вверху каждого файла написано, что нужно сделать и какой экран из Figma повторить. Интерфейс приложения на румынском, поэтому имена классов и файлов тоже на румынском.

## Правила

- Меню, цвета и шрифты уже готовы. Используйте классы из `css/app.css` (список вверху файла), не пишите цвета в коде.
- Главная панель (`dashboard.fxml` + `DashboardController`) – пример, по которому делаем остальные страницы.
- Работайте только в своих файлах. `MainController`, `main.fxml`, `App.java` и `Ui.java` не меняем, не договорившись.
- Данные берите из `ConsumService` и пакета `date`, чтобы цифры везде были одинаковые.

## Как мы работаем

### Один раз, в начале

1. Установите [Git](https://git-scm.com/downloads) (везде Next) и IntelliJ IDEA с Java 21.
2. Примите приглашение в репозиторий из почты.
3. Откройте Git Bash и введите по очереди:

```
git config --global user.name "Имя Фамилия"
git config --global user.email "ваш@email.com"
git clone https://github.com/Nicoleta-git/EcoEnergy.git
cd EcoEnergy
git checkout -b ваше-имя
```

Последняя строка создаёт вашу ветку, например `git checkout -b sofia`. Работайте только в ней.

4. В IntelliJ: File → Open → папка `EcoEnergy` → Open as Project. Подождите, пока скачаются библиотеки.
5. Запустите `Launcher.java`. Сразу откроется меню, чтобы можно было проверить свою страницу без входа.

### Каждый раз

Перед началом заберите то, что сделали другие:

```
git pull origin main
```

Когда закончили часть, загрузите её на GitHub (вместо примера напишите свои файлы):

```
git add src/main/java/md/ceiti/ecoenergie/ui/SetariController.java src/main/resources/md/ceiti/ecoenergie/fxml/setari.fxml
git commit -m "Настройки: пороги по кабинетам"
git push origin ваше-имя
```

### Когда страница готова

На GitHub нажмите **Compare & pull request**, напишите, что сделали, и нажмите **Create pull request**. Николета проверит и добавит в `main`.

### Если что-то не работает

- **rejected** при push: `git pull origin main`, потом снова `git push origin ваше-имя`.
- **conflict**: кто-то другой изменил тот же файл. Ничего не удаляйте, напишите Николете.
