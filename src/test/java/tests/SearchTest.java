package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchTest(){
//        app.getSearch().fillSearchForm("Haifa","08/29/2022","08/31/2022");
        app.getSearch().fillSearchForm("Haifa","12/25/2022","12/31/2022");
        app.getUser().submitForm();
        Assert.assertTrue(app.getSearch().isCarListAppeared());
    }

    @AfterMethod
    public void backToMain(){
        app.getSearch().click(By.cssSelector(".logo"));
    }

}