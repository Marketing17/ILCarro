package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String from, String to) {
        fillCity(city);
        selectPeriod(from, to);
    }
//
//    private void selectPeriod(String start, String end) {
//        // "08/29/2022 - 08/31/2022"
//        String[] startDate = start.split("/");
//        String[] endDate = end.split("/");
//        click(By.id("dates"));
//
////        String locatorStart = "//div[.='29']";
////        String locatorStart = "//div[.='"+startDate[1]+"']";
//        String locatorStart = String.format("//div[.=' %s ']",startDate[1]);
//        String locatorEnd = String.format("//div[.=' %s ']",endDate[1]);
//
//        click(By.xpath(locatorStart));
//        click(By.xpath(locatorEnd));
//
//    }

    private void selectPeriod(String start, String end) {
        // "12/25/2022 - 12/31/2022"
        String[] startDate = start.split("/");
        String[] endDate = end.split("/");
        int nowToStartMonth = 0;
        if(LocalDate.now().getMonthValue()!=Integer.parseInt(startDate[0])){
            nowToStartMonth = Integer.parseInt(startDate[0])-LocalDate.now().getMonthValue();
        }

        int startToEndMonth = 0;
        if(Integer.parseInt(startDate[0])!=Integer.parseInt(endDate[0])){
            startToEndMonth = Integer.parseInt(endDate[0])-Integer.parseInt(startDate[0]);
        }
        click(By.id("dates"));
        for(int i = 0; i < nowToStartMonth; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }

//        String locatorStart = "//div[.='29']";
//        String locatorStart = "//div[.='"+startDate[1]+"']";
        String locatorStart = String.format("//div[.=' %s ']",startDate[1]);
        String locatorEnd = String.format("//div[.=' %s ']",endDate[1]);

        click(By.xpath(locatorStart));
        click(By.xpath(locatorEnd));

    }

    public void fillCity(String city){
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public boolean isCarListAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }
}