package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import com.example.jetbrainstest.tests.DatabaoTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// page_url = https://www.jetbrains.com/databao/
public class DatabaoPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DatabaoPage.class));
   // private final Logger LOG = LoggerFactory.getLogger(DatabaoPage.class);
    WebDriver driver;

    @FindBy(css = "a[data-test='button'][href='/databao/get-in-touch/']")
    private WebElement bookademoButton;

    public Boolean checkIfBookaademoButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return bookademoButton.isEnabled();
    }

    public DatabaoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css ="form[data-test='wtform']")
    private WebElement demoRequestForm;

    public Boolean checkIfDemoRequestFormIsDisplayed () {
        LOG.info("Проверка видимости формы бронирования презентации продукта");
        return demoRequestForm.isDisplayed();
    }

    public void clickBookADemoButton() {
        LOG.info("Клик по кнопке бронирования презентации");
        bookademoButton.click();
    }
}
