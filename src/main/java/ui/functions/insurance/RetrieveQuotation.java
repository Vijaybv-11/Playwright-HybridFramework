package ui.functions.insurance;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import ui.pages.insurance.HomePage;
import ui.pages.insurance.RetrieveQuotationPage;

import static ui.functions.insurance.Welcome.insuranceProperty;

public class RetrieveQuotation {

    Page page;
    RetrieveQuotationPage retrieveQuotationPage;

    public RetrieveQuotation(Page page) {
        this.page = page;
    }

    public void verifyQuotation() {
        retrieveQuotationPage = new RetrieveQuotationPage(page);
        new HomePage(page).clickOnTabs("Retrieve Quotation");
        retrieveQuotationPage.enterIdentificationNumber(insuranceProperty.get("identificationNumber"));
        retrieveQuotationPage.clickOnRetrieveButton();
        Assert.assertTrue(retrieveQuotationPage.isRetrieveHeaderDisplayed());
        System.out.println(retrieveQuotationPage.getDetails("Breakdowncover"));
        System.out.println(retrieveQuotationPage.getDetails("Windscreenrepair"));
        System.out.println(retrieveQuotationPage.getDetails("user_id"));
        System.out.println(retrieveQuotationPage.getDetails("incidents"));
        System.out.println(retrieveQuotationPage.getDetails("Registration"));
        System.out.println(retrieveQuotationPage.getDetails("Annual mileage"));
        System.out.println(retrieveQuotationPage.getDetails("Estimated value"));
        System.out.println(retrieveQuotationPage.getDetails("Parking Location"));
        System.out.println(retrieveQuotationPage.getDetails("Start of policy"));


    }
}
