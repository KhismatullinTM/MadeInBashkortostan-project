package pages;

import components.CookieContainerComponent;
import components.HeaderBarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    HeaderBarComponent headerBarComponent = new HeaderBarComponent();
    CookieContainerComponent cookieContainerComponent = new CookieContainerComponent();

    @Step("Открытие главной страницы")
    public MainPage openMainPage() {
        open("/");
        cookieContainerComponent.confirmUseCookie();
        return this;
    }

    @Step("Переход на страницу авторизации")
    public AuthPage goToAuthPage() {
        headerBarComponent.clickProfileButton();
        return new AuthPage();
    }

}
