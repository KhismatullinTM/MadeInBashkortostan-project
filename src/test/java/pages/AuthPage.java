package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private final SelenideElement authTitle = $(".auth-section-title");
    private final SelenideElement loginInput = $("input[name='USER_LOGIN']");
    private final SelenideElement passwordInput = $("input[name='USER_PASSWORD']");
    private final SelenideElement rememberMeCheckBox = $("label[for='USER_REMEMBER_frm']");
    private final SelenideElement loginSubmitButton = $("button[type='submit']");

    @Step("Проверка отображения страницы авторизации")
    public AuthPage checkOpenAuthPage() {
        authTitle.shouldBe(visible);
        return this;
    }

    @Step("Ввод логина")
    public AuthPage setLogin(String login) {
        loginInput.setValue(login);
        return this;
    }

    @Step("Ввод пароля")
    public AuthPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Активация чек-бокса \"Запомнить меня\"")
    public AuthPage selectCheckBoxRememberMe() {
        if (!rememberMeCheckBox.isSelected()) {
            rememberMeCheckBox.click();
        }
        return this;
    }

    @Step("Нажатие на кнопку \"Войти\"")
    public void clickSubmitButton() {
        loginSubmitButton.click();
    }

    @Step("Авторизация пользователя")
    public AccountPage login(String login, String password) {
        checkOpenAuthPage()
                .setLogin(login)
                .setPassword(password)
                .selectCheckBoxRememberMe()
                .clickSubmitButton();
        return new AccountPage();
    }

}
