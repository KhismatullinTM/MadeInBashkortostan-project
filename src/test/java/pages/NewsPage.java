package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.CookieContainerComponent;
import io.qameta.allure.Step;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NewsPage {

    CookieContainerComponent cookieContainerComponent = new CookieContainerComponent();

    private final SelenideElement newsTitle = $(".page-section__title");
    private final ElementsCollection newsBanners = $$(".news");

    @Step("Открытие страницы новостей")
    public NewsPage openNewsPage() {
        open("/news/");
        newsTitle.shouldHave(text("Новости"));
        cookieContainerComponent.confirmUseCookie();
        return this;
    }

    @Step("Переход по случайной новости")
    public NewsPage clickRandomNews() {
        ElementsCollection banners = newsBanners
                .filter(visible)
                .shouldHave(sizeGreaterThan(0))
                .snapshot();

        int randomIndex = ThreadLocalRandom.current().nextInt(banners.size());
        banners.get(randomIndex).click();
        return this;
    }


}
