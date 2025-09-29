package remotes;

import devices.Device;
import devices.SmartTv;

public class SmartRemote extends BasicRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void openApp(String appName) {
        System.out.println("Remote: opening app " + appName);
        if (device instanceof SmartTv tv) {
            tv.startApp(appName);
        } else {
            System.out.println("This device does not support apps.");
        }
    }

    public void closeApp(String appName) {
        System.out.println("Remote: closing app " + appName);
        if (device instanceof SmartTv tv) {
            tv.stopApp(appName);
        } else {
            System.out.println("This device does not support apps.");
        }
    }

    public void pauseApp(String appName) {
        System.out.println("Remote: pausing app " + appName);
        if (device instanceof SmartTv tv) {
            tv.pauseApp(appName);
        } else {
            System.out.println("This device does not support apps.");
        }
    }

    public void resumeApp(String appName) {
        System.out.println("Remote: resuming app " + appName);
        if (device instanceof SmartTv tv) {
            tv.resumeApp(appName);
        } else {
            System.out.println("This device does not support apps.");
        }
    }
}
