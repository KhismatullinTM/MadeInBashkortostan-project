package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.CookieContainerComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final CookieContainerComponent cookieContainerComponent = new CookieContainerComponent();

    private final SelenideElement profileTitle = $(".exporter-area__title");
    private final SelenideElement phoneInput = $("input[name='PERSONAL_PHONE']");
    private final SelenideElement saveButton = $("button[name='save']");
    private final SelenideElement alertSuccessSave = $(".allert .alert-success");

    @Step("Открытие страницы редактирования профиля экспортера")
    public ProfilePage openProfilePage() {
        open("/exporter-area/profile/");
        profileTitle.shouldHave(text("Редактирование профиля"));
        cookieContainerComponent.confirmUseCookie();
        return this;
    }

    @Step("Ввод номера телефона")
    public ProfilePage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Заполнение даты рождения в профиле")
    public ProfilePage setDateOfBirth() {
        calendarComponent.setDateOfBirth();
        return this;
    }

    @Step("Клик по кнопке сохранения изменений")
    public ProfilePage clickSaveButton() {
        saveButton.shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверка сохранения изменения данных экспортера")
    public ProfilePage checkSaveData() {
        alertSuccessSave.shouldBe(visible);
        return this;
    }


}
