package testcase;

import entitiy.Role;
import entitiy.User;
import org.openqa.selenium.chrome.ChromeOptions;
import page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestUtils;

import java.util.concurrent.TimeUnit;

public class EvaluationDemo {

    public static void main(String[] args) {

        // Ignore main() method structure, this was just briefly made as a demo to show functionality of other project
        // All other project structure is viable

        User user = new User("user1", "user1@test","nopassword", Role.USER);
        User user2 = new User ("user2", "user2@test", "nopassword", Role.USER);
        User admin = new User("admin", "admin@test","nopassword", Role.ADMIN);

        System.setProperty("webdriver.chrome.driver", "D:\\apps\\evaluation_integration\\src\\main\\resources\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        driver.get("http://127.0.0.1:8080/");
        TestUtils.pauseTest(5000);

        homePage.clickRegisterButton();
        registrationPage.createUser(user);
        homePage.clickRegisterButton();
        registrationPage.createUser(user2);
        homePage.clickRegisterButton();
        registrationPage.createUser(user, false);

        homePage.clickLoginButton();
        loginPage.login(user);

        profilePage.fillUserData("John", "Doe", "01/01/1990");
        profilePage.deactivateUser();

        homePage.clickLoginButton();
        loginPage.login(user, false);

        homePage.clickAddAdminButton();
        registrationPage.createUser(admin);
        homePage.clickListUsersButton();
        loginPage.login(admin);

        UsersPage usersPage = new UsersPage(driver);
        usersPage.updateUser(2);
        usersPage.signOut();

        homePage.clickLoginButton();
        loginPage.login(user2);
        TestUtils.pauseTest(5000);
        profilePage.logout();

        homePage.clickListUsersButton();
        loginPage.login(user2);

        TestUtils.pauseTest(10000);

        driver.quit();
    }
}
