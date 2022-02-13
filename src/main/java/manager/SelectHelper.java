package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper extends HelperBase{
    public SelectHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemWidgets() {
        hideAds();
        hideFooter();
        click(By.xpath("//div[@class='category-cards']/div[4]"));
    }

    public void selectItemSelect() {
        hideFooter();
        click(By.xpath("//span[.='Select Menu']"));
    }

    public void multiSelectCars(String cars) {
        Select select = new Select(wd.findElement(By.id("cars")));
        if(select.isMultiple()){
            String[] all = cars.split(",");
            for (String s:all)
                switch (s){
                    case "volvo":
                        select.selectByValue("volvo");
                        break;
                    case "saab":
                        select.selectByValue("saab");
                        break;
                    case "opel":
                        select.selectByValue("opel");
                        break;
                    case "audi":
                        select.selectByValue("audi");
                        break;
                }

        }
    }

    public void selectColor(String color) {
        new Select(wd.findElement(By.id("oldSelectMenu"))).selectByVisibleText(color);
    }
}
