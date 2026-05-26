public class SmartLight extends SmartDevice {
    private int brightness;

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Brightness: " + brightness + "%");
    }

    public void setBrightness(int level) {
        if (isOn) {
            if (level >= 0 && level <= 100) {
                brightness = level;
            } else {
                System.out.println("Brightness must be between 0 and 100.");
            }
        } else {
            System.out.println(deviceName + " is off. Cannot set brightness.");
        }
    }
}