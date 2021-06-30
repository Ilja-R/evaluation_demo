package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralPage {

    private WebDriver driver;

    @FindBy(id = "registerButton")
    private WebElement registerButton;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "listUsersButton")
    private WebElement listUsersButton;

    @FindBy(id = "addAdminButton")
    private WebElement addAdminButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterButton() {
        clickElement(registerButton);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void clickListUsersButton() {
        clickElement(listUsersButton);
    }

    public void clickAddAdminButton() {
        clickElement(addAdminButton);
    }

}
