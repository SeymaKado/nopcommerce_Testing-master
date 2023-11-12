import Helper.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SpecialElements {
    public SpecialElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Register")
    public WebElement register;
    @FindBy(xpath = "//input[@id='gender-male']")
    public WebElement gender;
    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement lastName;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement day;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement month;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement year;
    @FindBy(xpath = "//input[@name='Email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='Company']")
    public WebElement company;
    @FindBy(xpath = "//input[@name='Password']")
    public WebElement password;
    @FindBy(xpath = "//input[@name='ConfirmPassword']")
    public WebElement confirmPassword;
    @FindBy(xpath = "//button[@name='register-button']")
    public WebElement registerBtn;
    @FindBy(xpath = "//div[text()='Your registration completed']")
    public WebElement complateReg;
    @FindBy(xpath = "//a[@class='button-1 register-continue-button']")
    public WebElement continueBtn;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']")
    public WebElement tabMenu;
    @FindBy(xpath = "(//a[text()='Gift Cards '])[1]")
    public WebElement giftCards;
    @FindBy(css = "div[class='item-grid']>div")
    public List<WebElement> giftCardList;
    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addToCardBtn;
    @FindBy(xpath = "//p[text()='Enter valid recipient name']")
    public WebElement validMsg;
    @FindBy(xpath = "//input[@class='recipient-name']")
    public WebElement recipientName;
    @FindBy(xpath = "//input[@class='recipient-email']")
    public WebElement recipientMail;
    @FindBy(xpath = "//input[@class='sender-name']")
    public WebElement yourName;
    @FindBy(xpath = "//input[@class='sender-email']")
    public WebElement yourMail;
    @FindBy(xpath = "//p[text()='The product has been added to your ']")
    public WebElement addedMsg;
    @FindBy(xpath = "(//a[text()='Computers '])[1]")
    public WebElement computers;
    @FindBy(xpath = "(//a[text()='Desktops '])[1]")
    public WebElement desktops;
    @FindBy(xpath = "//div//h2//a[text()='Build your own computer']")
    public WebElement buildComputer;
    @FindBy(css = "select[id='product_attribute_2']>option")
    public List<WebElement> ramList;
    @FindBy(xpath = "//input[@id='product_attribute_3_6']")
    public WebElement gb320;
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    public WebElement gb400;
    @FindBy(xpath = "//a[text()='Adobe Photoshop CS4']")
    public WebElement photoshop;


}
