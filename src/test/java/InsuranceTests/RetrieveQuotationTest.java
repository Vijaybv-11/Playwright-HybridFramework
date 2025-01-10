package InsuranceTests;

import org.testng.annotations.Test;
import ui.frameworkconstants.PlaywrightFactory;
import ui.functions.insurance.RetrieveQuotation;
import ui.functions.insurance.Welcome;

public class RetrieveQuotationTest extends PlaywrightFactory {

    @Test(priority = 1)
    public void login() throws InterruptedException {
        new Welcome(getPage()).login();
        System.gc();
    }
    @Test(dependsOnMethods ={"login"},priority = 2)
    public void retrieveQuotation(){
        RetrieveQuotation retrieveQuotation=new RetrieveQuotation(getPage());
        retrieveQuotation.verifyQuotation();
    }
}
