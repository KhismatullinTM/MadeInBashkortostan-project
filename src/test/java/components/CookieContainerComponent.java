package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CookieContainerComponent {

    private final SelenideElement cookieContainer = $("#cookie");
    private final SelenideElement cookieButton = $("button.cookie-btn");

    @Step("Подтверждение использования cookie")
    public CookieContainerComponent confirmUseCookie() {
        if (cookieContainer.isDisplayed()) {
            cookieButton.shouldBe(visible, enabled).click();
            cookieContainer.shouldBe(hidden);
        }
        return this;
    }
}
