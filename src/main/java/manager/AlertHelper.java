package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelper extends HelperBase{
    public AlertHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemAlert() {
        click(By.xpath("//a[@id='close-fixedban']"));
        click(By.xpath("//h5[.='Alerts, Frame & Windows']"));
    }

    public void selectAlerts(){
        click(By.xpath("//*[text()='Alerts']"));
    }

    public void clickAlert1(){
        click(By.id("alertButton"));
        pause(2000);
        wd.switchTo().alert().accept();
    }

    public void clickAlert2() {
        click(By.id("timerAlertButton"));
        WebDriverWait wait = new WebDriverWait(wd, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickAlert3() {
        click(By.id("confirmButton"));
    }

    public void clickConfirmButton(String text) {
        if(text!=null&&text.equals("Cancel")){
            wd.switchTo().alert().dismiss();
        }else if(text!=null&&text.equals("Ok")){
            wd.switchTo().alert().accept();
        }
    }

    public String getConfirmResult() {
        String text = wd.findElement(By.id("confirmResult")).getText();
        System.out.println(text);
        return text;
    }
}
