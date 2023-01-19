package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04Calculator {
    @Test
    public void calculatortest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"6000");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Appium_Project\\src\\Apps\\Calculator.apk");
        //capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        //capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(3000);
        System.out.println("App install successfully...");

        MobileElement num1=driver.findElementById("digit_1");
        MobileElement num2=driver.findElementById("digit_2");
        MobileElement num3=driver.findElementById("digit_3");
        MobileElement num4=driver.findElementById("digit_4");
        MobileElement num5=driver.findElementById("digit_5");
        MobileElement num6=driver.findElementById("digit_6");
        MobileElement num7=driver.findElementById("digit_7");
        MobileElement num8=driver.findElementById("digit_8");
        MobileElement num9=driver.findElementById("digit_9");
        MobileElement num0=driver.findElementById("digit_0");







    }
}
