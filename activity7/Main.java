public class Main {
    public static void main(String[] args) {
        SmartLight livingRoomLight = new SmartLight("Living Room Light");
        livingRoomLight.setBrightness(80);
        livingRoomLight.togglePower();
        livingRoomLight.setBrightness(80);
        livingRoomLight.displayStatus();
        
        System.out.println();
        
        SmartThermostat thermostat = new SmartThermostat("Living Room Thermostat");
        thermostat.togglePower();
        thermostat.setTemperature(32.0);
        thermostat.displayStatus();
    }
}