package uitests;

import org.testng.annotations.Test;
import ui.frameworkconstants.PlaywrightFactory;
import ui.functions.Home;

public class HomepageTest extends PlaywrightFactory {

    Home objHome;

    @Test(description = "Verification of Home Screen Components")
    public void verifyHome(){
        objHome=new Home(getPage());
        objHome.verifyHomeScreenComponents();
    }


}
