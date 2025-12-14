package space.satellites;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("============================================================");

        System.out.println("СОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:");
        System.out.println("---------------------------------------------");

        CommunicationSatellite comm1 = new CommunicationSatellite("Связь-1", 0.85, 500.0);
        CommunicationSatellite comm2 = new CommunicationSatellite("Связь-2", 0.75, 1000.0);
        ImagingSatellite img1 = new ImagingSatellite("ДЗЗ-1", 0.92, 2.5);
        ImagingSatellite img2 = new ImagingSatellite("ДЗЗ-2", 0.45, 1.0);
        ImagingSatellite img3 = new ImagingSatellite("ДЗЗ-3", 0.15, 0.5);

        printCreated(comm1);
        printCreated(comm2);
        printCreated(img1);
        printCreated(img2);
        printCreated(img3);

        System.out.println("---------------------------------------------");

        SatelliteConstellation constellation = new SatelliteConstellation("RU Basic");
        System.out.println("Создана спутниковая группировка: " + constellation.getConstellationName());
        System.out.println("---------------------------------------------");

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВКИ:");
        System.out.println("-----------------------------------");
        constellation.addSatellite(comm1);
        constellation.addSatellite(comm2);
        constellation.addSatellite(img1);
        constellation.addSatellite(img2);
        constellation.addSatellite(img3);
        System.out.println("-----------------------------------");
        System.out.println(constellation.getSatellites());
        System.out.println("-----------------------------------");

        System.out.println("АКТИВАЦИЯ СПУТНИКОВ:");
        System.out.println("-------------------------");
        activateAll(constellation.getSatellites());

        System.out.println("ВЫПОЛНЕНИЕ МИССИЙ ГРУППИРОВКИ " + constellation.getConstellationName().toUpperCase());
        System.out.println("==================================================");
        constellation.executeAllMissions();

        System.out.println(constellation.getSatellites());
    }

    private static void printCreated(Satellite satellite) {
        int percent = (int) Math.round(satellite.getBatteryLevel() * 100);
        System.out.println("Создан спутник: " + satellite.getName() + " (заряд: " + percent + "%)");
    }

    private static void activateAll(List<Satellite> satellites) {
        for (Satellite s : satellites) {
            boolean ok = s.activate();
            if (ok) {
                System.out.println("✅ " + s.getName() + ": Активация успешна");
            } else {
                int percent = (int) Math.round(s.getBatteryLevel() * 100);
                System.out.println("🛑 " + s.getName() + ": Ошибка активации (заряд: " + percent + "%)");
            }
        }
    }
}
