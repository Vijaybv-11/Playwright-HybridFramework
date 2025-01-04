package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class HomePage {
    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    
    public Locator openCartImage() {
        return page.locator("//img[@title='Your Store']");
    }

    public Locator wishlistLink() {
        return page.locator("//span[contains(text(),'List')]");
    }

    public Locator myAccountButton() {
        return page.getByText("My Account").first();
    }

    public Locator shoppingCartLink() {
        return page.getByText("Shopping Cart").first();
    }

    public Locator checkoutButton() {
        return page.getByText("Checkout").first();
    }

    public Locator searchTextField() {
        return page.getByPlaceholder("Search");
    }

    public Locator searchIcon() {
        return page.locator("//div[@id='search']//button");
    }


    public Locator getNavigationDropdown(String text) {
        return page.locator("//a[text()='" + text + "']");
    }

    public void clickMyAccountAction(String actionType) {
        page.getByText(actionType).click();
    }

    public boolean isOpenCartImageDisplayed() {
        return openCartImage().isVisible();
    }

    public void clickOnWishlist() {
        wishlistLink().click();
    }

    public void clickOnMyAccount() {
        myAccountButton().click();
    }

    public void clickOnCheckoutButton() {
        checkoutButton().click();
    }

    public void enterValuesIntoSearchTextField(String searchItems) {
        searchTextField().fill(searchItems);
    }

    public void clickOnSearchIcon() {
        searchIcon().click();
    }

}
