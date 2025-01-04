package ui.functions;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import ui.pages.HomePage;
import ui.pages.RegisterPage;
import ui.utils.RandomGenerator;

public class MyAccount {

    RegisterPage registerPage;
    HomePage homePage;
    Page page;
    String firstName, lastName, emailId, password;

    public MyAccount(Page page) {
        this.page = page;
    }

    public void registerUser() {
        registerPage = new RegisterPage(page);
        homePage = new HomePage(page);
        homePage.clickOnMyAccount();
        homePage.clickMyAccountAction("Register");
        Assert.assertTrue(registerPage.registerAccountHeader().isVisible());
        firstName = RandomGenerator.firstName();
        registerPage.enterFirstName(firstName);
        lastName = RandomGenerator.lastName();
        registerPage.enterLastName(lastName);
        emailId = RandomGenerator.emailId();
        registerPage.enterEmailId(emailId);
        password = RandomGenerator.password();
        registerPage.enterPassword(password);
        registerPage.clickOnTermsAndConditionToggle();
        registerPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.accountCreatedText().isVisible());

    }
}
