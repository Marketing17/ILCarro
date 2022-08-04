package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase{


    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }

    public boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("h2")),
                                "some details"));
    }

    public void typeLocation(String address){
        type(By.id("pickUpPlace"),address);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public void fillCarForm(Car car) {
        if(isCarFormPresent()){
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());
            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());
            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceInclude());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());
        }
    }

    public void attachPhoto() {
    }
}