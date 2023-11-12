import Helper.BaseDriver;

import Helper.Function;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegressionTestRunner extends BaseDriver {
    CommonElements ce = new CommonElements();
    SpecialElements se = new SpecialElements();

    @Test(groups = {"Regression"}, priority = 1)
    public void tabMenuTestAndtabMenuProductTest() {
        CommonElements ce = new CommonElements();
        ce.mainList = driver.findElements(ce.tabMenuElements);
        for (int i = 0; i < ce.mainList.size(); i++) {
            myHover(ce.mainList.get(i));
            myClick(ce.mainList.get(i));
            ce.mainList = driver.findElements(ce.tabMenuElements);
            ce.subList = ce.mainList.get(i).findElements(ce.subMenuElements);
            ce.productList = driver.findElements(ce.productListElements);
            Assert.assertEquals(ce.mainList.get(i).getText().trim(), ce.titleCtrl.getText().trim());
            for (int j = 0; j < ce.subList.size(); j++) {
                if (!ce.subList.isEmpty()) {
                    myHover(ce.mainList.get(i));
                    myHover(ce.subList.get(j));
                    myClick(ce.subList.get(j));
                    ce.mainList = driver.findElements(ce.tabMenuElements);
                    ce.subList = ce.mainList.get(i).findElements(ce.subMenuElements);
                    ce.productList = driver.findElements(ce.productListElements);
                    String productStr = ce.productList.get(j).getAttribute("text").trim().toLowerCase();
                    Assert.assertEquals(ce.subList.get(j).getAttribute("text").trim().toLowerCase(),
                            ce.titleCtrl.getText().trim().toLowerCase());
                    mySendkeys(ce.searchText, ce.productList.get(j).getAttribute("text").trim());
                    myClick(ce.searchButton);
                    myClick(ce.product);
                    Assert.assertEquals(productStr, ce.productTitleCtrl.getText().trim().toLowerCase());
                    ce.mainList = driver.findElements(ce.tabMenuElements);
                    ce.subList = ce.mainList.get(i).findElements(ce.subMenuElements);
                    ce.productList = driver.findElements(ce.productListElements);
                }
            }
        }
        myJsClick(ce.mainPageBtn);
    }

    @Test(groups = {"Regression"}, priority = 2)
    public void giftOrderingTest() {
        CommonElements ce = new CommonElements();
        SpecialElements se = new SpecialElements();
        Assert.assertTrue(se.tabMenu.isDisplayed());
        myClick(se.giftCards);
        int random = Function.RandomGenerator(se.giftCardList.size());
        myClick(se.giftCardList.get(random));
        if (random == 0) {
            myJsClick(se.addToCardBtn);
            verifyContainsText(se.validMsg, "valid recipient");
            mySendkeys(se.recipientName, "Joe Doe");
            mySendkeys(se.recipientMail, "JoeDoe@example.com");
            mySendkeys(se.yourName, "Logan Burnage");
            mySendkeys(se.yourMail, "BurnageLogan@example.com");
        } else {
            myJsClick(se.addToCardBtn);
            verifyContainsText(se.validMsg, "valid recipient");
            mySendkeys(se.recipientName, "Joe Doe");
            mySendkeys(se.yourName, "Logan Burnage");
        }
        myJsClick(se.addToCardBtn);
        verifyContainsText(se.addedMsg, "added to your");
        myJsClick(ce.mainPageBtn);
    }

    @Test(groups = {"Regression"}, priority = 3)
    public void computerOrderingTest() {
        CommonElements ce = new CommonElements();
        SpecialElements se = new SpecialElements();
        Assert.assertTrue(se.tabMenu.isDisplayed());
        myHover(se.computers);
        myClick(se.desktops);
        myClick(se.buildComputer);
        boolean devam = true;
        while (devam) {
            int random = Function.RandomGenerator(se.ramList.size());
            if (random > 0 & random < 4) {
                myClick(se.ramList.get(random));
                devam = false;
            }
        }
        if (!se.gb320.isSelected()) {
            myClick(se.gb320);
        } else {
            myClick(se.gb400);
        }
        myClick(se.addToCardBtn);
        verifyContainsText(se.addedMsg, "added to your");
        myJsClick(ce.mainPageBtn);
    }

    @Test(groups = {"Regression"}, priority = 4)
    @Parameters("keyword")
    public void parameterizedSearchTest(String keyword) {
        CommonElements ce = new CommonElements();
        SpecialElements se = new SpecialElements();
        mySendkeys(ce.searchText, keyword);
        myClick(ce.searchButton);
        verifyContainsText(se.photoshop, "Photoshop");
        myJsClick(ce.mainPageBtn);
    }
}
