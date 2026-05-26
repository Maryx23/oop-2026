public class SmartDevice {
    protected String deviceName;
    protected boolean isOn;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false;
    }

    public void togglePower() {
        isOn = !isOn;
    }

    public void displayStatus() {
        System.out.println("Device: " + deviceName + " | Power: " + (isOn ? "on" : "ogg"));
    }
}