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
public class DatabaoGetInTouchPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DatabaoGetInTouchPage.class));
    // private final Logger LOG = LoggerFactory.getLogger(DatabaoPage.class);
    WebDriver driver;

    public DatabaoGetInTouchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css ="form[data-test='wtform']")
    private WebElement demoRequestForm;
    @FindBy (css ="[data-test='input__inner'][name='email']")
    private WebElement emailField;
    @FindBy (css ="[data-test='input__inner'][name='firstName']")
    private WebElement firstNameField;
    @FindBy (css ="[data-test='input__error-message']")
    private WebElement inputError;
    @FindBy(css = "[data-test='submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//h2[contains(text(),'Book a product demo')]")
    private WebElement bookProductDemoTitle;
    @FindBy(xpath = "//div[@data-test='select'][.//div[text()='Poland']]")
    private WebElement countrySelectValue;
    @FindBy(css = "svg._trigger_15dc224_113")
    private WebElement tooltipIcon;
    @FindBy(css = "div._content_15dc224_13")
    private WebElement tooltip;

    public Boolean checkIfDemoRequestFormIsDisplayed () {
        LOG.infoWithScreenshot("Проверка видимости формы бронирования презентации продукта");
        return demoRequestForm.isDisplayed();
    }
    public void clickEmailField() {
        LOG.infoWithScreenshot("Клик по полю 'email'");
        emailField.click();
    }
    public void clickFirstNameField() {
        LOG.infoWithScreenshot("Клик по полю 'Имя'");
        firstNameField.click();
    }
    public Boolean checkIfInputErrorIsDisplayed() {
        LOG.infoWithScreenshot("Проверка видимости ошибки под полем email");

        try {
            return inputError.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public String getErrorText() {
        return inputError.getText().trim();
    }
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public String getEmailValue() {
        return emailField.getAttribute("value");
    }
    public void clickSubmitButton() {
        LOG.infoWithScreenshot("Клик по кнопке Submit");
        submitButton.click();
    }
    public String checkTitlePage() {
        LOG.info("Проверка текста заголовка");
        String actualTitle = bookProductDemoTitle.getText();
        LOG.info("Получен текст заголовка страницы: \"" + actualTitle + "\"");
        return actualTitle;
    }
    public Boolean checkIfSubmitButtonIsClickable() {
        LOG.infoWithScreenshot("Проверка активности кнопки подтверждения");
        return submitButton.isEnabled();
    }
    public String getSelectedCountry() {
        return countrySelectValue.getText().trim();
    }
    public void clickTooltipIcon() {
        tooltipIcon.click();
    }
    public Boolean isTooltipDisplayed() {
        return tooltip.isDisplayed();
    }
}
