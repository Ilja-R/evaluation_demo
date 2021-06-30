package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends GeneralPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, '/users/edit')]")
    private List <WebElement> editButtons;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "municipality")
    private WebElement municipality;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@value='Logout']")
    private WebElement signOut;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void updateUser(int id){
        editButtons.get(id-1).click();
        fillField(country, "Testopia");
        fillField(municipality, "Testville");
        clickElement(submitButton);
    }

    public void signOut(){
        clickElement(signOut);
    }
}
