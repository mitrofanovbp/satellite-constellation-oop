package space.satellites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Спутниковая группировка. Демонстрирует агрегацию и полиморфизм.
 */
public class SatelliteConstellation {

    private final String constellationName;
    private final List<Satellite> satellites;

    public SatelliteConstellation(String constellationName) {
        this.constellationName = constellationName;
        this.satellites = new ArrayList<>();
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void addSatellite(Satellite satellite) {
        if (satellite == null) {
            return;
        }
        satellites.add(satellite);
        System.out.println(satellite.getName() + " добавлен в группировку '" + constellationName + "'");
    }

    public void executeAllMissions() {
        for (Satellite satellite : satellites) {
            satellite.performMission();
        }
    }

    public List<Satellite> getSatellites() {
        return Collections.unmodifiableList(satellites);
    }
}
