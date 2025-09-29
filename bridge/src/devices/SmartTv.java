package devices;

public class SmartTv extends Tv {
    private String currentApp = null;

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a Smart TV set.");
        System.out.println("| I'm " + (isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + getVolume() + "%");
        System.out.println("| Current channel is " + getChannel());
        if (currentApp != null) {
            System.out.println("| Current app running: " + currentApp);
        } else {
            System.out.println("| No app is currently running.");
        }
        System.out.println("------------------------------------\n");
    }

    public void startApp(String appName) {
        if (isEnabled()) {
            System.out.println("Starting app: " + appName);
            currentApp = appName;
        } else {
            System.out.println("Cannot start app. The TV is off.");
        }
    }

    public void stopApp(String appName) {
        if (isEnabled()) {
            System.out.println("Stopping app: " + appName);
            currentApp = null;
        } else {
            System.out.println("Cannot stop app. The TV is off.");
        }
    }

    public void pauseApp(String appName) {
        if (isEnabled()) {
            System.out.println("Pausing app: " + appName);
        } else {
            System.out.println("Cannot pause app. The TV is off.");
        }
    }

    public void resumeApp(String appName) {
        if (isEnabled()) {
            System.out.println("Resuming app: " + appName);
        } else {
            System.out.println("Cannot resume app. The TV is off.");
        }
    }
}