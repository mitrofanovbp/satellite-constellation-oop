# Satellite Management (ООП)

Проект демонстрирует принципы ООП (абстракция, наследование, инкапсуляция, полиморфизм, агрегация) на примере управления спутниковой группировкой.

## Структура
- `Satellite` — абстрактный базовый класс
- `CommunicationSatellite` — спутник связи
- `ImagingSatellite` — спутник ДЗЗ
- `SatelliteConstellation` — группировка спутников
- `Main` — демонстрационный запуск и вывод в консоль

## Запуск без сборщика (JDK 17+)

```bash
javac -encoding UTF-8 -d out $(find src/main/java -name "*.java")
java -Dfile.encoding=UTF-8 -cp out space.satellites.Main
```

