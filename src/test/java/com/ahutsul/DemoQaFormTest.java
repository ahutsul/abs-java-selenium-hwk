package com.ahutsul;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQaFormTest extends DemoQaBaseTest {
    public static final String FORMS = "forms";

    @Test
    public void testPracticeForm() throws InterruptedException {
        webDriver.get(BASE_URL + FORMS);
        findWebElement(By.xpath("//span[text()='Practice Form']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");

        webDriver.manage().window().setSize(new Dimension(500, 600));

        findWebElement(By.id("firstName")).sendKeys("Ivan");
        findWebElement(By.id("lastName")).sendKeys("Ivanov");
        findWebElement(By.id("userEmail")).sendKeys("i_ivanov@gmail.com");
        findWebElement(By.xpath("//label[text()='Male']")).click();
        findWebElement(By.id("userNumber")).sendKeys("2340938402");

        findWebElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
        Select monthSelect = new Select(findWebElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByVisibleText("April");
        Select yearSelect = new Select(findWebElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByVisibleText("1991");
        findWebElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--012']")).click();

        // Choose 'Reading' hobby
        findWebElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        // Enter current address
        findWebElement(By.id("currentAddress")).sendKeys("Shevchenka 38, apt 20");
        // Choose 'Uttar Pradesh' state
        findWebElement(By.xpath("//div[text()='Select State']")).click();
        findWebElement(By.xpath("//div[text()='Uttar Pradesh']")).click();
        // Choose 'Merrut' city
        findWebElement(By.xpath("//div[text()='Select City']")).click();
        findWebElement(By.xpath("//div[text()='Merrut']")).click();

        findWebElement(By.id("submit")).click();
        Thread.sleep(15);
        Assert.assertEquals(webDriver.findElement(By.id("example-modal-sizes-title-lg")).getText(), "Thanks for submitting the form");
    }
}
