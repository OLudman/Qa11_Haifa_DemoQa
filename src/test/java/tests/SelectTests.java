package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        app.getSelect().selectItemWidgets();
        app.getSelect().selectItemSelect();
    }

    @Test
    public void selectColors(){
        app.getSelect().selectColor("Blue");
        app.getSelect().pause(3000);
        app.getSelect().selectColor("Red");
        app.getSelect().pause(3000);
    }

    @Test
    public void selectCars(){
        app.getSelect().multiSelectCars("volvo, saab, opel");
        app.getSelect().pause(3000);
    }
}
