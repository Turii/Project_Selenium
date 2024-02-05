package tests;

import model.JuiceShopLoginPage;
import model.JuiceShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JuiceShopTest extends BaseTest{

    @Test
    public void testLogin() {
        final String EMAIL = System.getProperty("JUICE_SHOP_EMAIL");
        final String PASSWORD = System.getProperty("JUICE_SHOP_PASSWORD");

        getDriver().get("https://www.saucedemo.com/");
        String firstProduct = new JuiceShopLoginPage(getDriver())
                .enterLogin(EMAIL)
                .enterPassword(PASSWORD)
                .loginUser()
                .getFirstProductButton();

        Assert.assertEquals(firstProduct, "Add to cart");
    }
}
