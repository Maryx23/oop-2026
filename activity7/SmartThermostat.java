public class SmartThermostat extends SmartDevice {
    private double temperature;

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 20.0;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature: " + temperature + "°C");
    }

    public void setTemperature(double temp) {
        if (temp > 30.0) {
            System.out.println("Warning: Setting temperature above 30°C may overheat!");
        }
        this.temperature = temp;
    }
}