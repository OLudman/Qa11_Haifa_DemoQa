package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class AlertHelper extends HelperBase{
    public AlertHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemAlert() {
        click(By.xpath("//a[@id='close-fixedban']"));
        click(By.cssSelector(".category-cards div.card:nth-child(3)"));
    }

    public void selectAlerts(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
//        click(By.xpath("//span[text()='Alerts']"));
        click(By.xpath("//*[text()='Alerts']"));
//        click(By.cssSelector(".accordion div.element-group:nth-child(3)"));
//        click(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
//        click(By.cssSelector(".accordion div.element-group:nth-child(3) li:nth-child(2)"));
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

    public String getPromptResult() {
        String text = wd.findElement(By.id("promptResult")).getText();
        System.out.println(text);
        return text;
    }

    public void enterText(String text) {
        wd.switchTo().alert().sendKeys(text);

    }

    public void clickAlert4() {
        click(By.id("promtButton"));
    }
}
