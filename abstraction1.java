// Abstract class
abstract class TV {

    abstract void turnOn();
    abstract void turnOff();
}

// Existing implementation
class TVRemote extends TV {

    @Override
    void turnOn() {
        System.out.println("TV is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}

// New Smart TV implementation
class SmartTVRemote extends TV {

    @Override
    void turnOn() {
        System.out.println("Smart TV is turned ON.");
        connectToWiFi();
        openHomeScreen();
    }

    @Override
    void turnOff() {
        System.out.println("Smart TV is turned OFF.");
        disconnectWiFi();
    }

    private void connectToWiFi() {
        System.out.println("Connecting to WiFi...");
    }

    private void disconnectWiFi() {
        System.out.println("Disconnecting WiFi...");
    }

    private void openHomeScreen() {
        System.out.println("Opening Smart TV Home Screen.");
    }
}

// Main class demonstrating polymorphism
public class abstraction1 {

    public static void main(String[] args) {

        TV remote;

        remote = new TVRemote();
        remote.turnOn();
        remote.turnOff();

        System.out.println();

        remote = new SmartTVRemote();
        remote.turnOn();
        remote.turnOff();
    }
}
