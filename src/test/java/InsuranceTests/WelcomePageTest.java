package InsuranceTests;

import org.testng.annotations.Test;
import ui.frameworkconstants.PlaywrightFactory;
import ui.functions.insurance.Welcome;

public class WelcomePageTest extends PlaywrightFactory {

    Welcome welcome;

    @Test(description = "Registering a new User",priority = 1)
    public void verifyRegistration() throws InterruptedException {
        welcome=new Welcome(getPage());
        welcome.register();
    }
    @Test(description = "Logging in as a existing user",priority = 2)
    public void verifyLogin() throws InterruptedException {
        welcome.login();
    }




}
