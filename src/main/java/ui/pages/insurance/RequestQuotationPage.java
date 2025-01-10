package ui.pages.insurance;

import com.microsoft.playwright.Page;
import lombok.Getter;

public class RequestQuotationPage {
    Page page;

    public RequestQuotationPage(Page page) {
        this.page = page;
    }

    private static final String REQUESTQUOTATION_HEADER = "Request a quotation";
    private static final String BREAKDOWNCOVER_DROPDOW = "#quotation_breakdowncover";
    private static final String INCIDENTS_TEXTFIELD = "#quotation_incidents";
    private static final String REGISTRATION_TEXTFIELD = "#quotation_vehicle_attributes_registration";
    private static final String ANNUALMILEAGE_TEXTFIELD = "#quotation_vehicle_attributes_mileage";
    private static final String ESTIMATEDVALUE_TEXTFIELD = "#quotation_vehicle_attributes_value";
    private static final String PARKINGLOCATION_DROPDOWN = "#quotation_vehicle_attributes_parkinglocation";
    private static final String YEAR_DROPDOWN = "#quotation_vehicle_attributes_policystart_1i";
    private static final String MONTH_DROPDOWN = "#quotation_vehicle_attributes_policystart_2i";
    private static final String DAY_DROPDOWN = "#quotation_vehicle_attributes_policystart_3i";
    private static final String CALCULATEPREMIUM_BUTTON = "input[value='Calculate Premium']";
    private static final String SAVEQUOTATION_BUTTON = "input[value='Save Quotation']";
    @Getter
    private static final String PREMIUM_AMOUNT_TEXT="//p[@id='calculatedpremium']";
    private static final String IDENTIFICATION_NUMBER="//b[contains(text(), 'Your identification number is :')]/following-sibling::text()";


    public void selectWindScreenRepair(String yesOrNo) {
        page.locator("//div[@class='field']//label[text()='" + yesOrNo + "']").click();
    }

    public boolean isRequestQuotationHeaderDisplayed() {
        return page.getByText(REQUESTQUOTATION_HEADER).isVisible();
    }

    public void selectBreakdownCover(String breakdownCover) {
        page.locator(BREAKDOWNCOVER_DROPDOW).selectOption(breakdownCover);
    }

    public void enterIncidents(String incidents) {
        page.locator(INCIDENTS_TEXTFIELD).fill(incidents);
    }

    public void enterRegistration(String registration) {
        page.locator(REGISTRATION_TEXTFIELD).fill(registration);
    }

    public void enterAnnualMileage(String annualMileage) {
        page.locator(ANNUALMILEAGE_TEXTFIELD).fill(annualMileage);
    }

    public void estimatedValue(String estimatedValue) {
        page.locator(ESTIMATEDVALUE_TEXTFIELD).fill(estimatedValue);
    }


    public void selectParkingLocation(String parkingLocation) {
        page.locator(PARKINGLOCATION_DROPDOWN).selectOption(parkingLocation);
    }

    public void selectYear(String year) {
        page.locator(YEAR_DROPDOWN).selectOption(year);
    }

    public void selectMonth(String month) {
        page.locator(MONTH_DROPDOWN).selectOption(month);
    }

    public void selectDay(String day) {
        page.locator(DAY_DROPDOWN).selectOption(day);
    }

    public void clickOnCalculatePremium() {
        page.locator(CALCULATEPREMIUM_BUTTON).click();
    }

    public void clickOnSaveQuotation() {
        page.locator(SAVEQUOTATION_BUTTON).click();
    }

    public String getPremiumAmountText(){
        return page.locator(PREMIUM_AMOUNT_TEXT).textContent();
    }

    public String getIdentificationNumber(){
        return page.locator(IDENTIFICATION_NUMBER).textContent();
    }

}
