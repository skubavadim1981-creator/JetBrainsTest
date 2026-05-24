package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.DatabaoPage;
import com.example.jetbrainstest.pages.DatabaoGetInTouchPage;
import com.example.jetbrainstest.pages.DatabaoBlogPage;
import com.example.jetbrainstest.pages.FleetPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MyExtension.class)
public class DatabaoTest extends BaseTest {

    private DatabaoPage DatabaoPage;
    private DatabaoGetInTouchPage DatabaoGetInTouchPage;
    private DatabaoBlogPage DatabaoBlogPage;

    @BeforeEach
    @Override
    @Step("Переход в раздел Idea")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/databao/");
        DatabaoPage = new DatabaoPage(getDriver());
        DatabaoGetInTouchPage = new DatabaoGetInTouchPage(getDriver());
        DatabaoBlogPage = new DatabaoBlogPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка бронирования презентации активна")
    public void buttonCheck() {
        assertTrue(DatabaoPage.checkIfBookaademoButtonIsClickable(), "Кнопка бронирования не активна");
    }

    @Test
    @DisplayName("Проверка, что форма бронирования презентации видима")
    public void checkIfDistributedButtonIsClickable(){
        DatabaoPage.clickBookADemoButton();

        assertTrue(DatabaoGetInTouchPage.checkIfDemoRequestFormIsDisplayed(), "Форма бронирования не видима");
    }

    @Test
    @DisplayName("Проверка открытия страницы бронирования")
    public void checkOpenGetInTouchPage(){
        DatabaoPage.clickBookADemoButton();

        assertEquals("https://www.jetbrains.com/databao/get-in-touch/",
                getDriver().getCurrentUrl(), "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка, что ссылка с достижениями активна")
    public void checkRankLink(){
        assertTrue(DatabaoPage.checkIfRankLinkIsClickable(), "Ссылка достижений не активна");
    }

    @Test
    @DisplayName("Проверка открытия страницы статьи достижений")
    public void checkOpenIdentificationEStore() {
        DatabaoPage.clickRankLink();

        assertTrue(DatabaoBlogPage.checkIfRankHeadingIsVisible(), "Заголовок статьи не отображается");
    }

    @Test
    @DisplayName("Проверка заголовка блога достижений")
    public void checkTitleRankBlog() {
        DatabaoPage.clickRankLink();

        String expectedTitle = "#1 on Spider 2.0–DBT Benchmark – How Databao Agent Did It";
        assertEquals(expectedTitle, DatabaoBlogPage.getRankHeadingText(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка ошибки поля email при пустой форме")
    public void shouldShowValidationErrorWhenEmailIsEmpty() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.clickFirstNameField();

        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под input не отображается");
        assertEquals("This field is required", DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("Проверка ошибки поля email при вводе только букв")
    public void shouldShowValidationErrorWhenEmailContainsOnlyLetters() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.enterEmail("aaaa");
        DatabaoGetInTouchPage.clickFirstNameField();

        assertEquals("aaaa", DatabaoGetInTouchPage.getEmailValue(), "Email введён некорректно");
        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под input не отображается");
        assertEquals("E-mail address is not correct", DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("Проверка ошибки поля email при вводе только цифр")
    public void shouldShowValidationErrorWhenEmailContainsOnlyDigits() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.enterEmail("111");
        DatabaoGetInTouchPage.clickFirstNameField();

        assertEquals("111", DatabaoGetInTouchPage.getEmailValue(), "Email введён некорректно");
        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под input не отображается");
        assertEquals("E-mail address is not correct", DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("Проверка ошибки поля email при вводе почты без симовла '@'")
    public void shouldShowValidationErrorWhenEmailContainsNoAtSymbol() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.enterEmail("yournameyourcompany.com");
        DatabaoGetInTouchPage.clickFirstNameField();

        assertEquals("yournameyourcompany.com", DatabaoGetInTouchPage.getEmailValue(), "Email введён некорректно");
        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под input не отображается");
        assertEquals("E-mail address is not correct", DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("Проверка ошибки поля email при вводе почты без симовла '@'")
    public void shouldShowValidationErrorWhenEmailIsNotBusiness() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.enterEmail("test123@gmail.com");
        DatabaoGetInTouchPage.clickFirstNameField();

        assertEquals("test123@gmail.com", DatabaoGetInTouchPage.getEmailValue(), "Email введён некорректно");
        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под input не отображается");
        assertEquals("Please use a business email address.", DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("Проверка ошибки поля email при вводе латиницы")
    public void shouldShowValidationErrorWhenEmailContainsSpaces() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.enterEmail("компания@твоякомпания.ру");
        DatabaoGetInTouchPage.clickFirstNameField();

        assertEquals("компания@твоякомпания.ру", DatabaoGetInTouchPage.getEmailValue(), "Email введён некорректно");
        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под input не отображается");
        assertEquals("E-mail address is not correct", DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("При вводе валидного email ошибка не отображается")
    public void shouldNotShowValidationErrorForValidEmail() {

        DatabaoPage.clickBookADemoButton();

        DatabaoGetInTouchPage.clickEmailField();
        DatabaoGetInTouchPage.enterEmail("yourname@yourcompany.com");
        DatabaoGetInTouchPage.clickFirstNameField();

        assertEquals("yourname@yourcompany.com",DatabaoGetInTouchPage.getEmailValue(), "Email введён некорректно");
        assertFalse(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка отображается для валидного email");
    }

    @Test
    @DisplayName("При отправке пустой формы отображается ошибка под полем email")
    public void shouldShowValidationErrorWhenSubmitWithEmptyEmail() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickSubmitButton();

        assertTrue(DatabaoGetInTouchPage.checkIfInputErrorIsDisplayed(), "Ошибка под полем email не отображается");
        assertEquals("This field is required",DatabaoGetInTouchPage.getErrorText(), "Неверный текст ошибки");
    }

    @Test
    @DisplayName("Проверка заголовка формы бронирования")
    public void checkTitleGetInTouchForm() {
        DatabaoPage.clickBookADemoButton();

        String expectedTitle = "Book a product demo";
        assertEquals(expectedTitle, DatabaoGetInTouchPage.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка, что кнопка подтверждения в форме бронирования активна")
    public void submitButtonCheck() {
        DatabaoPage.clickBookADemoButton();

        assertTrue(DatabaoGetInTouchPage.checkIfSubmitButtonIsClickable(), "Кнопка подтверждения не активна");
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Get in touch'")
    public void getintouchPageTest(){
        DatabaoPage.clickBookADemoButton();

        assertEquals("https://www.jetbrains.com/databao/get-in-touch/", getDriver().getCurrentUrl(), "Не перешел на страницу get in touch");
    }

    @Test
    @DisplayName("Проверка страны по умолчанию в форме 'Book a demo'")
    public void checkDefaultCountryIsPoland() {
        DatabaoPage.clickBookADemoButton();

        String expected = "Poland";
        assertEquals(expected, DatabaoGetInTouchPage.getSelectedCountry(), "По умолчанию страна должна быть Poland");
    }

    @Test
    @DisplayName("Проверка появления плашки с подсказкой при клике на тултип")
    public void checkTooltipAppears() {
        DatabaoPage.clickBookADemoButton();
        DatabaoGetInTouchPage.clickTooltipIcon();

        assertTrue(DatabaoGetInTouchPage.isTooltipDisplayed(), "Тултип не появился после клика");
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Jetbrains for data'")
    public void jetbrainsForDataPageTest(){
        DatabaoPage.clickJetbrainsForDataTag();

        assertEquals("https://www.jetbrains.com/jetbrains-for-data/", getDriver().getCurrentUrl(), "Не перешел на страницу 'Jetbrains for data'");
    }
}
