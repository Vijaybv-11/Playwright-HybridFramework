package ui.functions;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import ui.pages.HomePage;

public class Home {

    HomePage homePage;
    Page page;

    public Home(Page page){
        this.page=page;
    }

    public void verifyHomeScreenComponents(){
        homePage= new HomePage(page);
        Assert.assertTrue(homePage.isOpenCartImageDisplayed());
        Assert.assertTrue(homePage.myAccountButton().isVisible());
        Assert.assertTrue(homePage.wishlistLink().isVisible());
        Assert.assertTrue(homePage.shoppingCartLink().isVisible());
        Assert.assertTrue(homePage.checkoutButton().isVisible());

    }
}
