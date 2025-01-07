package ui.functions.insurance;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import ui.frameworkconstants.FilePaths;
import ui.pages.insurance.RegisterPage;
import ui.pages.insurance.WelcomePage;
import ui.utils.PropertyUtil;
import ui.utils.RandomGenerator;

import java.util.Map;

public class Welcome {

    WelcomePage welcomePage;
    Page page;
    String password,emailId;
    Map<String,String> insuranceProperty=PropertyUtil.getInsuranceProperties();
    public Welcome(Page page){
        this.page=page;
        welcomePage=new WelcomePage(page);
    }

    public void login() throws InterruptedException {
        Assert.assertTrue(welcomePage.isImageDisplayed());
        welcomePage.enterEmailAddress(insuranceProperty.get("email"));
        welcomePage.enterPassword(insuranceProperty.get("password"));
        welcomePage.clickOnLogin();
        Thread.sleep(5000);
    }

    public void register() throws InterruptedException {
        Assert.assertTrue(welcomePage.isImageDisplayed());
        welcomePage.clickOnRegisterButton();
        RegisterPage registerPage= new RegisterPage(page);
        registerPage.selectTitle("Mr");
        registerPage.enterFirstName(RandomGenerator.firstName());
        registerPage.enterSurName(RandomGenerator.lastName());
        registerPage.enterPhoneNumber(RandomGenerator.phoneNumber());
        registerPage.selectYear("1950");
        registerPage.selectMonth("January");
        registerPage.selectDay("10");
        registerPage.selectLicencePeriod("5");
        registerPage.selectOccupation("Lawyer");
        registerPage.enterAddress(RandomGenerator.address());
        registerPage.enterCountry(RandomGenerator.country());
        registerPage.enterCity(RandomGenerator.city());
        registerPage.enterPostCode(RandomGenerator.pinCode());
        emailId=RandomGenerator.emailId();
        registerPage.enterEmail(emailId);
         password=RandomGenerator.password();
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnCreate();
        PropertyUtil.updatePropertyWithoutEscapeCharacters(FilePaths.INSURANCE_PROPERTY,"email",emailId);
        PropertyUtil.updatePropertyWithoutEscapeCharacters(FilePaths.INSURANCE_PROPERTY,"password",password);
        Thread.sleep(5000);
    }



}
