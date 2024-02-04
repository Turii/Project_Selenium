package tests;

import model.JuiceShopLoginPage;
import model.JuiceShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JuiceShopTest extends BaseTest{
    public static final String EMAIL = System.getenv("JUICE_SHOP_EMAIL");
    public static final String PASSWORD = System.getenv("JUICE_SHOP_PASSWORD");

    @Test
    public void testLogin() {
        getDriver().get("https://www.saucedemo.com/");
        String firstProduct = new JuiceShopLoginPage(getDriver())
                .enterLogin(EMAIL)
                //.enterLogin("standard_user")
                .enterPassword(PASSWORD)
                //.enterPassword("secret_sauce")
                .loginUser()
                .getFirstProductButton();

        Assert.assertEquals(firstProduct, "Add to cart");
    }
}
