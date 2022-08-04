package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }

    public void fillLoginForm(User data) {
        type(By.id("email"), data.getEmail());
        type(By.id("password"), data.getPassword());
    }
    public void submitForm() {
        wd.findElement(By.cssSelector("[type='submit']")).submit();
    }

    public boolean isLogged() {
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        WebElement element = wd.findElement(By.xpath("//div[@class='dialog-container']"
//        ));
//        wait.until(ExpectedConditions.visibilityOf(element));
//        return element.getText().contains("success");
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void login(User user) {

        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(1000);

    }
}