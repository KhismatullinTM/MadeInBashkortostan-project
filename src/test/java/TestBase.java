import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = System.getProperty("URL", "https://madeinbashkortostan.com");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
