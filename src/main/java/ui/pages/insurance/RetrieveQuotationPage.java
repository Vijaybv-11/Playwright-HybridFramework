package ui.pages.insurance;

import com.microsoft.playwright.Page;

public class RetrieveQuotationPage {

    Page page;
    public RetrieveQuotationPage(Page page){
        this.page=page;
    }


    private static final String IDENTIFICATIONNUMBER_TEXTFIELD="identification number";
    private static final String RETRIEVE_BUTTON="#getquote";
    private static final String RETRIEVEQUOTATION_HEADER="Retrieve Quotation";


    public void enterIdentificationNumber(String identificationNumber){
        page.getByPlaceholder(IDENTIFICATIONNUMBER_TEXTFIELD).fill(identificationNumber);
    }

    public void clickOnRetrieveButton(){
        page.locator(RETRIEVE_BUTTON).click();
    }

    public boolean isRetrieveHeaderDisplayed(){
        return page.getByText(RETRIEVEQUOTATION_HEADER).isVisible();
    }

    public String getDetails(String detailsType){
       return page.locator("//b[text()='"+detailsType+"']/../..//td[2]").textContent();
    }


}
