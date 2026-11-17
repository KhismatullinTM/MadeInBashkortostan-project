package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderBarComponent {

    SelenideElement profileButton = $(".nav-link[href='/exporter-area/']");

    @Step("Клик по кнопке профиля пользователя")
    public void clickProfileButton() {
        profileButton.shouldBe(visible)
                .click();
    }
}
