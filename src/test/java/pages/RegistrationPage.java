package pages;

import com.codeborne.selenide.SelenideElement;
import components.CookieContainerComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CookieContainerComponent cookieContainerComponent = new CookieContainerComponent();

    private final SelenideElement registrationTitle = $(".auth-section-title");
    private final SelenideElement nameInput = $("input[name='REGISTER[NAME]']");
    private final SelenideElement lastNameInput = $("input[name='REGISTER[LAST_NAME]']");
    private final SelenideElement secondNameInput = $("input[name='REGISTER[SECOND_NAME]']");
    private final SelenideElement emailInput = $("input[name='REGISTER[EMAIL]']");
    private final SelenideElement passwordInput = $("input[name='REGISTER[PASSWORD]']");
    private final SelenideElement confirmPasswordInput = $("input[name='REGISTER[CONFIRM_PASSWORD]']");
    private final SelenideElement checkBoxAgreement = $("label[for='UF_AGREEMENT']");
    private final SelenideElement registerButton = $("button[name='register_submit_button']");

    @Step("Открытие станицы регистрации экспортера")
    public RegistrationPage openRegistrationPage() {
        open("/exporter-area/?register=yes");
        registrationTitle.shouldBe(visible);
        cookieContainerComponent.confirmUseCookie();
        return this;
    }

    @Step("Ввод имени")
    public RegistrationPage setName(String name) {
        nameInput.shouldBe(visible).setValue(name);
        return this;
    }

    @Step("Ввод фамилии")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.shouldBe(visible).setValue(lastName);
        return this;
    }

    @Step("Ввод отчества")
    public RegistrationPage setSecondName(String secondName) {
        secondNameInput.shouldBe(visible).setValue(secondName);
        return this;
    }

    @Step("Ввод электронной почты")
    public RegistrationPage setEmail(String email) {
        emailInput.shouldBe(visible).setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public RegistrationPage setPassword(String password) {
        passwordInput.shouldBe(visible).setValue(password);
        return this;
    }

    @Step("Подтверждение пароля")
    public RegistrationPage setConfirmPassword(String password) {
        confirmPasswordInput.shouldBe(visible).setValue(password);
        return this;
    }

    @Step("Принятие пользовательского соглашения")
    public RegistrationPage acceptAgreement() {
        if (!checkBoxAgreement.isSelected()) {
            checkBoxAgreement.click();
        }
        return this;
    }

    @Step("Нажатие кнопки регистрации")
    public AccountPage clickRegisterButton() {
        registerButton.shouldBe(visible, enabled).click();
        return new AccountPage();
    }




}
