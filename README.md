# Devtools

[![CI](https://github.com/WinKeeper/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/WinKeeper/devtools/actions)

# DVT-2 — Gradle-проект и базовый main

https://mentee-power.xl.ru/learn/MCIneBj4KkyH-GIRCspFvA/theory

## 🚀 Quick Start Gradle: запуск задачи run, build, test через Gradle Tool Window и Run Anything (Ctrl + Ctrl)

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

## 📦 Packages: Зачем нужен пакет `ru.mentee.power`

**Пакет (package)** — это пространство имён, которое организует классы в иерархию и предотвращает конфликты имён.

- Группирует логически связанные классы
- Предотвращает конфликты имён
- Управляет доступом (модификатор package-private)

Таблица переменных/полей: menteeName, sprintNumber, plannedHoursPerWeek, правило readyForSprint().

## Правило обратного доменного имени (Reverse Domain Name Convention)

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

## MenteeProgress таблица полей

| Имя поля              | Тип данных | Описание                                          |
|-----------------------|------------|---------------------------------------------------|
| `menteeName`          | String     | Имя стажёра (Mentee)                              |
| `sprintNumber`        | int        | Номер спринта                                     |
| `plannedHoursPerWeek` | int        | Планируемое количество часов в неделю для спринта |

# DVT-3 — Git Essentials: локальный цикл

## Правило веток: feature/DVT-X

В Dev Tools оставляем master чистым, работу ведём в ветке feature/DVT-<номер> - это упрощает проверку и дальнейший PR.
Подход соответствует lightweight Git Flow.

# DVT-4 — GitHub и первый Pull Request

# DVT-5 — Чистый Git‑репозиторий

<pre>Перед push: git status clean</pre>

- После добавления новых инструментов — обновляйте .gitignore и делайте санитарный коммит при необходимости.
- Если случайно удалили файлы без --cached, восстановитесь из локальной истории/изменений IDE.
- Перед push проверяйте «status clean» в IDE и CLI; при расхождениях — ищите источник (новые артефакты/настройки).

# DVT-6: Один цикл и контроль прогресса — освоение Debug

## Сценарий ручной проверки DVT-6

### Запуск приложения

1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов

1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug

1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках

- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

# DVT-7: Checkstyle и культура кода — автоматизация стандартов

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used
