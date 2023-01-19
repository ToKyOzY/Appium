package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium03 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
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
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App install successfully");
        Thread.sleep(3000);
        //validate that user is on Home screen
        MobileElement homeScreenTitle=driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Home Screen");

        //tap on Add Gesture button
        MobileElement addGesture=driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addGesture.click();
        Thread.sleep(3000);
        //user shoul be on Create gesture screen
        MobileElement createGestureScreenTitle=driver.findElementById("android:id/title");
        Assert.assertTrue(createGestureScreenTitle.isDisplayed());
        Thread.sleep(3000);
        //user send text to the text box as "TechproEd"
        MobileElement nameBox=driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        nameBox.sendKeys("TechproEd03");
        //if you nneed to hide keyboard use below method
        driver.hideKeyboard();

        //tap on screen t make Done button enabled
        MobileElement blackScreen=driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay");
        blackScreen.click();

        //user tap on Done button
        MobileElement doneButton=driver.findElementById("com.davemac327.gesture.tool:id/done");
        doneButton.click();

        Thread.sleep(3000);
        //validate that user is on Home screen
        MobileElement homeScreenTitle1=driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle1.isDisplayed());
        System.out.println("Home Screen");

        //validate that gesture name which you create as "TechproEd"
        List<MobileElement> listOfGestureName=driver.findElementsByXPath("//android.widget.TextView");
        System.out.println(listOfGestureName.size()+"=====> size");

        for (MobileElement name:listOfGestureName) {
            System.out.println(name.getText());
            if (name.getText().equals("TechproEd03")){
                Assert.assertTrue(name.isDisplayed());
                System.out.println("Gesture name created as : "+name.getText());
            }
        }



    }
}
