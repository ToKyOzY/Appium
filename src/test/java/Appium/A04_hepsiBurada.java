package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class A04_hepsiBurada {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        Thread.sleep(3000);

        Actions actions= new Actions(driver);
        MobileElement searchBox=driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox");
        searchBox.click();
        MobileElement kategoriler=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Kategorilerim\"]/android.widget.FrameLayout/android.widget.ImageView");
        kategoriler.click();
        searchBox.sendKeys("nutella");
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).build().perform();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").index(0)").click();



      //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Devam\")").click();

      //  TouchAction touchAction = new TouchAction(driver);
      //  touchAction.press(PointOption.point(734, 1006)).
      //          waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))).
      //          moveTo(PointOption.point(734, 1006)).release().perform();


       // Thread.sleep(3000);



        //MobileElement premium=driver.findElementById("//android.widget.ImageView[@content-desc=\"Premium'a geç\"]");

       // MobileElement searchBox=driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox");
        Thread.sleep(3000);





    }
}
