package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.CookieContainerComponent;
import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CompaniesPage {

    CookieContainerComponent cookieContainerComponent = new CookieContainerComponent();

    private final SelenideElement companiesDropdown = $("#companies-section-dropdown");
    private final ElementsCollection companiesOptions = $$("#companies-section-dropdown option");
    private final ElementsCollection companyCards = $$(".company");
    private final ElementsCollection companyCategories = $$(".company__section");

    @Step("Открытие страницы компаний")
    public CompaniesPage openCompaniesPage() {
        open("/companies/");
        cookieContainerComponent.confirmUseCookie();
        return this;
    }

    @Step("Случайный выбор категории компаний")
    public String selectRandomCategory() {
        int randomIndex = new Random().nextInt(1, companiesOptions.size());
        String selectedCategory = companiesOptions.get(randomIndex).getText().trim();
        companiesDropdown.selectOption(randomIndex);
        return selectedCategory;
    }

    @Step("Проверка наличия компаний")
    public CompaniesPage checkCompaniesAreDisplayed() {
        companyCards.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("Проверка категории первой компании")
    public CompaniesPage checkFirstCompanyCategory(String category) {
        companyCategories.first().shouldHave(text(category));
        return this;
    }
}
