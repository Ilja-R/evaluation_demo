package page;

import entitiy.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralPage {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signIn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(User user){
        login(user, true);
    }

    public void login(User user, boolean success) {
        fillField(userName, user.getEmail());
        fillField(password, user.getPassword());
        clickElement(signIn);
        if (!success) {
            driver.get("http://127.0.0.1:8080/");
        }
    }
}
