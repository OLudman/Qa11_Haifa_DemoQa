package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    AlertHelper alert;
    SelectHelper select;


    public AlertHelper getAlert() {
        return alert;
    }

    public SelectHelper getSelect() {
        return select;
    }

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        alert = new AlertHelper(wd);
        select = new SelectHelper(wd);
    }
    public void stop(){
        wd.quit();
    }


}
