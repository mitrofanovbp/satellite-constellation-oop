package space.satellites;

/**
 * Спутник дистанционного зондирования Земли (ДЗЗ).
 */
public class ImagingSatellite extends Satellite {

    private final double resolution;
    private int photosTaken;

    public ImagingSatellite(String name, double batteryLevel, double resolution) {
        super(name, batteryLevel);
        this.resolution = resolution;
        this.photosTaken = 0;
    }

    public double getResolution() {
        return resolution;
    }

    public int getPhotosTaken() {
        return photosTaken;
    }

    /**
     * Делает фото, если спутник активен.
     */
    public void takePhoto() {
        if (!isActive) {
            System.out.println("🛑 " + name + ": Не может выполнить съемку - не активен");
            return;
        }
        photosTaken++;
        System.out.println(name + ": Снимок #" + photosTaken + " сделан!");
    }

    @Override
    protected void performMission() {
        if (!isActive) {
            System.out.println("🛑 " + name + ": Не может выполнить съемку - не активен");
            return;
        }
        System.out.println(name + ": Съемка территории с разрешением " + resolution + " м/пиксель");
        takePhoto();
        consumeBattery(0.08);
    }

    @Override
    public String toString() {
        return "ImagingSatellite{" +
                "resolution=" + resolution +
                ", photosTaken=" + photosTaken +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
