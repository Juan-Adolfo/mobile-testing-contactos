package device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Android implements IDevice{
    @Override
    public AndroidDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "Android11");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:appPackage", "com.google.android.contacts");
        capabilities.setCapability("appium:appActivity", "com.android.contacts.activities.PeopleActivity");
        // Contacts pide permisos al abrir; Appium los concede para que no aparezca el dialogo
        capabilities.setCapability("appium:autoGrantPermissions", true);
        // Sin esto Appium hace "pm clear" de Contacts al iniciar, tarda mas de 20 s y la sesion falla por timeout
        capabilities.setCapability("appium:noReset", true);
        // Con noReset la app quedaria en la pantalla del ultimo contacto; esto la reinicia en la lista
        capabilities.setCapability("appium:forceAppLaunch", true);
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        return driver;
    }
}
