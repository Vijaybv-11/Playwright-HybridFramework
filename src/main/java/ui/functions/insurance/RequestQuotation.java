package ui.functions.insurance;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import ui.pages.insurance.HomePage;
import ui.pages.insurance.RequestQuotationPage;

public class RequestQuotation {

    RequestQuotationPage requestQuotationPage;
    Page page;

    public RequestQuotation(Page page) {
        this.page = page;
    }


    public void verifyRequestQuotation() {
        new HomePage(page).clickOnTabs("Request Quotation");
        requestQuotationPage = new RequestQuotationPage(page);
        Assert.assertTrue(requestQuotationPage.isRequestQuotationHeaderDisplayed());
        requestQuotationPage.selectBreakdownCover("At home");
        requestQuotationPage.selectWindScreenRepair("YES");
        requestQuotationPage.enterIncidents("Hit and Run");
        requestQuotationPage.enterRegistration("KA51ji9009");
        requestQuotationPage.enterAnnualMileage("700");
        requestQuotationPage.estimatedValue("1000000");
        requestQuotationPage.selectParkingLocation("Private Property");
        requestQuotationPage.selectYear("2023");
        requestQuotationPage.selectMonth("December");
        requestQuotationPage.selectDay("10");
        requestQuotationPage.clickOnCalculatePremium();
        Assert.assertTrue(page.locator(requestQuotationPage.getPREMIUM_AMOUNT_TEXT()).isVisible());
        System.out.println(requestQuotationPage.getPremiumAmountText());

    }

}
