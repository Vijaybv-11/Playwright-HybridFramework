package ui.pages.insurance;

import com.microsoft.playwright.Page;

public class WelcomePage {

    Page page;

    public WelcomePage(Page page) {
        this.page = page;
    }

    private static final String EMAIL_TEXTFIELD = "#email";
    private static final String PASSWORD_TEXTFIELD = "#password";
    private static final String IMAGE = "//div[@class='header']";
    private static final String LOGIN_BUTTON = "//input[@type='submit']";
    private static final String REGISTER_BUTTON = "Register";

    public void enterEmailAddress(String emailId) {
        page.locator(EMAIL_TEXTFIELD).fill(emailId);
    }

    public void enterPassword(String password) {
        page.locator(PASSWORD_TEXTFIELD).fill(password);
    }

    public boolean isImageDisplayed() {
        return page.locator(IMAGE).isVisible();
    }

    public void clickOnLogin() {
        page.locator(LOGIN_BUTTON).click();
    }

    public void clickOnRegisterButton() {
        page.getByText(REGISTER_BUTTON).click();
    }

}
