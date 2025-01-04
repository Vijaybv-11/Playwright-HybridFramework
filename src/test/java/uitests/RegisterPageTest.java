package uitests;

import org.testng.annotations.Test;
import ui.frameworkconstants.PlaywrightFactory;
import ui.functions.MyAccount;

public class RegisterPageTest extends PlaywrightFactory {

    MyAccount myAccount;


    @Test(description = "")
    public void createAccount(){
        myAccount=new MyAccount(getPage());
        myAccount.registerUser();
    }

}
