import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import testdata.TestData;

import static testdata.TestData.TEST_LOGIN;
import static testdata.TestData.TEST_PASSWORD;

public class MadeInBashkortostanTest extends TestBase{

    MainPage mainPage = new MainPage();
    AccountPage accountPage = new AccountPage();
    AuthPage authPage = new AuthPage();
    CompaniesPage companiesPage = new CompaniesPage();
    ProfilePage profilePage = new ProfilePage();
    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Авторизация на \"Made In Bashkortostan\"")
    public void successfulAuth() {
        mainPage.openMainPage()
                .goToAuthPage()
                .login(TEST_LOGIN, TEST_PASSWORD);

        accountPage.checkOpenedAccountPage();
    }

    @Test
    @DisplayName("Выход из профиля")
    public void successfulLogout() {
        mainPage.openMainPage()
                .goToAuthPage()
                .login(TEST_LOGIN, TEST_PASSWORD);
        accountPage.checkOpenedAccountPage()
                .logoutOfAccount();

        authPage.checkOpenAuthPage();
    }

    @Test
    @DisplayName("Проверка поиска компаний по категориям")
    public void randomCategorySearchTest() {
        companiesPage.openCompaniesPage();

        String selectedCategory = companiesPage.selectRandomCategory();

        companiesPage.checkFirstCompanyCategory(selectedCategory);
    }

    @Test
    @DisplayName("Смена личных данных экспортера")
    public void editProfileData() {
        mainPage.openMainPage()
                .goToAuthPage()
                .login(TEST_LOGIN, TEST_PASSWORD);

        profilePage.openProfilePage()
                .setPhone(testData.userPhoneNumber)
                .setDateOfBirth()
                .clickSaveButton()
                .checkSaveData();
    }

    @Test
    @DisplayName("Регистрация экспортера")
    public void SuccessfulRegistrationExporter() {
        registrationPage.openRegistrationPage()
                .setName(testData.userFirstName)
                .setLastName(testData.userLastName)
                .setSecondName(testData.userSecondName)
                .setEmail(testData.userEmail)
                .setPassword(TestData.TEST_PASSWORD)
                .setConfirmPassword(TestData.TEST_PASSWORD)
                .acceptAgreement()
                .clickRegisterButton();

        accountPage.checkOpenedAccountPage();
    }
}
