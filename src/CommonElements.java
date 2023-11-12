import Helper.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.util.List;

public class CommonElements {
    public CommonElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
    List<WebElement> mainList;
    List<WebElement> subList;
    List<WebElement> productList ;
    By tabMenuElements = By.cssSelector("ul[class='top-menu notmobile']>li");
    By subMenuElements = By.cssSelector("ul[class='sublist first-level']>li>a");
    By productListElements = By.xpath("//h2[@class='product-title']//a");
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    public WebElement mainPageBtn;
    @FindBy(linkText = "Log in")
    public WebElement loginLink;
    @FindBy(xpath = "//div//input[@class='email']")
    public WebElement loginEmail;
    @FindBy(xpath = "//div//input[@class='password']")
    public WebElement loginPassword;
    @FindBy(xpath = "//div//button[@class='button-1 login-button']")
    public WebElement loginBtn;
    @FindBy(xpath = "//div//a[@class='ico-account']")
    public WebElement verifyLogin;
    @FindBy(xpath = "//form//div[@class='message-error validation-summary-errors']")
    public WebElement errorMessage;
    @FindBy(css = "ul[class='top-menu notmobile']>li")
    public List<List<List<WebElement>>> tabMenuList;
    @FindBy(css = "ul[class='top-menu notmobile']>li>ul>li")
    public List<List<WebElement>> tabSubMenuList;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//li//a")
    public WebElement computersTabElement;
    @FindBy(xpath = "(//ul[@class='sublist first-level']//li//a)[2]")
    public WebElement notebooksCompElement;
    @FindBy(xpath = "//input[@aria-label='Search store']")
    public WebElement searchText;
    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;
    @FindBy(css = "div[class='page-title']>h1")
    public WebElement titleCtrl;
    @FindBy (xpath = "//h2[@class='product-title']//a")
    public WebElement product;
    @FindBy (xpath = "//div[@class='product-name']//h1")
    public WebElement productTitleCtrl;
    @DataProvider(name = "loginData")
    public static Object[][] loginInformations(){
        return new Object[][]{
                {"fqxhtd93sm@example.com","26595724", false},
                {"fdbntd13sm@example.com","26595725", false},
                {"fqxolk73sm@example.com","26595726", false},
                {"whbhtd63sm@example.com","26595727", false},
                {"fqxhtp89sm@example.com","26595728", false},
                {"fvbnrd03sm@example.com","26595729", false},
                {"Burnage_Logan@example.com","123qwe456asd7", true},
        };
    }
}
