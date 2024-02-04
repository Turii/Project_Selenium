package model;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JuiceShopPage extends BasePage{
    @FindBy(xpath = "//button[@aria-label='Open Sidenav']")
    private WebElement menuButton;

    @FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-backpack']")
    private WebElement addFirstProductButton;

    public JuiceShopPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstProductButton() {
        getWait5().until(ExpectedConditions.visibilityOf(addFirstProductButton));
        return addFirstProductButton.getText();
    }
}
