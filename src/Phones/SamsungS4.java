package Phones;

public class SamsungS4 extends Phone {
    public SamsungS4() {
        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("SamsungS4 is sending: Hello!" + message + " to " + number);
        numSMS++;
    }
}
