package com.ahutsul;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQaSliderTest extends DemoQaBaseTest {
    public static final String WIDGETS = "widgets";

    @Test
    public void testSlider() {
        webDriver.get(BASE_URL + WIDGETS);
        findWebElement(By.xpath("//span[text()='Slider']")).click();

        WebElement slider = findWebElement(By.xpath("//span[@class='range-slider__wrap']/input[@type='range']"));
        int oldInputValue = getCurrentInputValue();
        for (int i = 0; i < 3; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
            Assert.assertTrue(getCurrentInputValue() > oldInputValue);
            oldInputValue = getCurrentInputValue();
        }
    }

    private int getCurrentInputValue() {
        return Integer.parseInt(findWebElement(By.id("sliderValue")).getAttribute("value"));
    }
}
