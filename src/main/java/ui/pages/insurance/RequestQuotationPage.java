package ui.pages.insurance;

import com.microsoft.playwright.Page;

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


    public void selectWindScreenRepair(String yesOrNo) {
        page.locator("//div[@class='field']//label[text()='" + yesOrNo + "']").click();
    }
}
