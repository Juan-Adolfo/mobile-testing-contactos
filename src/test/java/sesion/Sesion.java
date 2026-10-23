package sesion;

import device.FactoryDevice;
import io.appium.java_client.AppiumDriver;

public class Sesion {

    private static Sesion sesion = null;
    private AppiumDriver device;

    private Sesion(){
        device = FactoryDevice.make("android").create();
    }

    public static Sesion getSesion(){
        if(sesion == null){
            sesion = new Sesion();
        }
        return sesion;
    }

    public AppiumDriver getDevice(){
        return device;
    }

    public void closeSesion(){
        device.quit();
        sesion=null;
    }

}
