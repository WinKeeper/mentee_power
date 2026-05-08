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

**Правило обратного доменного имени** — это стандарт именования пакетов в Java, при котором имя пакета строится из доменного имени компании/владельца, записанного в обратном порядке.

1. Глобальная уникальность
Проблема: В мире тысячи компаний, и каждая может создать класс User, Progress или Main.
Решение: Доменные имена УНИКАЛЬНЫ. Если перевернуть домен mentee.ru → ru.mentee — такой пакет больше никто не использует.
2. Единый стандарт
Все Java-разработчики мира используют это правило. Если вы видите пакет com.google. — сразу понятно, что код от Google. org.apache. — от Apache. 
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

В Dev Tools оставляем master чистым, работу ведём в ветке feature/DVT-<номер> - это упрощает проверку и дальнейший PR. Подход соответствует lightweight Git Flow.