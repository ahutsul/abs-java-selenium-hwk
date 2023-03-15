package com.ahutsul;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DemoQaBrowserWindowsTest extends DemoQaBaseTest {
    public static final String ALERTS_WINDOWS = "alertsWindows";

    @Test
    public void testBrowserWindows() {
        webDriver.get(BASE_URL + ALERTS_WINDOWS);
        findWebElement(By.xpath("//span[text()='Browser Windows']")).click();

        findWebElement(By.id("tabButton")).click();
        ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        Assert.assertEquals(findWebElement(By.id("sampleHeading")).getText(), "This is a sample page");
        webDriver.close();

        webDriver.switchTo().window(tabs.get(0));
    }
}
