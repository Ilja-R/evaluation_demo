package page;

import entitiy.Role;
import entitiy.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtils;

public class RegistrationPage extends GeneralPage {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "create")
    private WebElement create;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement homePage;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement cancelButton;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createUser(User user) {
        createUser(user, true);
    }

    public void createUser(User user, boolean success) {
        fillField(name, user.getName());
        fillField(email, user.getEmail());
        fillField(password, user.getPassword());
        clickElement(create);
        if (!success) {
            TestUtils.pauseTest(5000);
            clickElement(cancelButton);
        } else {
            if (user.getRole().equals(Role.USER)) {
                clickElement(homePage);
            }
        }
    }

}
