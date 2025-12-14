package space.satellites;

/**
 * Абстрактный базовый класс спутника.
 * Демонстрирует инкапсуляцию, абстракцию и наследование.
 */
public abstract class Satellite {

    protected String name;
    protected boolean isActive;
    protected double batteryLevel;

    protected Satellite(String name, double batteryLevel) {
        this.name = name;
        this.batteryLevel = batteryLevel;
        this.isActive = false;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Включение спутника.
     * Спутник включается, если заряд больше 0.2.
     */
    public boolean activate() {
        if (batteryLevel > 0.2) {
            isActive = true;
            return true;
        }
        isActive = false;
        return false;
    }

    /**
     * Выключение спутника (только если он был включен).
     */
    public void deactivate() {
        if (isActive) {
            isActive = false;
        }
    }

    /**
     * Расход энергии.
     * Если заряд уходит в критически малую зону, спутник выключается.
     */
    public void consumeBattery(double amount) {
        if (amount < 0) {
            return;
        }
        batteryLevel -= amount;
        if (batteryLevel < 0) {
            batteryLevel = 0;
        }
        // Критический порог
        if (batteryLevel <= 0.10) {
            deactivate();
        }
    }

    /**
     * Выполнение миссии. Метод защищённый: вызывается только наследниками или классами из пакета.
     */
    protected abstract void performMission();
}
