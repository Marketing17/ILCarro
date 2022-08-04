package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    String email = "asd@fgh.com";
    String password = "$Asdf1234";

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTestModel() {

//        String email = "asd@fgh.com";
//        String password = "$Asdf1234";

        // User data = new User("Joe","Dow","login","password");
        // data.setName("John");
        User data = new User().withEmail(email).withPassword(password);
        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();

        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginPositiveTestString() {

//        String email = "asd@fgh.com";
//        String password = "$Asdf1234";

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitForm();

        app.getUser().pause(3000);

        Assert.assertTrue(app.getUser().isLogged());
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}