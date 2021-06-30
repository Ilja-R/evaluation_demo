package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtils;

public class ProfilePage extends GeneralPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/profile/edit']")
    private WebElement editProfile;

    @FindBy(id = "deactivate")
    private WebElement deactivate;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "datePicker")
    private WebElement datePicker;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//input[@value='Logout']")
    private WebElement logout;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUserData(String firstName, String lastName, String birthDate){
        clickElement(editProfile);
        fillField(this.firstName, firstName);
        fillField(this.lastName, lastName);
        fillField(this.datePicker, birthDate);
        clickElement(submit);
        TestUtils.pauseTest(2000);
    }

    public void deactivateUser() {
        clickElement(deactivate);
        driver.switchTo().alert().accept();
    }

    public void logout(){
        clickElement(logout);
    }

}
