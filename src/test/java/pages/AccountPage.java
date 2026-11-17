package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AccountPage {

    private final ElementsCollection navigateTitle = $$(".big-nav__title");
    private final SelenideElement logoutProfileButton = $("a[href='/exporter-area/?logout=yes']");

    @Step("Проверка отображение страницы профиля пользователя")
    public AccountPage checkOpenedAccountPage() {
        navigateTitle.findBy(text("Ваши компании"))
                .shouldBe(visible);
        return this;
    }

    @Step("Переход до блока \"Профиль\"")
    public AccountPage goToAccountSettingBlock() {
        navigateTitle.findBy(text("Профиль"))
                .shouldBe(visible)
                .scrollTo();
        return this;
    }

    @Step("Клик по кнопке \"Выход из личного кабинета\"")
    public void clickLogoutButton() {
        logoutProfileButton.click();
    }

    @Step("Выход из личного кабинета")
    public AuthPage logoutOfAccount() {
        goToAccountSettingBlock()
                .clickLogoutButton();
        return new AuthPage();
    }
}
