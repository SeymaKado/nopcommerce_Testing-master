import Helper.BaseDriver;
import org.testng.annotations.Test;

public class SmokeTestRunner extends BaseDriver {

    @Test(groups = {"Smoke"}, priority = 1)
    public void testUserRegistration() {
        SpecialElements se = new SpecialElements();
        driver.get("https://demo.nopcommerce.com/");
        myClick(se.register);
        myClick(se.gender);
        mySendkeys(se.firstName, "Logan");
        mySendkeys(se.lastName, "Burnage");
        mySelect(se.day, "17");
        mySelect(se.month, "May");
        mySelect(se.year, "1993");
        mySendkeys(se.email, "Burnage_Logan@example.com");
        mySendkeys(se.company, "Magnetic Plus");
        mySendkeys(se.password, "123qwe456asd7");
        mySendkeys(se.confirmPassword, "123qwe456asd7");
        myClick(se.registerBtn);
        verifyContainsText(se.complateReg, "completed");
        myClick(se.continueBtn);
    }

    @Test(groups = {"Smoke"}, priority = 3)
    public void loginTest() {
        CommonElements ce = new CommonElements();
        driver.get("https://demo.nopcommerce.com/");
        myClick(ce.loginLink);
        mySendkeys(ce.loginEmail, "Burnage_Logan@example.com");
        mySendkeys(ce.loginPassword, "123qwe456asd7");
        myClick(ce.loginBtn);
        verifyContainsText(ce.verifyLogin, "My account");
    }

    @Test(groups = {"Smoke"}, priority = 2, dataProvider = "loginData", dataProviderClass = CommonElements.class)
    public void negativeLoginTest(String email, String password, boolean isSuccessful) {
        CommonElements ce = new CommonElements();
        driver.get("https://demo.nopcommerce.com/");
        myClick(ce.loginLink);
        mySendkeys(ce.loginEmail, email);
        mySendkeys(ce.loginPassword, password);
        myClick(ce.loginBtn);
        if (!isSuccessful){
            verifyContainsText(ce.errorMessage, "unsuccessful");
        }else {
            verifyContainsText(ce.verifyLogin, "My account");
        }
    }
}
