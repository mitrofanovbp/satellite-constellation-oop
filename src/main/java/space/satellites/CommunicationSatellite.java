package space.satellites;

/**
 * Спутник связи.
 */
public class CommunicationSatellite extends Satellite {

    private final double bandwidth;

    public CommunicationSatellite(String name, double batteryLevel, double bandwidth) {
        super(name, batteryLevel);
        this.bandwidth = bandwidth;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    /**
     * Отправка данных, если спутник активен.
     */
    public void sendData(double dataAmountMbit) {
        if (!isActive) {
            System.out.println("🛑 " + name + ": Не может отправить данные - не активен");
            return;
        }
        System.out.println(name + ": Отправил " + dataAmountMbit + " Мбит данных!");
    }

    @Override
    protected void performMission() {
        if (!isActive) {
            System.out.println("🛑 " + name + ": Не может передать данные - не активен");
            return;
        }
        System.out.println(name + ": Передача данных со скоростью " + bandwidth + " Мбит/с");
        sendData(bandwidth);
        consumeBattery(0.05);
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{" +
                "bandwidth=" + bandwidth +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
