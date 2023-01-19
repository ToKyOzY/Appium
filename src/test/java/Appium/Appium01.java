package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");  ==> bu sekillerde de yaziliyor.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Appium_Project\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");

        //eger aplikasyonu izinler atLayarak anasayfada acilmasini istiyorsak asagidaki komutu kullaniriz
        //capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("app yuklendi");
        Thread.sleep(3000);
        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
        Thread.sleep(3000);
        MobileElement okButton=driver.findElementById("android:id/button1");
        okButton.click();
        System.out.println("izinler onaylandi");

        MobileElement homeScreenTitle=driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        Assert.assertEquals(homeScreenTitle.getText(), "Gesture Tool"); //or
        System.out.println("ana sayfa acildi");

        driver.closeApp();

        //asagidaki kod tel kilitli ise acmamizi sagliyor
        if(driver.isDeviceLocked()){
            driver.unlockDevice();
        }



        /*
         driver.findElementByXPath("\t\n" +
                 "//android.widget.TextView[@content-desc=\"Gesture Tool\"]").click();//gestuleanasayafa



         */
    }
}