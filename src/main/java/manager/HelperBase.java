package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type (By locator, String text){
        if(text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    // 1000ms = 1sec
    public void pause( int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public String elementGetText(By locator){
        System.out.println(wd.findElement(locator).getText());
        return wd.findElement(locator).getText();
    }

    public void hideFooter(){
        JavascriptExecutor executor = (JavascriptExecutor)this.wd;
        executor.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void hideAds(){
        click(By.id("close-fixedban"));
    }

    public void select(By locator, String option){
        //tagName select
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);
        //select.selectByIndex(2);
        //select.selectByVisibleText(option);
    }

}
