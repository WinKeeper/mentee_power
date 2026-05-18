# Devtools

[![Style and test](https://github.com/WinKeeper/devtools/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/WinKeeper/devtools/actions/workflows/ci.yml)

## Технологический стек проекта

### Языки и платформы

- **Java 25 LTS** — основной язык разработки
- **Gradle 9.x** — система сборки (через Gradle Wrapper)

### Инструменты качества кода

- **Checkstyle** — статический анализ стиля кода
    - Конфигурация: `config/checkstyle/checkstyle.xml`
    - Запуск: `./gradlew checkstyleMain`
- **JUnit 5** — фреймворк тестирования
    - Запуск: `./gradlew test`

### CI/CD

- **GitHub Actions** — автоматическая проверка PR
    - Checkstyle на каждый коммит
    - Тесты на каждый коммит
    - Конфигурация: `.github/workflows/`

### Правила кода

- Стиль: Google Java Style Guide (через Checkstyle)
- Коммиты: Conventional Commits (`feat:`, `fix:`, `docs:`)
- Ветки: `feature/DVT-X` для задач, `master` — основная
- Pull Request: обязателен для слияния в master

## DVT-2 — Gradle-проект и базовый main

https://mentee-power.xl.ru/learn/MCIneBj4KkyH-GIRCspFvA/theory

### 🚀 Quick Start Gradle: запуск задачи run, build, test через Gradle Tool Window и Run Anything (Ctrl + Ctrl)

### ▶️ Запуск задачи `run` (демонстрация программы)

#### Способ 1: Gradle Tool Window

1. Откройте **Gradle Tool Window**:  
   `View` → `Tool Windows` → `Gradle`

2. Разверните дерево задач:

📁 devtools
└── 📁 Tasks
└── 📁 application
└── ▶️ run

3. **Двойной клик** на `run` — задача запустится

#### Способ 2: Run Anything (Ctrl + Ctrl)

1. Нажмите **`Ctrl` дважды** (быстро) — откроется окно `Run Anything`

2. Введите команду: gradle run, gradle build или gradle test.

#### Способ 3: Через консоль

1. В консоли ввести команды: ./gradlew run, ./gradlew test или ./gradlew build

### 📦 Packages: Зачем нужен пакет `ru.mentee.power`

**Пакет (package)** — это пространство имён, которое организует классы в иерархию и предотвращает конфликты имён.

- Группирует логически связанные классы
- Предотвращает конфликты имён
- Управляет доступом (модификатор package-private)

Таблица переменных/полей: menteeName, sprintNumber, plannedHoursPerWeek, правило readyForSprint().

### Правило обратного доменного имени (Reverse Domain Name Convention)

**Правило обратного доменного имени** — это стандарт именования пакетов в Java, при котором имя пакета строится из
доменного имени компании/владельца, записанного в обратном порядке.

1. Глобальная уникальность
   Проблема: В мире тысячи компаний, и каждая может создать класс User, Progress или Main.
   Решение: Доменные имена УНИКАЛЬНЫ. Если перевернуть домен mentee.ru → ru.mentee — такой пакет больше никто не
   использует.
2. Единый стандарт
   Все Java-разработчики мира используют это правило. Если вы видите пакет com.google. — сразу понятно, что код от
   Google. org.apache. — от Apache.
3. Иерархическая организация
   Домены читаются справа налево (от общего к частному), а пакеты — слева направо:

- Домен:        ru → mentee → power
- Пакет:        ru.mentee.power
- Иерархия:     страна → компания → проект

### MenteeProgress таблица полей

| Имя поля              | Тип данных | Описание                                          |
|-----------------------|------------|---------------------------------------------------|
| `menteeName`          | String     | Имя стажёра (Mentee)                              |
| `sprintNumber`        | int        | Номер спринта                                     |
| `plannedHoursPerWeek` | int        | Планируемое количество часов в неделю для спринта |

## DVT-3 — Git Essentials: локальный цикл

### Правило веток: feature/DVT-X

В Dev Tools оставляем master чистым, работу ведём в ветке feature/DVT-<номер> - это упрощает проверку и дальнейший PR.
Подход соответствует lightweight Git Flow.

## DVT-4 — GitHub и первый Pull Request

## DVT-5 — Чистый Git‑репозиторий

<pre>Перед push: git status clean</pre>

- После добавления новых инструментов — обновляйте .gitignore и делайте санитарный коммит при необходимости.
- Если случайно удалили файлы без --cached, восстановитесь из локальной истории/изменений IDE.
- Перед push проверяйте «status clean» в IDE и CLI; при расхождениях — ищите источник (новые артефакты/настройки).

## DVT-6: Один цикл и контроль прогресса — освоение Debug

### Сценарий ручной проверки DVT-6

#### Запуск приложения

1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

#### Запуск тестов

1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

#### Отладка через Debug

1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

#### Что делать при ошибках

- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

## DVT-7: Checkstyle и культура кода — автоматизация стандартов

### Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

#### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

#### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

#### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

#### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

#### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

## DVT-9: Правила Code Review — культура ревью

### Приоритетные навыки Code Review для Dev Tools

1. Проверка очевидных проблем перед запросом ревью В само-ревью ищите явные проблемы: забытые System.out.println для
   отладки, закомментированный код, TODO без контекста, опечатки в именах переменных, неиспользуемые импорты. Эти
   проблемы ревьюер найдёт за секунды, но они создают впечатление небрежности. Потратьте 5 минут на Self Review, чтобы
   сэкономить 30 минут времени ревьюера. Официальный гайд Google по Code Review рекомендует авторам проверять PR как
   минимум дважды: сразу после создания и через час, свежим взглядом.

2. Использование чеклиста для систематичности Чеклист гарантирует, что вы не пропустите важные аспекты. Проверяйте по
   порядку: функциональность → тесты → читаемость → производительность → безопасность → документация. Не полагайтесь на
   память: в спешке легко забыть проверить тесты или обновить README. Держите чеклист в README проекта и отмечайте
   пункты при каждом PR. Согласно исследованию Microsoft Research, использование чеклиста сокращает время ревью на 25% и
   увеличивает находимость дефектов на 15%.

3. Формулирование конкретных замечаний Вместо расплывчатого «что-то не так» пишите «метод processData имеет 45 строк и
   делает 4 разные вещи: парсинг, валидацию, трансформацию и сохранение. Предлагаю разбить на 4 метода для соблюдения
   Single Responsibility Principle». Указывайте номер строки, проблему, причину и предложение. Такие комментарии обучают
   и автора, и будущих читателей PR. Рекомендации Thoughtworks Code Review Guidelines подчёркивают: хороший комментарий
   отвечает на «что, почему, как исправить».

4. Проверка соответствия архитектурным принципам Даже в простом проекте Dev Tools важно соблюдать структуру пакетов и
   разделение ответственности. Проверяйте: классы лежат в правильных пакетах (ru.mentee.power.devtools.*), методы не
   слишком длинные (больше 20-30 строк — сигнал для декомпозиции), нет дублирования кода. Если видите копипасту —
   предложите вынести в общий метод. Архитектурные проблемы дешевле исправить на этапе ревью, чем рефакторить после
   слияния.

5. Оценка покрытия тестами Для каждого нового public метода должен быть минимум один тест. Проверяйте, что тесты
   покрывают граничные случаи (пустые данные, null, экстремальные значения) и негативные сценарии (обработка ошибок).
   Если тестов нет или они тестируют только «счастливый путь» — это критическое замечание. Тесты — это документация
   поведения кода и страховка от регрессий. JaCoCo отчёт (подключённый в DVT-7) покажет процент покрытия, но качество
   тестов оценивает только человек.

6. Проверка обновления документации После добавления новых классов или методов проверьте, что README обновлён: добавлено
   описание новой функциональности, примеры использования, обновлены команды запуска если изменились. Для публичных
   API (пока не в Dev Tools, но в будущих модулях) проверяйте наличие JavaDoc. Документация — это забота о будущих
   читателях, включая вас через полгода. Отсутствие документации — это технический долг, который растёт с каждым PR.

7. Само-рефлексия и обучение При само-ревью задавайте себе вопросы: «Понятен ли этот код коллеге, который не знаком с
   задачей?», «Легко ли будет добавить новую функциональность в будущем?», «Что я сам узнал нового, решая эту задачу?».
   Фиксируйте паттерны ошибок: если часто забываете обновлять README, добавьте это в чеклист первым пунктом.
   Само-ревью — это тренировка критического мышления и возможность учиться на своих ошибках до того, как их увидят
   другие.

## Code Review Checklist

### Функциональность

- [X] Код полностью решает поставленную задачу (./gradlew clean checkstyleMain test jacocoTestCoverageVerification
  build)
- [X] Обработаны граничные случаи (null, пустые коллекции, экстремальные значения)
- [X] Ошибки обрабатываются корректно

### Тесты

- [X] Добавлены тесты для нового функционала
- [X] Все тесты проходят локально (`./gradlew test`)
- [X] Покрыты позитивные и негативные сценарии
- [X] Проверены граничные случаи
- [X] JaCoCo coverage ≥ 80% для нового кода

### Читаемость и стиль

- [X] Имена переменных, методов и классов понятные и отражают назначение
- [X] Нет дублирования кода (DRY principle)
- [X] Код легко читается
- [X] Checkstyle проходит (`./gradlew checkstyleMain`)
- [X] Нет закомментированного кода или отладочного вывода (`System.out.println`)

### Документация

- [X] README обновлён (если добавлена новая функциональность)
- [ ] Публичные методы имеют JavaDoc (если применимо)
- [X] Примеры использования актуальны
- [ ] Runbook обновлён (если изменились команды запуска/проверки)

### Производительность и безопасность

- [X] Нет очевидных проблем производительности
- [X] Нет хардкода паролей, токенов или конфиденциальных данных

---

## Примеры Code Review комментариев

### Хорошие комментарии (конструктивные)

**Пример 1:**

**Проблема:** Метод `calculateDiscount` (строка 45) имеет 3 вложенных if-else и 40 строк.
**Почему это важно:** Сложная логика плохо тестируется и тяжело поддерживается.
**Предложение:** Вынести каждое условие в отдельный метод (например, `isEligibleForBonusDiscount()`) и использовать

паттерн Strategy для разных типов скидок.

**Пример 2:**

**Проблема:** Тест `testProcessOrder` (строка 78) проверяет только успешный сценарий.
**Почему это важно:** Не проверена обработка ошибок при недостаточном балансе.
**Предложение:** Добавить тест `testProcessOrder_InsufficientBalance_ThrowsException()` с использованием
`assertThatThrownBy()`.

### Плохие комментарии (неконструктивные)

*Этот код ужасен, полностью переписать.*

**Почему плохо:** Нет конкретики (что именно плохо), нет предложения (как исправить),
токсичный тон (демотивирует автора).

**Пример 2:**

*Здесь лучше использовать Stream API.*

**Почему плохо:** Нет объяснения почему лучше, нет примера как переписать,
неясно какую проблему это решает.

---

## Результаты само-ревью DVT-9»

### Найденные проблемы

#### 1. Название файла ci.yml не отражает функционал

**Файл:** ci.yml (строка 1)
**Проблема:** Название файла ci.yml "Style and test" отражает только часть процессов
**Почему важно:** При выборе может быть неочевиден выбор данного CI в виду очень общего названия без определения системы
и т.д.
**Исправление:** Переименовать CI в предложенный в DVT-7 "Java CI"

#### 2. Забыта закомментированная заглушка

**Файл:** src/main/java/ru/mentee/power/devtools/progress/ProgressTracker.java (строка 26)
**Проблема:** Закомментирован
`// throw new UnsupportedOperationException("Метод calculateTotalProgress ещё не реализован");`
**Почему важно:** Закомментированный код создаёт путаницу: непонятно зачем он сохранён и актуален ли. Видимо функция
была заглушкой до реализации метода и теперь не нужна.
**Исправление:** Удалить закомментированный код.

#### 3. Закомментированный код

**Файл:** src/main/java/ru/mentee/power/ProgressDemo.java (строка 3)
**Проблема:** Закомментирована одна строка
**Почему важно:** Закомментированный код создаёт путаницу: непонятно зачем он сохранён и актуален ли.
Если нужна история изменений — она в Git.
**Исправление:** Удалить закомментированный код. Если нужна старая версия — посмотреть в Git History.
**Аналогично:** src/main/java/ru/mentee/power/devtools/student/StudentList.java - удалить все комментарии.

```java

```

## DVT-11: Информационный поиск и AI-инструменты разработчика

## Информационный поиск — результаты DVT-11

### Запросы и источники

| № | Запрос              | Операторы                                                         | Официальный источник                                                                                                                                       | Альтернатива                                                        | Статус | Дата проверки |
|---|---------------------|-------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|--------|---------------|
| 1 | Lombok Gradle Short | site:search.maven.org "lombok" OR site:mvnrepository.com "lombok" | https://central.sonatype.com/artifact/org.projectlombok/lombok/1.18.46                                                                                     | https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.46 | 200 OK | 18.05.2026    |
| 2 | Stream API          | site:docs.oracle.com "stream api" intitle:api java 25             | https://docs.oracle.com/en/middleware/standalone/coherence/15.1.1/develop-applications/using-repository-api.html#GUID-65BEEC66-BB8D-43D4-A4D9-1A53B133A633 | https://www.baeldung.com/java-8-streams                             | 200 OK | 18.05.2026    |
| 3 | Itellij IDEA keymap | site:www.jetbrains.com/help "keymap" "intellij idea"              | https://www.jetbrains.com/help/idea/settings-keymap.html#how-it-works                                                                                      | File->Settings->Keymap (Windows, Linux) Ctrl+Alt+S                  | 200 OK | 18.05.2026    |

### AI-промпты и сравнение ассистентов

#### Промпт 1: План решения

**Контекст:** Я работаю над проектом Java 25 с Gradle сборщиком. Я создал на GitHub в разделе Actions CI.yml для
автоматизации проверки.
**Задача:** Необходимо настроить CI для stylecheck проверки test файлов при PR.
**Ограничения:** Не пиши готовый конфиг CI.
**Ожидаемый результат:** Основные причины почему test файлы не попадают в stylecheck CI проверку. Расположи по убыванию
частоты их возникновения.
**Критерии успеха:** Зелёный значёк в PR.

**AI-1 (ChatGPT):**

🚨 Возможные проблемы

* CI не настроен на `pull_request`
* Ограничения по веткам (`branches`)
* Используются `paths` фильтры, исключающие test
* Условие `if` не включает PR

---

* В CI не запускается task с тестами
* Тесты явно отключены (`-x test`)
* Используется не тот Gradle task

---

* Неправильная структура папок (`src/test/java`)
* Неправильные имена тестов
* Отсутствуют аннотации тестов

---

* Проблемы с зависимостями (JUnit)
* Не настроен test runner

---

* Несовпадение версии Java (локально vs CI)
* Runner не поддерживает Java 25

---

* Тесты пропущены или отключены
* Тесты падают (CI красный)

---

* Кэш или некорректная сборка

---

✅ Итог

Проблема обычно в одной из трёх зон:

* триггер CI
* конфигурация сборки
* структура/настройка тестов

**AI-2 (DeepSeek):**

Ключевая проблема в вашем описании — **тестовые файлы не проверяются**, хотя сам CI запускается. Вот наиболее вероятные
причины (без готового конфига):

1. Неправильный `paths` или `paths-ignore` в триггере

- У вас может быть `paths-ignore: ['**/*.java']` или наоборот `paths:` включает только `src/main/...`, исключая
  `src/test/...`
- Проверьте секцию `on.pull_request.paths` — тестовые пути должны быть либо явно перечислены, либо не указаны (тогда
  проверяются все изменения)

2. Команда сборки не включает тесты

- В шагах CI используется `mvn compile` или `mvn install -DskipTests`
- Нужно убедиться, что фаза `test` или `verify` выполняется без пропуска тестов

3. Тесты не распознаются как тестовые классы

- Java 25 может использовать новый синтаксис или preview-фичи, которые Maven/Gradle с текущей конфигурацией не считают
  тестами
- Проверьте naming conventions: `*Test.java`, `*Tests.java`, `Test*.java` или аннотации (JUnit 5)

4. Неправильная версия JUnit или плагина surefire/failsafe

- Плагин surefire может требовать явного указания версии для Java 25
- Возможно, тесты написаны на JUnit 5, а используется surefire без зависимости `junit-platform-suite`

5. Фильтрация тестов в Maven/Gradle

- В конфиге может быть `<includes>` или `<excludes>` для тестов, которые не покрывают ваши тестовые файлы
- Gradle: `test.include`/`test.exclude`

6. Ошибка на уровне GitHub Actions workflow

- `if: github.event_name == 'push'` — при PR событие `pull_request`, а не `push`
- `if: success()` или `if: always()` может пропускать шаг с тестами

7. Проблема с кэшированием

- Если используется cache для `~/.m2`, возможно, туда попадает неверная версия JUnit, которая игнорирует тесты

8. Тесты не компилируются из-за разных версий Java

- В CI используется Java 25 для компиляции main, но тесты могут требовать другую версию или у них другие source/target

Диагностика без изменения кода:

- Посмотрите **логи сборки** — ищите `Running` или `Tests run:` — если строка отсутствует, тесты не запускались
- Добавьте временно `--fail-at-end` или `--debug`, чтобы увидеть, какие цели выполняются
- Проверьте **вывод команды** `mvn test` локально с теми же параметрами, что в CI

**Сравнение:**

Ответы охватывают основные возможные проблемы со сборщиком, CI, аннотацией и неймингом.

#### Промпт 2: Проверка кода

**Я написал код на Java 25:**
public static void main(String[] args) {

    MenteeProgress progress =
        new MenteeProgress("Nikita", 1, 6);

    System.out.println(progress.summary());

    if (progress.readyForSprint()) {
      System.out.println("Status: sprint ready");
    } else {
      System.out.println("Status: backlog first");
    }

    System.out.println("Ветка feature/DVT-3");

}
**Что проверить:**

1. Логические ошибки
2. Соответствие Code Conventions
3. Производительность

НЕ переписывай код — укажи проблемы и предложи как исправить.

**AI-1 (ChatGPT):**

✅ **Итог**

❗ Нет валидации — возможны некорректные данные и ошибки в логике
🔒 Захардкоженные значения — код трудно переиспользовать и тестировать
🖨 System.out.println — нет уровней логирования и гибкости вывода
🌐 Смешение языков — ухудшается читаемость и единообразие кода
🧹 Лишний отладочный вывод — засоряет консоль и не нужен в production
⚡ Неэффективный вывод — лишние I/O операции при множественных вызовах

**AI-2 (DeepSeek):**

✅ **Итог**

* Нет валидации входных параметров конструктора (null, пустая строка, отрицательные числа)
* Захардкоженные строковые литералы в выводе (магические строки)
* Использование `System.out.println` вместо логирования в production-коде
* Смешение языков (русский и английский в сообщениях)
* Лишний отладочный вывод ("Ветка feature/DVT-3" явно не для конечного пользователя)
* Нарушение JavaBeans convention: `readyForSprint()` должен называться `isReadyForSprint()`
* Потенциально неэффективный вывод — двойной вызов тяжелых методов `summary()` и `readyForSprint()`
* Отсутствие проверки корректности бизнес-логики: может ли `tasksCompleted` (6) превышать допустимое количество задач в
  спринте?

**Сравнение:**

Основные замечания схожи: валидация, захардкоженные переменные, sout и т.д.

## Личный глоссарий терминов Dev Tools

### Структура глоссария

Каждый термин содержит:

- **RU / EN** — русское и английское название
- **Определение** — краткое (1-2 предложения) объяснение термина
- **Контекст использования** — где и когда применяется
- **Пример** — конкретное применение в коде/команде/документации
- **Источник** — ссылка на официальную документацию

### Категория: Java-экосистема

---

#### JDK — Java Development Kit

**Определение:** Development environment for building applications using the Java programming language. Includes
compiler (javac), archiver (jar), documentation generator (javadoc), and other tools.

**Контекст использования:** JDK необходим для компиляции Java-кода в байт-код и создания исполняемых JAR-файлов. Без JDK
невозможно собрать Java-проект.

**Пример:** После установки JDK выполняем `java -version` для проверки версии. В IntelliJ IDEA настраиваем Project SDK:
File → Project Structure → Project → SDK → выбираем JDK 25.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### JRE — Java Runtime Environment

**Определение:** Software environment in which Java programs run. Includes the implementation of the Java Virtual
Machine (JVM) and core libraries required for execution.

**Контекст использования:** JRE используется для запуска Java-приложений без необходимости компиляции. Достаточно
установить JRE, если требуется только выполнение программ.

**Пример:** Для запуска готового приложения выполняем java -jar app.jar, при этом используется установленная JRE.

**Источник:** https://docs.oracle.com/cd/E19455-01/806-3461/6jck06gqd/index.html

---

#### Gradle Wrapper

**Определение:** The Gradle Wrapper is a script (called gradlew or gradlew.bat) that invokes a declared version of
Gradle, downloading it beforehand if necessary.

**Контекст использования:** Gradle Wrapper гарантирует, что все разработчики и CI используют одну и ту же версию Gradle
без ручной установки.

**Пример:** Вместо gradle build используем `./gradlew build`. Использование `./gradlew build` вместо gradle build
обеспечивает автоматическое использование (и при необходимости — загрузку) именно той версии Gradle, которая объявлена в
проекте.

**Источник:** https://docs.oracle.com/javase/specs/jvms/se25/html/index.html

---

#### Build Tool

**Определение:** A build tool automates the process of building software, including compiling, testing, and packaging
code.

**Контекст использования:** Build tool (например, Gradle) управляет жизненным циклом проекта: сборкой, тестированием и
публикацией.

**Пример:** Команда gradle build компилирует код, запускает тесты и создает JAR-файл.

**Источник:** https://docs.gradle.org/current/userguide/building_java_projects.html

---

#### Dependency

**Определение:** A dependency is a pointer to another piece of software required to build, test, or run a module.

**Определение:** A dependency is a library that your project requires to build, test, and run. (maven)

**Контекст использования:** Зависимости подключаются через build tool и автоматически загружаются из репозиториев (
например, Maven Central). В Gradle зависимости объявляются внутри блока dependencies { } с указанием таких атрибутов,
как group, name и version, что позволяет инструменту находить и загружать их из объявленных репозиториев.

**Пример:** `implementation("org.springframework:spring-core:6.0.0")`

**Источник:** https://docs.gradle.org/current/userguide/building_java_projects.html

**Источник:** https://maven.apache.org/guides/introduction/introduction-to-dependencies.html

---

#### Artifact

**Определение:** An artifact is a file, typically a JAR, that is produced by a build and stored in a repository.

**Контекст использования:** Артефакты публикуются в репозитории и используются другими проектами как зависимости.

**Пример:** После сборки создаётся build/libs/app.jar — это build artifact.

**Источник:** https://docs.gradle.org/current/userguide/building_java_projects.html

---

### Категория: Инструменты разработки

---

#### IDE — Integrated Development Environment

**Определение:** An integrated development environment (IDE) is a software application that provides comprehensive
facilities to programmers for software development.

**Контекст использования:** IDE объединяет редактор кода, компилятор, отладчик и инструменты навигации по проекту в
одном интерфейсе.

**Пример:** В IntelliJ IDEA можно писать код, запускать приложение и отлаживать его в одном окне.

**Источник:** https://www.jetbrains.com/help/idea/discover-intellij-idea.html

---

#### SDK — Software Development Kit

**Определение:** A software development kit (SDK) is a collection of software tools and libraries used to develop
applications for a specific platform.

**Контекст использования:** SDK включает компиляторы, библиотеки и утилиты, необходимые для разработки под конкретную
платформу.

**Пример:** JDK является SDK для разработки Java-приложений.

**Источник:** https://docs.oracle.com/iaas/Content/API/Concepts/sdks.ht

---

#### Git - Git

**Определение:** Git is a distributed version control system for tracking changes in source code during software
development.

**Контекст использования:** Git используется для управления версиями кода, совместной работы и отслеживания изменений.

**Пример:** Команда `git status` показывает текущие изменения в проекте.

**Источник:** https://git-scm.com/docs/git

---

#### Репозиторий - Repository

**Определение:** A repository is a data structure that stores metadata for a set of files or directory structure.

**Контекст использования:** Репозиторий хранит историю изменений проекта и все его версии.

**Пример:** `git clone <url>` копирует удалённый репозиторий на локальную машину.

**Источник:** https://git-scm.com/docs/gitglossary

---

#### Коммит - Commit

**Определение:** A commit is a snapshot of the repository at a specific point in time.

**Контекст использования:** Коммиты фиксируют изменения в проекте и формируют историю разработки.

**Пример:** `git commit -m "fix: correct validation logic"`

**Источник:** https://git-scm.com/docs/git-commit

---

#### Ветка - Branch

**Определение:** A branch is a parallel version of a repository.

**Контекст использования:** Ветки позволяют разрабатывать новые фичи независимо от основной версии кода.

**Пример:** `git checkout -b feature/login`

**Источник:** https://git-scm.com/docs/git-branch

---

#### Пулл реквест - Pull Request

**Определение:** A pull request is a method of submitting contributions to a repository.

**Контекст использования:** Pull request используется для обсуждения и проверки изменений перед их слиянием в основную
ветку.

**Пример:** Создание PR в GitHub для merge ветки `feature/login` в `main`.

**Источник:** https://docs.github.com/en/pull-requests

---

#### Проверка стиля - Checkstyle

**Определение:** Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard.

**Контекст использования:** Checkstyle проверяет код на соответствие стилю и правилам форматирования.

**Пример:** Проверка кода выполняется автоматически при сборке проекта через Gradle.

**Источник:** https://checkstyle.sourceforge.io/#Overview

---

#### Дебаг - Debug

**Определение:** Debugging is the process of identifying and removing errors from software.

**Контекст использования:** Отладка используется для поиска и исправления ошибок в программе во время выполнения.

**Пример:** Запуск приложения в режиме Debug в IDE позволяет пошагово выполнять код.

**Источник:** https://www.jetbrains.com/help/idea/debugging-code.html

---

#### Breakpoint - Breakpoint

**Определение:** A breakpoint is a marker used to pause program execution at a specified point.

**Контекст использования:** Breakpoint позволяет остановить выполнение программы для анализа состояния переменных.

**Пример:** Установка breakpoint в IDE и запуск Debug для остановки на нужной строке кода.

**Источник:** https://www.jetbrains.com/help/idea/using-breakpoints.html

---

### Категория: Процессы и практики

---

#### Code Review

**Определение:** Code review is the systematic examination of source code by developers to identify mistakes and improve
code quality.

**Контекст использования:** Code review используется перед слиянием изменений для повышения качества кода и соблюдения
стандартов команды.

**Пример:** Перед merge создаётся Pull Request, где другие разработчики оставляют комментарии и предлагают улучшения.

**Источник:
** https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/code-reviewing-changes-in-pull-requests

---

#### CI/CD — Continuous Integration / Continuous Delivery

**Определение:** Continuous Integration is a software development practice where developers integrate code into a shared
repository frequently, and Continuous Delivery automates the release of validated code to a repository.

**Контекст использования:** CI/CD автоматизирует сборку, тестирование и доставку приложения, снижая риск ошибок при
релизе.

**Пример:** При каждом push GitHub Actions запускает build и тесты проекта.

**Источник:** https://docs.github.com/en/actions/automating-builds-and-tests/about-continuous-integration

---

#### Runbook

**Определение:** A runbook is a set of documented procedures for performing routine operations and troubleshooting
tasks.

**Контекст использования:** Runbook используется для стандартизации операций и быстрого реагирования на инциденты.

**Пример:** Runbook описывает шаги перезапуска сервиса при падении и команды для проверки логов.

**Источник:** https://learn.microsoft.com/en-us/azure/architecture/framework/devops/automation/runbooks

---

## Вопросы по сложным терминам

### Шаблон вопроса

**Вопрос n:** [Название сложного термина]

**Задача:** [что нужно уточнить/понять про термин]

**Контекст:** [какие материалы изучили, где встретили термин]

**Ограничения:** [что уже попробовали]

**Ожидаемый результат:** [чёткое понимание термина и его применения]

**Критерии успеха:** [как проверить, что термин понят правильно]

---

### Вопрос 1: Artifact

**Задача:** Понять, что именно считается artifact в контексте Java/Gradle-проекта и чем он отличается от просто файлов
проекта.

**Контекст:** В заданиях требовались артефакты, но не до конца ясно, речь о JAR-файлах, результатах сборки или любых
выходных файлах.

**Ограничения:** Изучено определение из Gradle Docs, но остаётся неясность в практическом применении (что именно сдавать
как artifact).

**Ожидаемый результат:** Чёткое понимание, что artifact — это результат сборки (например, JAR), который можно
использовать, распространять или подключать как dependency.

**Критерии успеха:** Могу однозначно определить artifact в проекте (например, build/libs/app.jar) и объяснить, почему
именно он является артефактом, а исходный код — нет.

---

### Вопрос 2: Technical Architecture

**Задача:** Понять, что включает в себя technical architecture и чем она отличается от общей архитектуры системы (system
architecture).

**Контекст:** Термин встречается в документации (например, Oracle Docs) и описывает структуру приложений и их
компонентов на уровне технологий и реализации.

**Ограничения:** Изучены определения и описания, но остаётся неясность в границах термина (что именно входит: только
технологии или также взаимодействие компонентов).

**Ожидаемый результат:** Чёткое понимание, что technical architecture описывает структуру системы с точки зрения
технологий, компонентов, их взаимодействия и инфраструктуры.

**Критерии успеха:** Могу объяснить technical architecture на примере проекта (например: backend на Java, сборка через
Gradle, взаимодействие через REST API) и отличить её от бизнес-архитектуры.

---

## Дополнительные материалы