package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class RegisterPage {

    Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    public Locator registerAccountHeader() {
        return page.getByText("Register Account");
    }

    public Locator firstNameTextField() {
        return page.getByPlaceholder("First Name");
    }

    public Locator lastNameTextField() {
        return page.getByPlaceholder("Last Name");
    }

    public Locator emailTextField() {
        return page.getByPlaceholder("E-Mail");
    }

    public Locator passwordTextField() {
        return page.getByPlaceholder("Password");
    }

    public Locator continueButton() {
        return page.getByText("Continue");
    }

    public Locator termsAndConditionToggle() {
        return page.locator("[name='agree']");
    }

    public Locator accountCreatedText() {
        return page.getByText("Your Account Has Been Created!");
    }

    public void clickOnTermsAndConditionToggle() {
        termsAndConditionToggle().click();
    }

    public void enterFirstName(String firstName) {
        firstNameTextField().fill(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTextField().fill(lastName);
    }

    public void enterEmailId(String emailId) {
        emailTextField().fill(emailId);
    }

    public void enterPassword(String password) {
        passwordTextField().fill(password);
    }

    public void clickOnContinueButton() {
        continueButton().click();
    }

    public void isAccountCreated() {
        Assert.assertTrue(accountCreatedText().isVisible());
    }

}
