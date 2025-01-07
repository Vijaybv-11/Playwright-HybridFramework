package ui.pages.insurance;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private final String SIGNEDIN_EMAIL_TEXT = "//div[@class='content']//h4";
    private final String LOGOUT_BUTTON = "//input[@value='Log out']";

    public void clickOnTabs(String tagName) {
        page.locator("//a[text()='" + tagName + "']").click();
    }

    public String getSignedInEmail() {
        return page.locator(SIGNEDIN_EMAIL_TEXT).textContent();
    }

    public void clickOnLogoutButton() {
        page.locator(LOGOUT_BUTTON).click();
    }

}
