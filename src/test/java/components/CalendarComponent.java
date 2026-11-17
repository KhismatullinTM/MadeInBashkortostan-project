package components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.ProfilePage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    private final SelenideElement calendarButton = $(".input-group-append");
    private final SelenideElement currentMonthButton = $(".bx-calendar-top-month");
    private final ElementsCollection calendarMonths = $$(".bx-calendar-month-content .bx-calendar-month");
    private final SelenideElement currentYearButton = $(".bx-calendar-top-year");
    private final SelenideElement birthYearInput = $(".bx-calendar-year-input");
    private final ElementsCollection calendarDays = $$(".bx-calendar-cell:not(.bx-calendar-date-hidden)")
                                                                                                    .filter(visible);

    @Step("Открытие календаря")
    public CalendarComponent openCalendar() {
        calendarButton.shouldBe(visible).click();
        return this;
    }

    @Step("Клик по кнопке текущего месяца")
    public CalendarComponent clickCurrentMonthButton() {
        currentMonthButton.shouldBe(visible)
                .click();
        return this;
    }

    @Step("Случайный выбор месяца")
    public CalendarComponent selectRandomMonth() {
        ElementsCollection months = calendarMonths
                .shouldHave(sizeGreaterThan(0))
                .snapshot();
        int randomIndex = ThreadLocalRandom.current().nextInt(months.size());
        months.get(randomIndex).click();
        return this;
    }

    @Step("Клик по кнопке текущий год")
    public CalendarComponent clickYearButton() {
        currentYearButton.shouldBe(visible)
                .click();
        return this;
    }

    @Step("Ввод случайного года рождения")
    public CalendarComponent setBirthYear() {
        int randomYear = ThreadLocalRandom.current().nextInt(1970, 2026);
        birthYearInput.shouldBe(visible).setValue(String.valueOf(randomYear));
        return this;
    }

    @Step("Случайный выбор дня")
    public String selectRandomDay() {
        ElementsCollection days = calendarDays
                .shouldHave(sizeGreaterThan(0))
                .snapshot();
        int randomIndex = ThreadLocalRandom.current().nextInt(days.size());
        SelenideElement randomDay = days.get(randomIndex);
        String selectedDay = randomDay.getText().trim();
        randomDay.click();
        return selectedDay;
    }

    @Step("Выбор случайной даты в календаре")
    public String setDateOfBirth() {
        openCalendar()
                .clickYearButton()
                .setBirthYear()
                .clickCurrentMonthButton()
                .selectRandomMonth();
                return selectRandomDay();
    }

}
