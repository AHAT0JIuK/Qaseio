package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    protected String email = System.getProperty("email", PropertyReader.getProperty("email"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @BeforeMethod
    @Description("Настройка браузера")
    public void setup() {
        Configuration.timeout = 30000;
        Configuration.baseUrl = "https://app.qase.io";
        ChromeOptions options = new ChromeOptions();
        // увеличил таймаут потому что селенид ждет 30 секунд открытия страницы и падает
        Configuration.pageLoadTimeout = 120000;
        Configuration.browserCapabilities = options;
        // перенес в tests.BaseTest залогин чтобы сократить тесты
        open("/login");
        // start-maximized не работает поэтому расширяю окно на весь экран по другому
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(shadowCss("#deny", "#usercentrics-cmp-ui")).click(); // не принимаю куки
        $("[name=email]").setValue(email);
        $("[name=password]").setValue(password);
        $(byText("Sign in")).click();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterMethod
    @Description("Закрытие браузера")
    public void quit() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
