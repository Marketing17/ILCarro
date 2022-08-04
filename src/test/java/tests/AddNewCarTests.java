package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    // is logged? -> preCondition
    // open form
    // fiil form + model Car
    // attach photo + image
    // submit form

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()==false){
            app.getUser().login(new User()
                    .withEmail("asd@fgh.com")
                    .withPassword("$Asdf1234"));
        }
    }

    @Test
    public void addNewCarTestPositive(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Haifa")
                .make("KIA")
                .model("Sportage")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("5")
                .clasS("C")
                .fuelConsumption("8.9")
                .carRegNumber("100-200-" + i)
                .price("150")
                .distanceInclude("500")
                .typeFeature("Climate control")
                .about("Like new")
                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
//        app.getCar().attachPhoto();
//        app.getUser().submitForm();
    }
}