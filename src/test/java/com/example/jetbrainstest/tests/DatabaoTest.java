package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.DatabaoPage;
import com.example.jetbrainstest.pages.FleetPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaoTest extends BaseTest {

    private DatabaoPage DatabaoPage;

    @BeforeEach
    @Override
    @Step("Переход в раздел idea")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/databao/");
        DatabaoPage = new DatabaoPage(getDriver());
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
        assertTrue(DatabaoPage.checkIfDemoRequestFormIsDisplayed(), "Форма бронирования не видима");
    }
}
