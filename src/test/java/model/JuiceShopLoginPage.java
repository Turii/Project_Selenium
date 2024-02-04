package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JuiceShopLoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@data-test='login-button']")
    private WebElement loginButton;

    /*@FindBy(xpath = "//a[@routerlink='/register']")
    private WebElement newUserLink;

    @FindBy(xpath = "//input[@id='emailControl']")
    private WebElement newUserEmailField;

    @FindBy(xpath = "//input[@id='passwordControl']")
    private WebElement newUserPasswordField;

    @FindBy(xpath = "//input[@id='repeatPasswordControl']")
    private WebElement newUserPasswordFieldRRepeat;

    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c22-12']")
    private WebElement securityQuestionDropdown;

    @FindBy(xpath = "//input[@id='securityAnswerControl']")
    private WebElement answer;

    @FindBy(xpath = "//input[@id='securityAnswerControl']")
    private WebElement registerButton;*/



    public JuiceShopLoginPage(WebDriver driver) {
        super(driver);
    }

    public JuiceShopLoginPage enterLogin(String login) {
        getWait5().until(ExpectedConditions.visibilityOf(emailField)).clear();
        emailField.sendKeys(login);
        //getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(login);
        System.out.println("Email:????????????????????????????????????????????????????????????????????????????? " + login);
        //emailField.sendKeys("o.turij@gmail.com");
        return this;
    }

    public JuiceShopLoginPage enterPassword(String password) {
        getWait5().until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
        //passwordField.sendKeys("123456");
        //getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        return this;
    }

    public JuiceShopPage loginUser() {
        loginButton.click();

        return new JuiceShopPage(getDriver());
    }


    /*public JuiceShopLoginPage selectFirstSecurityQuestion() {
        securityQuestionDropdown.click();
        WebElement firstQuestion = getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option[1]")));
        firstQuestion.click();
        return this;
    }

    public JuiceShopLoginPage registerUser(String login, String password) {
        newUserLink.click();
        getWait5().until(ExpectedConditions.visibilityOf(newUserEmailField)).sendKeys(login);
        newUserPasswordField.sendKeys(password);
        newUserPasswordFieldRRepeat.sendKeys(password);

        selectFirstSecurityQuestion();

        answer.click();
        answer.sendKeys("myAnswer");

        registerButton.click();

        return this;
    }

    public JuiceShopPage loginToJuiceShop(String email, String password) {
        enterLogin(email);
        enterPassword(password);

        try {
            loginButton.click();
            return new JuiceShopPage(getDriver());
        } catch (Exception e) {
            registerUser(email, password);
        }

        return new JuiceShopPage(getDriver());
    }

    public String loginButtonNae() {
        return loginButton.getText();*/


}
