package Phones;

public abstract class Phone {
    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    protected int numCalls;
    protected int numSMS;

    public Phone() {
        System.out.println("Phone constructor");
        numCalls = 0;
        numSMS = 0;
    }

    public boolean isTouch() {
        return touch;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getNumCalls() {
        return numCalls;
    }

    public int getNumSMS() {
        return numSMS;
    }

    public void call(String number) {
        System.out.println("Phone class is calling " + number);
        numCalls++;
    }

    public abstract void sendSMS(String number, String message);
}
