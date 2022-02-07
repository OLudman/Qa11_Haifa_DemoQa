package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        app.getAlert().selectItemAlert();
        app.getAlert().selectAlerts();
    }

    @Test
    public void clickAlert1(){
        app.getAlert().clickAlert1();
    }

    @Test
    public void waitAlert(){
        app.getAlert().clickAlert2();
        app.getAlert().pause(3000);
    }

    @Test
    public void clickConfirmButton(){
        app.getAlert().clickAlert3();
        app.getAlert().clickConfirmButton("Cancel");
        Assert.assertTrue(app.getAlert().getConfirmResult().contains("Cancel"));
    }

    @Test
    public void clickPromptBox(){
        app.getAlert().clickAlert4();
        app.getAlert().enterText("Accepted by Olga");
        app.getAlert().clickConfirmButton("Ok");
        Assert.assertTrue(app.getAlert().getPromptResult().contains("Accepted by Olga"));

    }

}
